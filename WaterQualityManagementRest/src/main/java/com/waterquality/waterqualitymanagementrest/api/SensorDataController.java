package com.waterquality.waterqualitymanagementrest.api;

import com.waterquality.waterqualitymanagementrest.dto.SensorDataDto;
import com.waterquality.waterqualitymanagementrest.exception.SensorDataInvalidException;
import com.waterquality.waterqualitymanagementrest.exception.SensorNotFoundException;
import com.waterquality.waterqualitymanagementrest.service.SensorDataService;
import jakarta.validation.Valid;
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
            return sensorDataService.getSensorDataById(sensorId);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Sensor Data For Sensor ID : " + sensorId + " Not Found!");
        }
    }

    //Get Sensor Data By Name
    @GetMapping("sensordata")
    public List<SensorDataDto> getSensorDataByName(@RequestParam(name = "sensorName") String sensorName) {
        try {
            return sensorDataService.getSensorDataByName(sensorName);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Sensor Data With Sensor Name : " + sensorName + " Not Found!");
        }
    }

    //Get Sensor Data List By Year & Month
    @GetMapping("sensordata/{sensorId}/{year}/{month}")
    public List<SensorDataDto> getSensorDataListByYearAndMonth(@PathVariable Long sensorId, @PathVariable String year, @PathVariable String month) {
        try {
            return sensorDataService.getBySensorAndYearAndMonth(sensorId, year, month);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Sensor Data With Sensor ID : " + sensorId + " In Year/Month " + year + "/" + month + " Not Found!");
        }
    }

    //Get Sensor Data By Year
    @GetMapping("sensordata/{sensorId}/{year}")
    public List<SensorDataDto> getSensorDataListByYear(@PathVariable Long sensorId, @PathVariable String year) {
        try {
            return sensorDataService.getSensorDataByYear(sensorId, year);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Sensor Data With Sensor ID : " + sensorId + " In Year " + year + " Not Found!");
        }
    }

    //Save(Post) Sensor Data
    @PostMapping("sensordata")
    public SensorDataDto saveSensorData(@Valid @RequestBody SensorDataDto sensorDataDto) {
        try {
            return sensorDataService.saveSensorData(sensorDataDto);
        }
        catch (Exception exception) {
            throw new SensorDataInvalidException("Error Saving New Sensor Data! Ensure Sensor Data is Formatted Correctly.");
        }
    }

    //Update(Put) Sensor Data
    @PutMapping("sensordata")
    public SensorDataDto updateSensorData(@Valid @RequestBody SensorDataDto sensorDataDto) {
        try {
            return sensorDataService.updateSensorData(sensorDataDto);
        }
        catch (Exception exception) {
            throw new SensorDataInvalidException("Error Updating Sensor Data! Ensure Sensor Data is Formatted Correctly.");
        }
    }

    //Delete Sensor Data By Sensor ID
    @DeleteMapping("sensordata/{sensorId}")
    public void deleteSensorData(@PathVariable Long sensorId) {
        try {
            sensorDataService.deleteSensorData(sensorId);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Sensor With ID : " + sensorId + " Not Found!");
        }
    }
}