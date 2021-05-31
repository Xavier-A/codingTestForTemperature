package com.code.test.temperature.temperature.domain;

import lombok.Data;

/**
 * @Classname ReturnWeatherInfoData
 * @Description TODO
 * @Date 5/28/21 6:25 PM
 * @Created by Xavier(XIE WEI)
 */
@Data
public class ReturnWeatherInfoData {
    private WeatherInfosDTO weatherinfo;
    @Override
    public String toString() {
        return "ReturnDate{" +
                "weatherinfo=" + weatherinfo +
                '}';
    }
}
