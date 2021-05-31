package com.code.test.temperature.temperature.controller;

import com.code.test.temperature.temperature.domain.ReturnWeatherInfoData;
import com.code.test.temperature.temperature.service.TemperatureService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname TemperatureController
 * @Description TODO
 * @Date 5/28/21 5:22 PM
 * @Created by Xavier(XIE WEI)
 */
@RestController
@RequestMapping("/codingTest")
public class TemperatureController {

    @Resource
    TemperatureService temperatureService;


    @GetMapping("/getTemperature")
    public ReturnWeatherInfoData getTemperature(@RequestParam("province")String province,
                                                @RequestParam("city")String city,
                                                @RequestParam("county")String county){
        return temperatureService.getTemperatureDate(province, city, county);
    }
}
