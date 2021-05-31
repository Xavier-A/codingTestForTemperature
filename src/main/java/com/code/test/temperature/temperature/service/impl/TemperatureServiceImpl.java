package com.code.test.temperature.temperature.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.code.test.temperature.temperature.domain.ReturnWeatherInfoData;
import com.code.test.temperature.temperature.service.TemperatureService;
import com.google.common.util.concurrent.RateLimiter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @Classname TemperatureServiceImpl
 * @Description TODO
 * @Date 5/28/21 5:37 PM
 * @Created by Xavier(XIE WEI)
 */
@Service
public class TemperatureServiceImpl implements TemperatureService {

    @Resource
    RestTemplate restTemplate;

    private final RateLimiter rateLimiter = RateLimiter.create(100);

    @Value("${codeTest.serverUrl}")
    private String serverUrl;

    @Override
    public Map getProvince() {
        String province = restTemplate.getForObject(serverUrl + "/data/city3jdata/china.html", String.class);
        return JSONObject.parseObject(province);
    }

    @Override
    public Map getCity(String province) {
        String city = restTemplate.getForObject(serverUrl + "/data/city3jdata/provshi/" + province + ".html", String.class);
        return JSONObject.parseObject(city);
    }

    @Override
    public Map getCounty(String province, String city) {
        String county = restTemplate.getForObject(serverUrl + "/data/city3jdata/station/" + province + city + ".html", String.class);
        return JSONObject.parseObject(county);
    }

    @Override
    @Retryable(value = Exception.class, maxAttempts = 3)
    public Optional<Integer> getTemperature(String province, String city, String county) {
        boolean tryAcquire = rateLimiter.tryAcquire(0, TimeUnit.MILLISECONDS);
        if (!tryAcquire) {
            return null;
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ReturnWeatherInfoData returnDate = this.getTemperatureDate(province, city, county);

        if (returnDate == null) {
            return Optional.empty();
        }

        return Optional.of(returnDate.getWeatherinfo().getTemp().intValue());
    }

    @Override
    public ReturnWeatherInfoData getTemperatureDate(String province, String city, String county) {

        Map provinces = this.getProvince();

        if (!provinces.keySet().contains(province)) {
            System.out.println("no province");
            return null;
        }

        Map cities = this.getCity(province);

        if (!cities.keySet().contains(city)) {
            System.out.println("no city");
            return null;
        }

        Map counties = this.getCounty(province, city);

        if (!counties.keySet().contains(county)) {
            System.out.println("no county");
            return null;
        }


        String returnDate = restTemplate.getForObject(serverUrl + "/data/sk/" + province + city + county + ".html", String.class);
        return JSONObject.parseObject(returnDate, ReturnWeatherInfoData.class);
    }
}
