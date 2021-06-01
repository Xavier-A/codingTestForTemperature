package com.code.test.temperature.temperature;

import com.code.test.temperature.temperature.domain.ReturnWeatherInfoData;
import com.code.test.temperature.temperature.service.TemperatureService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TemperatureApplicationTests {

	@Autowired
	TemperatureService temperatureService;

	@Test
	public void getProvinceTest() {
		Map map = temperatureService.getProvince();
		System.out.println(map);
	}

	@Test
	public void getCityTest() {
		Map map = temperatureService.getCity("10119");
		System.out.println(map);
	}

	@Test
	public void getCountryTest() {
		Map map = temperatureService.getCounty("10119", "04");
		System.out.println(map);
	}

	@Test
	public void getWrongTemperatureTest() {
		Optional<Integer> temp = temperatureService.getTemperature("10119", "01", "111");
		if (temp.isPresent()) {
			System.out.println(temp.get());
		}
	}

	@Test
	public void getTemperatureDateTest() {
		ReturnWeatherInfoData returnDate = temperatureService.getTemperatureDate("10119", "04", "01");
		System.out.println(returnDate.toString());
	}

	@Test
	public void getTemperatureTest() {
		Optional<Integer> temp = temperatureService.getTemperature("10119", "04", "01");
		System.out.println(temp.get());
	}

	@Test
	public void tpsTest() {
		for (int i = 0; i < 200; i++) {
			Optional<Integer> temp = temperatureService.getTemperature("10119", "04", "01");
		}
	}
}
