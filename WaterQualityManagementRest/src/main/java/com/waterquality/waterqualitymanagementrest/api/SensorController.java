package com.waterquality.waterqualitymanagementrest.api;

import com.waterquality.waterqualitymanagementrest.dto.SensorDto;
import com.waterquality.waterqualitymanagementrest.exception.SensorDataInvalidException;
import com.waterquality.waterqualitymanagementrest.exception.SensorNotFoundException;
import com.waterquality.waterqualitymanagementrest.service.SensorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EDITOR')")
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
   public List<SensorDto> getAllSensorsByStatus(@RequestParam(name = "active") boolean active) {
        try {
            return sensorService.getAllSensorsByStatus(active);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Sensor Data With Active Status : " + active + " Not Found!");
        }
   }

   //Add(Post) New Sensor
   @PostMapping("sensor")
   @ResponseStatus(value = HttpStatus.ACCEPTED)
   @PreAuthorize("hasRole('ADMIN')")
   public List<SensorDto> addSensor(@Valid @RequestBody SensorDto sensorDto) {
        try {
            return sensorService.addSensor(sensorDto);
        }
        catch (Exception exception) {
            throw new SensorDataInvalidException("Error Saving New Sensor! Ensure Sensor is Formatted Correctly.");
        }
   }

   //Update(Put) Sensor
    @PutMapping("sensor")
    @PreAuthorize("hasRole('ADMIN')")
    public List<SensorDto> updateSensor(@Valid @RequestBody SensorDto sensorDto) {
       try {
           return sensorService.updateSensor(sensorDto);
       }
       catch (Exception exception) {
           throw new SensorDataInvalidException("Error Updating Sensor! Ensure Sensor Data is Formatted Correctly.");
       }
    }

    //Delete Sensor By Name
    @DeleteMapping("sensor/{sensorName}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteSensor(@PathVariable String sensorName) {
        try {
            sensorService.deleteSensor(sensorName);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Sensor With Name: " + sensorName + " Not Found!");
        }
    }
}