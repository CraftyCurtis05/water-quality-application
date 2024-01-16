package com.waterqualityconsumer.waterqualitymanagementrestclient.api;

import com.waterqualityconsumer.waterqualitymanagementrestclient.dto.SensorDto;
import com.waterqualityconsumer.waterqualitymanagementrestclient.service.SensorClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestRestClientController {

    private final SensorClient sensorClient;

    @GetMapping("/single")
    public SensorDto clientTest_one() {
        return  sensorClient.getById(1l);
        //   return sensorClient.getByName("SNS-3");
    }

    @GetMapping("/multiple")
    public List<SensorDto> clientTest_two() {
        //  return  sensorClient.getAll();

        //  return sensorClient.save();

        //  return sensorClient.update();

        return sensorClient.delete("SNS-5");
    }
}