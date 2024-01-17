package com.waterqualityconsumer.waterqualitymanagementrestclient.service;

import com.waterqualityconsumer.waterqualitymanagementrestclient.dto.SensorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorClient {

    private final RestClient restClient;

    //Get By ID
    public SensorDto getById(Long id) {
        return restClient.get()
                .uri("/api/sensor/{id}",id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(SensorDto.class);
    }

    //Get By Name
    public SensorDto getByName(String name) {
        return restClient.get()
                .uri("/api/sensor?sensor_name={name}",name)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(SensorDto.class);
    }

    //Get all sensors
    public List<SensorDto> getAll() {
        return restClient.get()
                .uri("/api/sensor/all")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(List.class);
    }

    //Save(POST) new sensor
    public List<SensorDto> save() {

        SensorDto sensorDto = new SensorDto(5,"SNS-5",false,"Atlanta");

        return restClient.post()
                .uri("/api/sensor")
                .body(sensorDto)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(List.class);
    }

    //Update(PUT) sensor
    public List<SensorDto> update() {

        SensorDto sensorDto = new SensorDto(5,"SNS-5",true,"Atlanta");

        return restClient.put()
                .uri("/api/sensor")
                .body(sensorDto)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(List.class);
    }

    //Delete sensor by name
    public List<SensorDto> delete(String name) {
        return restClient.delete()
                .uri("api/sensor/{sensor_name}",name)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(List.class);
    }
}