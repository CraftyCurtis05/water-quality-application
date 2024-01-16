package com.waterquality.waterqualitymanagementrest.api;

import com.waterquality.waterqualitymanagementrest.dto.ReportDto;
import com.waterquality.waterqualitymanagementrest.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportClient;

    @GetMapping("/report")
    public ReportDto getSensorReportByName(@RequestParam(name = "sensorName") String parameter) {
        return reportClient.getSensorReportByName(parameter);
    }

    //Get Sensor Report By Year
    @GetMapping("/report/{year}")
    public ReportDto getSensorReportByYear(@PathVariable String year) {
        return reportClient.getSensorReportByYear(year);
    }

    //Get Sensor Report By Year & Month
    @GetMapping("/report/{year_month}")
    public ReportDto getSensorReportByMonth(@PathVariable("year_month") String yearMonth) {
        return reportClient.getSensorReportByMonth(yearMonth);
    }
}