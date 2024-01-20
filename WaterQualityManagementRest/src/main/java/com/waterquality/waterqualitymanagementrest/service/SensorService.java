package com.waterquality.waterqualitymanagementrest.service;

import com.waterquality.waterqualitymanagementrest.dto.SensorDto;
import com.waterquality.waterqualitymanagementrest.entity.Parameter;
import com.waterquality.waterqualitymanagementrest.entity.Sensor;
import com.waterquality.waterqualitymanagementrest.entity.SensorData;
import com.waterquality.waterqualitymanagementrest.mapper.SensorDataMapper;
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

//    //Update(Patch) Sensor Name & Description
//    public List<SensorDto> patchSensor(String sensorName, String description) {
//
//        Sensor sensor = sensorRepository.findSensorBySensorName(sensorName);
//
//        //Delete Existing Item In The List
//        sensorDtoList.remove(sensorDtoList.indexOf(sensorDto));

//        //Update
//        sensorDto.setSensorDescription(description);
    
//        //Insert
//        sensorDtoList.add(sensorDto);
//        return getListOfAllSensors();
//    }

    //Delete Sensor By Name
    public void deleteSensor(String sensorName) {

        sensorRepository.deleteSensorBySensorName(sensorName);
    }
}


//private final RestClient restClient;
//
//    //Get Sensor By Id
//    public SensorDto getSensorById(Long id) {
//        return restClient.get()
//                .uri("/api/sensor/{id}",id)
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .body(SensorDto.class);
//    }
//
//    //Get Sensor By Name
//    public SensorDto getSensorByName(String name) {
//        return restClient.get()
//                .uri("/api/sensor?sensor_name={name}",name)
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .body(SensorDto.class);
//    }
//
//    //Get All Sensors
//    public List<SensorDto> getAllSensors() {
//        return restClient.get()
//                .uri("/api/sensor/all")
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .body(List.class);
//    }
//
//    //Get Sensors By Status
//    public List<SensorDto> getSensorsByStatus(boolean isActive) {
//        return restClient.get()
//                .uri("/api/sensor/list")
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .body(List.class);
//    }
//
//    //Save(Post) New Sensor
//    public List<SensorDto> saveSensor(SensorDto sensorDto) {
//        //SensorDto sensorDto = new SensorDto(5,"SNS-5",false,"Atlanta");
//
//        return restClient.post()
//                .uri("/api/sensor")
//                .body(sensorDto)
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .body(List.class);
//    }
//
//    //Update(Put) Sensor
//    public List<SensorDto> updateSensor(SensorDto sensorDto) {
//        //SensorDto sensorDto = new SensorDto(5,"SNS-5",true,"Atlanta");
//
//        return restClient.put()
//                .uri("/api/sensor")
//                .body(sensorDto)
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .body(List.class);
//    }
//
//    //Update(Patch) Sensor
//    public List<SensorDto> patchSensor(String name, String description) {
//        SensorDto sensorDto = new SensorDto(5,"SNS-5",false,"Atlanta");
//
//        return restClient.patch()
//                .uri("/api/sensor")
//                .body(sensorDto)
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .body(List.class);
//    }
//
//    //Delete Sensor By Name
//    public List<SensorDto> deleteSensor(String name) {
//
//        return restClient.delete()
//                .uri("api/sensor/{sensor_name}",name)
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .body(List.class);
//    }