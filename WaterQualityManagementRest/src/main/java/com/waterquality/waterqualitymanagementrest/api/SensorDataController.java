package com.waterquality.waterqualitymanagementrest.api;

import com.waterquality.waterqualitymanagementrest.dto.SensorDataDto;
import com.waterquality.waterqualitymanagementrest.exception.SensorDataInvalidException;
import com.waterquality.waterqualitymanagementrest.exception.SensorNotFoundException;
import com.waterquality.waterqualitymanagementrest.service.SensorDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class SensorDataController {

    private final SensorDataService sensorDataService;

    //Get Sensor Data By Id
    @GetMapping("/sensordata/{id}")
    public SensorDataDto getSensorDataById(@PathVariable Long id) {
        try {
            return sensorDataService.getSensorDataById(id);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Sensor Data For ID: " + id + " Not Found!");
        }
    }

    //Get Sensor Data By Name
    @GetMapping("/sensordata")
    public SensorDataDto getSensorDataByName(@RequestParam(name = "sensor_name") String name) {
        try {
            return sensorDataService.getSensorDataByName(name);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Sensor Data With Name: " + name + " Not Found!");
        }
    }

    //Get Sensors By Year
    @GetMapping("/sensordata/{year}")
    public SensorDataDto getSensorDataByYear(@PathVariable String year) {
        try {
            return sensorDataService.getSensorDataByYear(year);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Sensor Data In Year: " + year + " Not Found!");
        }
    }

    //Get Sensors By Year & Month
    @GetMapping("/sensordata/{year_month}")
    public SensorDataDto getSensorDataByMonth(@PathVariable("year_month") String yearMonth) {
        try {
            return sensorDataService.getSensorDataByMonth(yearMonth);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Sensor Data In Year/Month: " + yearMonth + " Not Found!");
        }
    }

    //Save(Post) Sensor Data
    @PostMapping("/sensordata")
    public List<SensorDataDto> saveSensorData(@RequestBody SensorDataDto sensorDataDto) {
        try {
            return sensorDataService.saveSensorData(sensorDataDto);
        }
        catch (Exception exception) {
            throw new SensorDataInvalidException("Error Saving New Sensor Data! Ensure Sensor Data is Formatted Correctly.");
        }
    }

    //Update(Put) Sensor Data
    @PutMapping("/sensordata")
    public List<SensorDataDto> updateSensorData(@RequestBody SensorDataDto sensorDataDto) {
        try {
            return sensorDataService.updateSensorData(sensorDataDto);
        }
        catch (Exception exception) {
            throw new SensorDataInvalidException("Error Updating Sensor Data! Ensure Sensor Data is Formatted Correctly.");
        }
    }

    //Delete Sensor Data By Name
    @DeleteMapping("sensordata/{name}")
    public List<SensorDataDto> deleteSensorData(@PathVariable String name) {
        try {
            return sensorDataService.deleteSensorData(name);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Data For Sensor With Name: " + name + " Not Found!");
        }
    }
}