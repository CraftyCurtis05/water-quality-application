package com.waterquality.waterqualitymanagementrest.api;

import com.waterquality.waterqualitymanagementrest.dto.ReportDto;
import com.waterquality.waterqualitymanagementrest.exception.SensorDataNotFoundException;
import com.waterquality.waterqualitymanagementrest.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    //Get Sensor Data Report By Year
    @GetMapping("report/{sensorId}/{year}")
    public ReportDto getSensorReportByYear(@PathVariable Long sensorId, @PathVariable String year) {
        try {
            return reportService.findSensorReportByYear(sensorId, year);
        }
        catch (Exception exception) {
            throw new SensorDataNotFoundException("Sensor Data for Sensor ID : " + sensorId + " In Year : " + year + " Not Found!");
        }
    }

    //Get Sensor Data Report By Year & Month
    @GetMapping("report/{sensorId}/{year}/{month}")
    public ReportDto getSensorReportByYearAndMonth(@PathVariable Long sensorId, @PathVariable String year, @PathVariable String month) {
        try {
            return reportService.findSensorReportByYearAndMonth(sensorId, year, month);
        }
        catch (Exception exception) {
            throw new SensorDataNotFoundException("Sensor Data for Sensor ID : " + sensorId + " In Year/Month : " + year + "/" + month + " Not Found!");
        }
    }
}