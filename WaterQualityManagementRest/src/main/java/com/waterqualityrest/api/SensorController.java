package com.waterqualityrest.api;

import com.waterqualityrest.dto.SensorDto;
import com.waterqualityrest.exception.SensorNotFoundException;
import lombok.RequiredArgsConstructor;
import com.waterqualityrest.service.SensorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class SensorController {

    private final SensorService sensorClient;

    //Get Sensor By Id
    @GetMapping("sensor/{id}")
    public SensorDto getSensorById(@PathVariable Long id) {
        try {
            return sensorClient.getSensorById(id);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Sensor Data for id : "+id+" Not Found!");
        }
    }

    //Get Sensor By Name
    @GetMapping("sensor")
    public SensorDto getSensorByName(@RequestParam(name = "sensorName") String parameter) {
        try {
            return sensorClient.getSensorByName(parameter);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Sensor Data for id : "+parameter+" Not Found!");
        }
    }

    //Get All Sensors
    @GetMapping("sensor/all")
    public List<SensorDto> getAllSensors() {
        return sensorClient.getAllSensors();
    }

    //Get Sensors By Status
    @GetMapping("sensor/list")
   public List<SensorDto> getSensorsByStatus(@RequestParam(name = "status") boolean status) {
        return sensorClient.getSensorsByStatus(status);
   }

   //Save(Post) New Sensor
   @PostMapping("sensor")
   public List<SensorDto> saveSensor(@RequestBody SensorDto sensorDto) {
       return sensorClient.saveSensor(sensorDto);
   }

   //Update(Put) Sensor
    @PutMapping("sensor")
    public List<SensorDto> updateSensor(@RequestBody SensorDto sensorDto) {
       return sensorClient.updateSensor(sensorDto);
    }

    //Update(Patch) Sensor
    @PatchMapping("sensor")
    public List<SensorDto> patchSensor(@RequestParam(name="sensorName") String name, @RequestParam String description) {
        return sensorClient.patchSensor(name, description);
    }

    //Delete Sensor By Name
    @DeleteMapping("sensor/{name}")
    public List<SensorDto> deleteSensor(@PathVariable String name) {
        return sensorClient.deleteSensor(name);
    }
}