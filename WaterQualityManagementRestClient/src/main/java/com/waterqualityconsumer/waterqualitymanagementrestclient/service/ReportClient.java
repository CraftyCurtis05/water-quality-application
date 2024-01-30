package com.waterqualityconsumer.waterqualitymanagementrestclient.service;

import com.waterqualityconsumer.waterqualitymanagementrestclient.dto.ReportDto;
import com.waterqualityconsumer.waterqualitymanagementrestclient.dto.SensorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class ReportClient {

    private final RestClient restClient;

    //Get Sensor Data Report By Name
    public ReportDto getSensorReportBySensorName(String sensorName) {
        return restClient.get()
                .uri("/api/sensor?sensorName={sensorName}", sensorName)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(ReportDto.class);
    }

    //Get Sensor Data Report By Year & Month
    public ReportDto getSensorReportByYearAndMonth(Long sensorId, String year, String month) {
        return restClient.get()
                .uri("/api/sensor/{sensorId}/{year}/{month}", sensorId, year, month)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(ReportDto.class);
    }

    //Get Sensor Data Report By Year
    public ReportDto getSensorReportByYear(Long sensorId, String year) {
        return restClient.get()
                .uri("/api/sensor/{sensorId}/{year}", sensorId, year)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(ReportDto.class);
    }
}