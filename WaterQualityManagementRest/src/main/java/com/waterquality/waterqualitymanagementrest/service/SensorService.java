package com.waterquality.waterqualitymanagementrest.service;

import com.waterquality.waterqualitymanagementrest.dto.SensorDto;
import com.waterquality.waterqualitymanagementrest.entity.Sensor;
import com.waterquality.waterqualitymanagementrest.mapper.SensorMapper;
import com.waterquality.waterqualitymanagementrest.repository.SensorRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorService {

    private final SensorRepository sensorRepository;

    //Get Sensor By Id
    public SensorDto getSensorById(Long sensorId) {
        return SensorMapper.toDTO(sensorRepository.findById(sensorId).get());
    }

    //Get Sensor By Name
    public SensorDto getSensorByName(String sensorName) {
        return SensorMapper.toDTO(sensorRepository.findSensorBySensorName(sensorName));
    }

    //Get All Sensors
    public List<SensorDto> getListOfAllSensors() {

        //return sensorRepository.getAll().stream().map(SensorMapper::toDTO).collect(Collectors.toList());
        List<Sensor> sensorList = sensorRepository.findAll();
        List<SensorDto> dtoList = new ArrayList<>();

        for (Sensor sensor : sensorList) {
            SensorDto dto = SensorMapper.toDTO(sensor);
            dtoList.add(dto);
        }
        return dtoList;
    }

    //Get Sensors By Status
    public List<SensorDto> getAllSensorsByStatus(boolean status) {

        //return sensorDtoList.stream().filter(e -> e.isActive() == status).toList();
        List<Sensor> sensorList = sensorRepository.findAll();
        List<SensorDto> dtoList = new ArrayList<>();

        for (Sensor sensor : sensorList) {
            if (sensor.isActive()) {
                SensorDto dto = SensorMapper.toDTO(sensor);
                dtoList.add(dto);
            }
        }
        return dtoList;
    }

    //Add(Post) New Sensor
    public List<SensorDto> addSensor(SensorDto sensorDto) {

        Sensor sensor = SensorMapper.toEntity(sensorDto);
        sensorRepository.saveAndFlush(sensor);
        return getListOfAllSensors();
    }

    //Update(Put) Sensor
    public List<SensorDto> updateSensor(SensorDto sensorDtoUpdate) {

        Sensor sensor = SensorMapper.toEntity(sensorDtoUpdate);
        sensorRepository.saveAndFlush(sensor);
        return getListOfAllSensors();
    }

    //Delete Sensor By Name
    public void deleteSensor(String sensorName) {

        sensorRepository.deleteSensorBySensorName(sensorName);
    }
}