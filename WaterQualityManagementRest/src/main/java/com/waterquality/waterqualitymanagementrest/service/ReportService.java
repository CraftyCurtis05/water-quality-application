package com.waterquality.waterqualitymanagementrest.service;

import com.waterquality.waterqualitymanagementrest.dto.ReportDto;
import com.waterquality.waterqualitymanagementrest.dto.SensorDataDto;
import com.waterquality.waterqualitymanagementrest.dto.SensorDto;
import com.waterquality.waterqualitymanagementrest.entity.Parameter;
import com.waterquality.waterqualitymanagementrest.repository.ParameterRepository;
import com.waterquality.waterqualitymanagementrest.util.ApplicationUtilities;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final SensorDataService sensorDataService;

    private final SensorService sensorService;

    private final ParameterRepository parameterRepository;

    //Get Sensor Data Report By Year
    public List<ReportDto> findSensorReportByYear(Long sensorId, String year) {
        List<SensorDataDto> sensorDataDtoList = sensorDataService.findSensorReportByYear(sensorId, year);
        List<ReportDto> reportDtoList = new ArrayList<>();

        //Get Distinct Year
        ReportDto reportDto = new ReportDto();
        SensorDto sensor = sensorService.getSensorById(sensorDataDtoList.get(0).getSensorId());
        reportDto.setSensorName(sensor.getSensorName());
        reportDto.setYear(year);

        boolean result = true;

        for (SensorDataDto sensorDto: sensorDataDtoList) {
            Parameter parameter = parameterRepository.findById(sensorDto.getParameterId()).get();

            if(!ApplicationUtilities.performEvaluation(parameter.getParameterName(),sensorDto.getParameterValue())) {
                result= false;
                System.out.println("Parameter : " + parameter.getParameterName() + " Does Not Meet Criteria!");
                break;
            }
        }
        reportDto.setResult(result ? "DRINKABLE": "NOT SAFE");
        return reportDtoList;
    }

    //Get Sensor Data Report By Year & Month
    public ReportDto findSensorReportByYearAndMonth(Long sensorId, String year, String month) {
        List<SensorDataDto> sensorDataDtoList = sensorDataService.findBySensorAndYearAndMonth(sensorId, year, month);

        ReportDto reportDto = new ReportDto();
        SensorDto sensor = sensorService.getSensorById(sensorDataDtoList.get(0).getSensorId());
        reportDto.setSensorName(sensor.getSensorName());
        reportDto.setYearMonth(year + "-" + month);

        boolean result = true;

        for (SensorDataDto sensorDto: sensorDataDtoList) {
            Parameter parameter = parameterRepository.findById(sensorDto.getParameterId()).get();
            if(!ApplicationUtilities.performEvaluation(parameter.getParameterName(),sensorDto.getParameterValue())) {
                result= false;
                System.out.println("Parameter : " + parameter.getParameterName() + " Does Not Meet Criteria!");
                break;
            }
        }
        reportDto.setResult(result ? "DRINKABLE": "NOT SAFE");
        return reportDto;
    }
}