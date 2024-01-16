package com.waterquality.waterqualitymanagementrest.service;

import com.waterquality.waterqualitymanagementrest.dto.ReportDto;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final RestClient restClient;

    //Get Sensor Report By Name
    public ReportDto getSensorReportByName(String sensorName) {
        return restClient.get()
                .uri("/api/sensor/report?sensorName={name}", sensorName)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(ReportDto.class);
    }

    //Get Sensor Report By Year
    public ReportDto getSensorReportByYear(String year) {
        return restClient.get()
                .uri("/api/sensor/report?year={year}", year)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(ReportDto.class);
    }

    //Get Sensor Report By Year & Month
    public ReportDto getSensorReportByMonth(String yearMonth) {
        return restClient.get()
                .uri("/api/sensor/report?year={year_month}", yearMonth)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(ReportDto.class);
    }
}