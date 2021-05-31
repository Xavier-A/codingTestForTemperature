package com.code.test.temperature.temperature.domain;

import lombok.Data;

/**
 * @Classname ReturnInfos
 * @Description TODO
 * @Date 5/28/21 6:06 PM
 * @Created by Xavier(XIE WEI)
 */
@Data
public class WeatherInfosDTO {
    private String cityid;
    private String city;
    private String WD;
    private String WS;
    private String SD;
    private String AP;
    private String WSE;
    private String time;
    private String Radar;
    private String isRadar;
    private String sm;
    private Double temp;
    private String njd;

    @Override
    public String toString() {
        return "WeatherInfosDTO{" +
                "cityid='" + cityid + '\'' +
                ", city='" + city + '\'' +
                ", WD='" + WD + '\'' +
                ", WS='" + WS + '\'' +
                ", SD='" + SD + '\'' +
                ", AP='" + AP + '\'' +
                ", WSE='" + WSE + '\'' +
                ", time='" + time + '\'' +
                ", Radar='" + Radar + '\'' +
                ", isRadar='" + isRadar + '\'' +
                ", sm='" + sm + '\'' +
                ", temp=" + temp +
                ", njd='" + njd + '\'' +
                '}';
    }
}
