package com.code.test.temperature.temperature.service;

import com.code.test.temperature.temperature.domain.ReturnWeatherInfoData;

import java.util.Map;
import java.util.Optional;

/**
 * @Classname TemperatureService
 * @Description TODO
 * @Date 5/28/21 5:23 PM
 * @Created by Xavier(XIE WEI)
 */
public interface TemperatureService {
    Map getProvince();

    Map getCity(String province);

    Map getCounty(String province, String city);

    Optional<Integer> getTemperature(String province, String city, String county);

    ReturnWeatherInfoData getTemperatureDate(String province, String city, String county);
}
