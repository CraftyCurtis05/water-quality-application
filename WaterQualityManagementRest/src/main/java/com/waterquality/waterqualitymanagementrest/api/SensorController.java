package com.waterquality.waterqualitymanagementrest.api;

import com.waterquality.waterqualitymanagementrest.dto.SensorDto;
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
    @GetMapping("/sensor/{id}")
    public SensorDto getSensorById(@PathVariable Long id) {
        try {
            return sensorService.getSensorById(id);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Sensor Data for id: " + id + " Not Found!");
        }
    }

    //Get Sensor By Name
    @GetMapping("/sensor")
    public SensorDto getSensorByName(@RequestParam(name = "sensorName") String parameter) {
        try {
            return sensorService.getSensorByName(parameter);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Sensor Data with name: " + parameter + " Not Found!");
        }
    }

    //Get All Sensors
    @GetMapping("/sensor/all")
    public List<SensorDto> getAllSensors() {
        try {
            return sensorService.getAllSensors();
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Sensor Data List Not Found!");
        }
    }

    //Get Sensors By Status
    @GetMapping("/sensor/list")
   public List<SensorDto> getSensorsByStatus(@RequestParam(name = "status") boolean status) {
        try {
            return sensorService.getSensorsByStatus(status);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Sensor Data for status: " + status + " Not Found!");
        }
   }

   //Save(Post) New Sensor
   @PostMapping("/sensor")
   public List<SensorDto> saveSensor(@RequestBody SensorDto sensorDto) {
        try {
            return sensorService.saveSensor(sensorDto);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Error Saving New Sensor!");
        }
   }

   //Update(Put) Sensor
    @PutMapping("/sensor")
    public List<SensorDto> updateSensor(@RequestBody SensorDto sensorDto) {
       try {
           return sensorService.updateSensor(sensorDto);
       }
       catch (Exception exception) {
           throw new SensorNotFoundException("Sensor id: " + sensorDto + " Not Found!");
       }
    }

    //Update(Patch) Sensor
    @PatchMapping("/sensor")
    public List<SensorDto> patchSensor(@RequestParam(name="sensorName") String name, @RequestParam String description) {
        try {
            return sensorService.patchSensor(name, description);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Sensor id: " + name + " Not Found!");
        }
    }

    //Delete Sensor By Name
    @DeleteMapping("/sensor/{name}")
    public List<SensorDto> deleteSensor(@PathVariable String name) {
        try {
            return sensorService.deleteSensor(name);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Sensor id: " + name + " Not Found!");
        }
    }
}