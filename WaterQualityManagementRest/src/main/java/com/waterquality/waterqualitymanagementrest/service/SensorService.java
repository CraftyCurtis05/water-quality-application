package com.waterquality.waterqualitymanagementrest.service;

import com.waterquality.waterqualitymanagementrest.dto.SensorDto;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorService {

    private final RestClient restClient;

    //Get Sensor By Id
    public SensorDto getSensorById(Long id) {
        return restClient.get()
                .uri("/api/sensor/{id}",id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(SensorDto.class);
    }

    //Get Sensor By Name
    public SensorDto getSensorByName(String name) {
        return restClient.get()
                .uri("/api/sensor?sensor_name={name}",name)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(SensorDto.class);
    }

    //Get All Sensors
    public List<SensorDto> getAllSensors() {
        return restClient.get()
                .uri("/api/sensor/all")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(List.class);
    }

    //Get Sensors By Status
    public List<SensorDto> getSensorsByStatus(boolean isActive) {
        return restClient.get()
                .uri("/api/sensor/list")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(List.class);
    }

    //Save(Post) New Sensor
    public List<SensorDto> saveSensor(SensorDto sensorDto) {
        //SensorDto sensorDto = new SensorDto(5,"SNS-5",false,"Atlanta");

        return restClient.post()
                .uri("/api/sensor")
                .body(sensorDto)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(List.class);
    }

    //Update(Put) Sensor
    public List<SensorDto> updateSensor(SensorDto sensorDto) {
        //SensorDto sensorDto = new SensorDto(5,"SNS-5",true,"Atlanta");

        return restClient.put()
                .uri("/api/sensor")
                .body(sensorDto)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(List.class);
    }

    //Update(Patch) Sensor
    public List<SensorDto> patchSensor(String name, String description) {
        SensorDto sensorDto = new SensorDto(5,"SNS-5",false,"Atlanta");

        return restClient.patch()
                .uri("/api/sensor")
                .body(sensorDto)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(List.class);
    }

    //Delete Sensor By Name
    public List<SensorDto> deleteSensor(String name) {

        return restClient.delete()
                .uri("api/sensor/{sensor_name}",name)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(List.class);
    }
}