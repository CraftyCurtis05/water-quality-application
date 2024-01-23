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
    public SensorDataDto getSensorDataById(Long sensorId) {

        SensorData sensorData = sensorDataRepository.findById(sensorId).get();
        return SensorDataMapper.toDTO(sensorData);
    }

    //Get Sensor Data By Name
    public List<SensorDataDto> getSensorDataByName(String sensorName) {

        Sensor sensor = sensorRepository.findSensorBySensorName(sensorName);
        List<SensorData> sensorData = sensorDataRepository.findSensorDataBySensor(sensor);
        return  sensorData.stream().map(SensorDataMapper::toDTO).collect(Collectors.toList());
    }

    //Get Sensor Data List By Year & Month
    public List<SensorDataDto> getBySensorAndYearAndMonth(Long sensorId, String year, String month) {

        Sensor sensor = sensorRepository.findById(sensorId).get();
        List<SensorData> sensorData = sensorDataRepository.findBySensorAndYearAndMonth(sensor,year,month);
        return  sensorData.stream().map(SensorDataMapper::toDTO).collect(Collectors.toList());
    }

    //Get Sensor Data By Year
    public List<SensorDataDto> getSensorDataByYear(Long sensorId, String year) {

        Sensor sensor = sensorRepository.findById(sensorId).get();
        List<SensorData> sensorData = sensorDataRepository.findBySensorAndYear(sensor,year);
        return  sensorData.stream().map(SensorDataMapper::toDTO).collect(Collectors.toList());
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


//    private final RestClient restClient;
//
//    //Get Sensor Data By Id
//    public SensorDataDto getSensorDataById(Long id) {
//        return restClient.get()
//                .uri("/api/sensordata/{id}", id)
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .body(SensorDataDto.class);
//    }
//
//    //Get Sensor Data By Name
//    public SensorDataDto getSensorDataByName(String name) {
//        return restClient.get()
//                .uri("/api/sensordata?sensor_name={name}", name)
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .body(SensorDataDto.class);
//    }
//
//    //Get Sensors By Year
//    public SensorDataDto getSensorDataByYear(String year) {
//        return restClient.get()
//                .uri("/api/sensordata?year={year}", year)
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .body(SensorDataDto.class);
//    }
//
//    //Get Sensors By Year & Month
//    public SensorDataDto getSensorDataByMonth(String yearMonth) {
//        return restClient.get()
//                .uri("/api/sensordata?year_month={year_month}", yearMonth)
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .body(SensorDataDto.class);
//    }
//
//    //Save(Post) Sensor Data
//    public List<SensorDataDto> saveSensorData(SensorDataDto sensorDataDto) {
//        //SensorDataDto sensorDataDto = new SensorDataDto(5,"SNS-5", "iron","2015", "february", .06);
//
//        return restClient.post()
//                .uri("/api/sensordata")
//                .body(sensorDataDto)
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .body(List.class);
//    }
//
//    //Update(Put) Sensor Data
//    public List<SensorDataDto> updateSensorData(SensorDataDto sensorDataDto) {
//        //SensorDataDto sensorDataDto = new SensorDataDto(5,"SNS-5", "iron","2019", "march", .06);
//
//        return restClient.put()
//                .uri("/api/sensordata")
//                .body(sensorDataDto)
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .body(List.class);
//    }
//
//    //Delete Sensor Data By Name
//    public List<SensorDataDto> deleteSensorData(String name) {
//
//        return restClient.delete()
//                .uri("api/sensordata/{sensor_name}",name)
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .body(List.class);
//    }