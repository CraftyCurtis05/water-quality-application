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

    public SensorDto getSensorByName(String sensorName) {
        return  SensorMapper.toDTO(sensorRepository.findSensorByName(sensorName));
    }

    public SensorDto getSensorById(Long sensorId) {
        //return sensorDtoList.stream().filter( e -> e.getId() == id).findFirst().get();
        return SensorMapper.toDTO(sensorRepository.findById(sensorId).get());
    }

    public List<SensorDto> getListSensorData() {
        //return sensorRepository.findAll().stream().map(SensorMapper::toDTO).collect(Collectors.toList());

        List<Sensor> sensorList = sensorRepository.findAll();
        List<SensorDto> list = new ArrayList<>();

        for (Sensor sensor : sensorList) {
            SensorDto dto = SensorMapper.toDTO(sensor);
            list.add(dto);
        }
        return list;
    }

    public List<SensorDto> getListSensorDataByStatus(boolean status) {
        return sensorDtoList.stream().filter(e -> e.isActive() == status).toList();
    }

    public List<SensorDto> add(SensorDto sensorDto) {
          sensorDtoList.add(sensorDto);
          return sensorDtoList;

        sensorRepository.saveAndFlush(SensorMapper.toEntity(sensorDto));
        return getListSensorData();
    }

    public List<SensorDto> update(SensorDto sensorDtoUpdate) {
        Sensor sensor = SensorMapper.toEntity(sensorDtoUpdate);

        sensorRepository.saveAndFlush(sensor);
        return getListSensorData();
    }

    public List<SensorDto> delete(String name) {

        SensorDto sensorDto = getSensorByName(name);

        //delete existing item in the list
        sensorDtoList.remove(sensorDtoList.indexOf(sensorDto));
        //update

        return sensorDtoList;
    }

    public List<SensorDto> patch(String sensorName, String description) {

        SensorDto sensorDto = getSensorByName(sensorName);

        //delete existing item in the list
        sensorDtoList.remove(sensorDtoList.indexOf(sensorDto));

        //update
        sensorDto.setSensorDescription(description);

        //insert
        sensorDtoList.add(sensorDto);

        return sensorDtoList;
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