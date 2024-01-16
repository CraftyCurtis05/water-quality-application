package com.waterquality.waterqualitymanagementrest.service;

import com.waterquality.waterqualitymanagementrest.dto.SensorDataDto;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorDataService {

    private final RestClient restClient;

    //Get Sensor Data By Id
    public SensorDataDto getSensorDataById(Long id) {
        return restClient.get()
                .uri("/api/sensordata/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(SensorDataDto.class);
    }

    //Get Sensor Data By Name
    public SensorDataDto getSensorDataByName(String name) {
        return restClient.get()
                .uri("/api/sensordata?sensor_name={name}", name)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(SensorDataDto.class);
    }

    //Get Sensors By Year
    public SensorDataDto getSensorDataByYear(String year) {
        return restClient.get()
                .uri("/api/sensordata?year={year}", year)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(SensorDataDto.class);
    }

    //Get Sensors By Year & Month
    public SensorDataDto getSensorDataByMonth(String yearMonth) {
        return restClient.get()
                .uri("/api/sensordata?year_month={year_month}", yearMonth)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(SensorDataDto.class);
    }

    //Save(Post) Sensor Data
    public List<SensorDataDto> saveSensorData(SensorDataDto sensorDataDto) {
        //SensorDataDto sensorDataDto = new SensorDataDto(5,"SNS-5", "iron","2015", "february", .06);

        return restClient.post()
                .uri("/api/sensordata")
                .body(sensorDataDto)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(List.class);
    }

    //Update(Put) Sensor Data
    public List<SensorDataDto> updateSensorData(SensorDataDto sensorDataDto) {
        //SensorDataDto sensorDataDto = new SensorDataDto(5,"SNS-5", "iron","2019", "march", .06);

        return restClient.put()
                .uri("/api/sensordata")
                .body(sensorDataDto)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(List.class);
    }

    //Delete Sensor Data By Name
    public List<SensorDataDto> deleteSensorData(String name) {

        return restClient.delete()
                .uri("api/sensordata/{sensor_name}",name)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(List.class);
    }
}