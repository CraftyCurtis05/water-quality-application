package com.waterquality.waterqualitymanagementrest.api;

import com.waterquality.waterqualitymanagementrest.dto.SensorDto;
import com.waterquality.waterqualitymanagementrest.exception.SensorDataInvalidException;
import com.waterquality.waterqualitymanagementrest.exception.SensorNotFoundException;
import com.waterquality.waterqualitymanagementrest.service.SensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class SensorController {

    private final SensorService sensorService;

    //Get Sensor By Id
    @GetMapping("sensor/{sensorId}")
    public SensorDto getSensorById(@PathVariable Long sensorId) {
        try {
            return sensorService.getSensorById(sensorId);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Sensor Data For Sensor ID : " + sensorId + " Not Found!");
        }
    }

    //Get Sensor By Name
    @GetMapping("sensor")
    public SensorDto getSensorByName(@RequestParam(name = "sensorName") String sensorName) {
        try {
            return sensorService.getSensorByName(sensorName);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Sensor Data For Sensor Name : " + sensorName + " Not Found!");
        }
    }

    //Get All Sensors
    @GetMapping("sensor/all")
    public List<SensorDto> getListOfAllSensors() {
        try {
            return sensorService.getListOfAllSensors();
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Sensors Not Found!");
        }
    }

    //Get Sensors By Status
    @GetMapping("sensor/list")
   public List<SensorDto> getAllSensorsByStatus(@RequestParam(name = "status") boolean status) {
        try {
            return sensorService.getAllSensorsByStatus(status);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Sensor Data With Active Status : " + status + " Not Found!");
        }
   }

   //Add(Post) New Sensor
   @PostMapping("sensor")
   public List<SensorDto> addSensor(@RequestBody SensorDto sensorDto) {
        try {
            return sensorService.addSensor(sensorDto);
        }
        catch (Exception exception) {
            throw new SensorDataInvalidException("Error Saving New Sensor! Ensure Sensor is Formatted Correctly.");
        }
   }

   //Update(Put) Sensor
    @PutMapping("sensor")
    public List<SensorDto> updateSensor(@RequestBody SensorDto sensorDto) {
       try {
           return sensorService.updateSensor(sensorDto);
       }
       catch (Exception exception) {
           throw new SensorDataInvalidException("Error Updating Sensor! Ensure Sensor Data is Formatted Correctly.");
       }
    }

    //Update(Patch) Sensor Name & Description
    @PatchMapping("sensor")
     public List<SensorDto> patchSensor(@RequestParam(name="sensorName") String sensorName, @RequestParam String description) {
        try {
            return sensorService.patchSensor(sensorName, description);
        }
        catch (Exception exception) {
            throw new SensorDataInvalidException("Error Updating Sensor! Ensure Sensor Data is Formatted Correctly.");
        }
     }

    //Delete Sensor By Name
    @DeleteMapping("sensor/{sensorName}")
    public void deleteSensor(@PathVariable String sensorName) {
        try {
            sensorService.deleteSensor(sensorName);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Sensor With Name: " + sensorName + " Not Found!");
        }
    }
}