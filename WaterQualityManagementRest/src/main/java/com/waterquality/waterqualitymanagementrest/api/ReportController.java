package com.waterquality.waterqualitymanagementrest.api;

import com.waterquality.waterqualitymanagementrest.dto.ReportDto;
import com.waterquality.waterqualitymanagementrest.exception.SensorNotFoundException;
import com.waterquality.waterqualitymanagementrest.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/report")
    public ReportDto getSensorReportByName(@RequestParam(name = "sensor_name") String name) {
        try {
            return reportService.getSensorReportByName(name);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Report For Sensor With Name: " + name + " Not Found!");
        }
    }

    //Get Sensor Report By Year
    @GetMapping("/report/{year}")
    public ReportDto getSensorReportByYear(@PathVariable String year) {
        try {
            return reportService.getSensorReportByYear(year);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Report For Sensor In Year: " + year + " Not Found!");
        }
    }

    //Get Sensor Report By Year & Month
    @GetMapping("/report/{year_month}")
    public ReportDto getSensorReportByMonth(@PathVariable("year_month") String yearMonth) {
        try {
            return reportService.getSensorReportByMonth(yearMonth);
        }
        catch (Exception exception) {
            throw new SensorNotFoundException("Report For Sensor In Year/Month: " + yearMonth + " Not Found!");
        }
    }
}