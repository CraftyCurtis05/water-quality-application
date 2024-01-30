package com.waterqualityconsumer.waterqualitymanagementrestclient.service;

import com.waterqualityconsumer.waterqualitymanagementrestclient.dto.SensorDataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorDataClient {

    private final RestClient restClient;

    //Get Sensor Data By Id
    public List<SensorDataDto> getSensorDataById(Long sensorId) {
        return restClient.get()
                .uri("/api/sensordata/{sensorId}", sensorId)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(SensorDataDto.class);
    }

    //Get Sensor Data By Name
    public SensorDataDto getSensorDataByName(String sensorName) {
        return restClient.get()
                .uri("/api/sensordata?sensorName={sensorName}", sensorName)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(SensorDataDto.class);
    }

    //Get Sensor Data List By Year & Month
    public SensorDataDto getSensorDataListByYearAndMonth(Long sensorId, String year, String month) {
        return restClient.get()
                .uri("/api/sensordata/{sensorId}/{year}/{month}", sensorId, year, month)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(SensorDataDto.class);
    }

    //Get Sensor Data List By Year
    public SensorDataDto getSensorDataListByYear(Long sensorId, String year) {
        return restClient.get()
                .uri("/api/sensordata/sensorId}/{year}", year)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(SensorDataDto.class);
    }

    //Save(Post) Sensor Data
    public List<SensorDataDto> saveSensorData(SensorDataDto sensorDataDto) {

        return restClient.post()
                .uri("/api/sensordata")
                .body(sensorDataDto)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(List.class);
    }

    //Update(Put) Sensor Data
    public List<SensorDataDto> updateSensorData(SensorDataDto sensorDataDto) {

        return restClient.put()
                .uri("/api/sensordata")
                .body(sensorDataDto)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(List.class);
    }

    //Delete Sensor Data By Sensor ID
    public List<SensorDataDto> deleteSensorData(Long sensorId) {

        return restClient.delete()
                .uri("api/sensordata/{sensorId}", sensorId)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(List.class);
    }
}