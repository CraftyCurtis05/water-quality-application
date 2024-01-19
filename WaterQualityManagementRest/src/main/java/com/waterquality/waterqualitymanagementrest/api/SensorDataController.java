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
    @GetMapping("sensordata/{sensorId}")
    public SensorDataDto getSensorDataById(@PathVariable Long sensorId) {
        try {
            return sensorDataService.findSensorDataById(sensorId);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Sensor Data For Sensor ID : " + sensorId + " Not Found!");
        }
    }

    //Get Sensor Data By Name
    @GetMapping("sensordata")
    public SensorDataDto getSensorDataByName(@RequestParam(name = "sensorName") String sensorName) {
        try {
            return sensorDataService.findSensorDataByName(sensorName);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Sensor Data With Sensor Name : " + sensorName + " Not Found!");
        }
    }

    //Get Sensor Data List By Year & Month
    @GetMapping("sensordata/{sensorId}/{year}/{month}")
    public List<SensorDataDto> getSensorDataListByYearAndMonth(@PathVariable Long sensorId, @PathVariable String year, @PathVariable String month) {
        try {
            return sensorDataService.findSensorDataListByYearAndMonth(sensorId, year, month);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Sensor Data With Sensor ID : " + sensorId + " In Year/Month " + year + "/" + month + " Not Found!");
        }
    }

    //Save(Post) Sensor Data
    @PostMapping("sensordata")
    public List<SensorDataDto> saveSensorData(@RequestBody SensorDataDto sensorDataDto) {
        try {
            return sensorDataService.saveSensorData(sensorDataDto);
        }
        catch (Exception exception) {
            throw new SensorDataInvalidException("Error Saving New Sensor Data! Ensure Sensor Data is Formatted Correctly.");
        }
    }

    //Update(Put) Sensor Data
    @PutMapping("sensordata")
    public List<SensorDataDto> updateSensorData(@RequestBody SensorDataDto sensorDataDto) {
        try {
            return sensorDataService.updateSensorData(sensorDataDto);
        }
        catch (Exception exception) {
            throw new SensorDataInvalidException("Error Updating Sensor Data! Ensure Sensor Data is Formatted Correctly.");
        }
    }

    //Delete Sensor Data By Sensor ID
    @DeleteMapping("sensordata/{sensorId}")
    public List<SensorDataDto> deleteSensorData(@PathVariable Long sensorId) {
        try {
            return sensorDataService.deleteSensorData(sensorId);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Sensor With ID : " + sensorId + " Not Found!");
        }
    }
}