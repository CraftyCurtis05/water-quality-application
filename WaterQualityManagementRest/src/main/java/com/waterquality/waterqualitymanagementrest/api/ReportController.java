package com.waterquality.waterqualitymanagementrest.api;

import com.waterquality.waterqualitymanagementrest.dto.ReportDto;
import com.waterquality.waterqualitymanagementrest.exception.SensorDataNotFoundException;
import com.waterquality.waterqualitymanagementrest.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    //Get Sensor Data Report By Name
    @GetMapping("report")
    @PreAuthorize("hasRole('ADMIN')")
    public ReportDto getSensorReportBySensorName(@RequestParam(name = "sensorName") String sensorName) {
        try {
            return reportService.getSensorReportBySensorName(sensorName);
        }
        catch (Exception exception) {
            throw new SensorDataNotFoundException("Sensor Data For Sensor Name : " + sensorName + " Not Found!");
        }
    }

    //Get Sensor Data Report By Year & Month
    @GetMapping("report/{sensorId}/{year}/{month}")
    @PreAuthorize("hasRole('ADMIN')")
    public ReportDto getSensorReportByYearAndMonth(@PathVariable Long sensorId, @PathVariable String year, @PathVariable String month) {
        try {
            return reportService.getSensorReportByYearAndMonth(sensorId, year, month);
        }
        catch (Exception exception) {
            throw new SensorDataNotFoundException("Sensor Data For Sensor ID : " + sensorId + " In Year/Month : " + year + "/" + month + " Not Found!");
        }
    }

    //Get Sensor Data Report By Year
    @GetMapping("report/{sensorId}/{year}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<ReportDto> getSensorReportByYear(@PathVariable Long sensorId, @PathVariable String year) {
        try {
            return reportService.getSensorReportByYear(sensorId, year);
        }
        catch (Exception exception) {
            throw new SensorDataNotFoundException("Sensor Data For Sensor ID : " + sensorId + " In Year : " + year + " Not Found!");
        }
    }
}