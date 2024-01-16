package com.waterqualityrest.api;

import com.waterqualityrest.dto.ReportDto;
import lombok.RequiredArgsConstructor;
import com.waterqualityrest.service.ReportService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/sensor/")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportClient;

    @GetMapping("report")
    public ReportDto getSensorReportByName(@RequestParam(name = "sensorName") String parameter) {
        return reportClient.getSensorReportByName(parameter);
    }

    //Get Sensor Report By Year
    @GetMapping("report/{year}")
    public ReportDto getSensorReportByYear(@PathVariable String year) {
        return reportClient.getSensorReportByYear(year);
    }

    //Get Sensor Report By Year & Month
    @GetMapping("report/{year}/{month}")
    public ReportDto getSensorReportByMonth(@PathVariable("year") String year, @PathVariable("month") String month) {
        return reportClient.getSensorReportByMonth(year, month);
    }
}