package com.waterqualityconsumer.waterqualitymanagementrestclient.service;

import com.waterqualityconsumer.waterqualitymanagementrestclient.dto.SensorDataDto;
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

    //Get Sensor By Id
    public SensorDto getSensorById(Long sensorId) {
        return restClient.get()
                .uri("/api/sensor/{sensorId}",sensorId)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(SensorDto.class);
    }

    //Get Sensor By Name
    public SensorDto getSensorByName(String sensorName) {
        return restClient.get()
                .uri("/api/sensor?sensor_name={name}",sensorName)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(SensorDto.class);
    }

    //Get All Sensors
    public List<SensorDto> getListOfAllSensors() {
        return restClient.get()
                .uri("/api/sensor/all")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(List.class);
    }

    //Get Sensors By Status
    public List<SensorDto> getAllSensorsByStatus(boolean active) {
        return restClient.get()
                .uri("/api/sensor/list")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(List.class);
    }

    //Add(Post) New Sensor
    public List<SensorDto> addSensor(SensorDto sensorDto) {

        return restClient.post()
                .uri("/api/sensor")
                .body(sensorDto)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(List.class);
    }

    //Update(Put) Sensor
    public List<SensorDto> updateSensor(SensorDto sensorDto) {

        return restClient.put()
                .uri("/api/sensor")
                .body(sensorDto)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(List.class);
    }

    //Delete Sensor By Name
    public List<SensorDto> deleteSensor(String sensorName) {

        return restClient.delete()
                .uri("api/sensor/{sensor_name}",sensorName)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(List.class);
    }
}