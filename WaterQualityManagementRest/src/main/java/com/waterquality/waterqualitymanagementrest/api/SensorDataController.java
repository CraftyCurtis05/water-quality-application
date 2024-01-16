package com.waterquality.waterqualitymanagementrest.api;

import com.waterquality.waterqualitymanagementrest.dto.SensorDataDto;
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
            throw new SensorNotFoundException("Sensor Data for id : "+ id +" Not Found!");
        }
    }

    //Get Sensor Data By Name
    @GetMapping("/sensordata")
    public SensorDataDto getSensorDataByName(@RequestParam(name = "sensorName") String parameter) {
        try {
            return sensorDataService.getSensorDataByName(parameter);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Sensor Data with name: " + parameter + " Not Found!");
        }
    }

    //Get Sensors By Year
    @GetMapping("/sensordata/{year}")
    public SensorDataDto getSensorDataByYear(@PathVariable String year) {
        try {
            return sensorDataService.getSensorDataByYear(year);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Sensor Data for year: " + year + " Not Found!");
        }
    }

    //Get Sensors By Year & Month
    @GetMapping("/sensordata/{year}/{month}")
    public SensorDataDto getSensorDataByMonth(@PathVariable("year") String year, @PathVariable("month") String month) {
        try {
            return sensorDataService.getSensorDataByMonth(year, month);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Sensor Data for month/year: " + month + "/" + year + " Not Found!");
        }
    }

    //Save(Post) Sensor Data
    @PostMapping("/sensordata")
    public List<SensorDataDto> saveSensorData(@RequestBody SensorDataDto sensorDataDto) {
        return sensorDataService.saveSensorData(sensorDataDto);
    }

    //Update(Put) Sensor Data
    @PutMapping("/sensordata")
    public List<SensorDataDto> updateSensorData(@RequestBody SensorDataDto sensorDataDto) {
        return sensorDataService.updateSensorData(sensorDataDto);
    }

    //Delete Sensor Data By Name
    @DeleteMapping("sensordata/{name}")
    public List<SensorDataDto> deleteSensorData(@PathVariable String name) {
        return sensorDataService.deleteSensorData(name);
    }
}