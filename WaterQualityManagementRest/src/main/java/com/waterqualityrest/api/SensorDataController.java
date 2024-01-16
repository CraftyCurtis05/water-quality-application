package com.waterqualityrest.api;

import com.waterqualityrest.dto.SensorDataDto;
import lombok.RequiredArgsConstructor;
import com.waterqualityrest.service.SensorDataService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sensor/")
@RequiredArgsConstructor
public class SensorDataController {

    private final SensorDataService sensorDataClient;

    //Get Sensor Data By Id
    @GetMapping("data/{id}")
    public SensorDataDto getSensorDataById(@PathVariable Long id) {
        return sensorDataClient.getSensorDataById(id);
    }

    //Get Sensor Data By Name
    @GetMapping("data")
    public SensorDataDto getSensorDataByName(@RequestParam(name = "sensorName") String parameter) {
        return sensorDataClient.getSensorDataByName(parameter);
    }

    //Get Sensors By Year
    @GetMapping("data/{year}")
    public SensorDataDto getSensorDataByYear(@PathVariable String year) {
        return sensorDataClient.getSensorDataByYear(year);
    }

    //Get Sensors By Year & Month
    @GetMapping("data/{year}/{month}")
    public SensorDataDto getSensorDataByMonth(@PathVariable("year") String year, @PathVariable("month") String month) {
        return sensorDataClient.getSensorDataByMonth(year, month);
    }

    //Save(Post) Sensor Data
    @PostMapping("data")
    public List<SensorDataDto> saveSensorData(@RequestBody SensorDataDto sensorDataDto) {
        return sensorDataClient.saveSensorData(sensorDataDto);
    }

    //Update(Put) Sensor Data
    @PutMapping("data")
    public List<SensorDataDto> updateSensorData(@RequestBody SensorDataDto sensorDataDto) {
        return sensorDataClient.updateSensorData(sensorDataDto);
    }

    //Delete Sensor Data By Name
    @DeleteMapping("data/{name}")
    public List<SensorDataDto> deleteSensorData(@PathVariable String name) {
        return sensorDataClient.deleteSensorData(name);
    }
}