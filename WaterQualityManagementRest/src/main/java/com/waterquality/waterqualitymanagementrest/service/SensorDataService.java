package com.waterquality.waterqualitymanagementrest.service;

import com.waterquality.waterqualitymanagementrest.dto.SensorDataDto;
import com.waterquality.waterqualitymanagementrest.entity.Parameter;
import com.waterquality.waterqualitymanagementrest.entity.Sensor;
import com.waterquality.waterqualitymanagementrest.entity.SensorData;
import com.waterquality.waterqualitymanagementrest.mapper.SensorDataMapper;
import com.waterquality.waterqualitymanagementrest.repository.ParameterRepository;
import com.waterquality.waterqualitymanagementrest.repository.SensorDataRepository;
import com.waterquality.waterqualitymanagementrest.repository.SensorRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SensorDataService {

    private final SensorDataRepository sensorDataRepository;
    private final SensorRepository sensorRepository;
    private final ParameterRepository parameterRepository;

    //Get Sensor Data By Id
    public List<SensorDataDto> getSensorDataById(Long sensorId) {

        Sensor sensor = sensorRepository.findById(sensorId).get();
        List<SensorData> sensorData = sensorDataRepository.findSensorDataBySensor(sensor);
        return sensorData.stream().map(SensorDataMapper::toDTO).collect(Collectors.toList());
    }

    //Get Sensor Data By Name
    public List<SensorDataDto> getSensorDataByName(String sensorName) {

        Sensor sensor = sensorRepository.findSensorBySensorName(sensorName);
        List<SensorData> sensorData = sensorDataRepository.findSensorDataBySensor(sensor);
        return sensorData.stream().map(SensorDataMapper::toDTO).collect(Collectors.toList());
    }

    //Get Sensor Data List By Year & Month
    public List<SensorDataDto> getBySensorAndYearAndMonth(Long sensorId, String year, String month) {

        Sensor sensor = sensorRepository.findById(sensorId).get();
        List<SensorData> sensorData = sensorDataRepository.findBySensorAndYearAndMonth(sensor,year,month);
        return sensorData.stream().map(SensorDataMapper::toDTO).collect(Collectors.toList());
    }

    //Get Sensor Data By Year
    public List<SensorDataDto> getSensorDataByYear(Long sensorId, String year) {

        Sensor sensor = sensorRepository.findById(sensorId).get();
        List<SensorData> sensorData = sensorDataRepository.findBySensorAndYear(sensor,year);
        return sensorData.stream().map(SensorDataMapper::toDTO).collect(Collectors.toList());
    }

    //Save(Post) Sensor Data
    public SensorDataDto saveSensorData(SensorDataDto sensorDataDtoInput) {

        Parameter parameter = parameterRepository.findById(sensorDataDtoInput.getParameterId()).get();
        Sensor sensor = sensorRepository.findById(sensorDataDtoInput.getSensorId()).get();
        SensorData sensorData = SensorDataMapper.toEntity(sensorDataDtoInput,sensor,parameter);
        SensorData sensorDataOutput = sensorDataRepository.saveAndFlush(sensorData);
        return SensorDataMapper.toDTO(sensorDataOutput);
    }

    //Update(Put) Sensor Data
    public SensorDataDto updateSensorData(SensorDataDto sensorDataDtoInput) {

        SensorData sensorData = sensorDataRepository.findById(sensorDataDtoInput.getDataId()).get();
        sensorData.setParameterValue(sensorDataDtoInput.getParameterValue());
        SensorData sensorDataOutput = sensorDataRepository.saveAndFlush(sensorData);
        return SensorDataMapper.toDTO(sensorDataOutput);
    }

    //Delete Sensor Data By Sensor ID
    public void deleteSensorData(Long sensorId) {
        sensorDataRepository.deleteById(sensorId);
    }
}