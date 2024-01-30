package com.waterqualityconsumer.waterqualitymanagementrestclient.api;

import com.waterqualityconsumer.waterqualitymanagementrestclient.dto.SensorDataDto;
import com.waterqualityconsumer.waterqualitymanagementrestclient.dto.SensorDto;
import com.waterqualityconsumer.waterqualitymanagementrestclient.service.SensorClient;
import com.waterqualityconsumer.waterqualitymanagementrestclient.service.SensorDataClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestRestClientController {

    private final SensorClient sensorClient;

    private final SensorDataClient sensorDataClient;

    //Get Sensor By Id
    @GetMapping("/sensorId")
    public SensorDto getSensorByIdTest() {
        return sensorClient.getSensorById(1l);
    }

    //Get Sensor By Name
    @GetMapping("/sensorName")
    public SensorDto getSensorByNameTest() {
        return sensorClient.getSensorByName("SNS-3");
    }

    //Get All Sensors
    @GetMapping("/sensor/all")
    public List<SensorDto> getListOfAllSensorsTest() {
        return sensorClient.getListOfAllSensors();
    }

    //Get Sensors By Status
    @GetMapping("/sensor/list")
    public List<SensorDto> getAllSensorsByStatusTrueTest() {
        return sensorClient.getAllSensorsByStatus(true);
    }

    //Add(Post) New Sensor
    //TODO: FIGURE OUT WHY SENSOR DTO CAN NOT BE ENTERED AS A PARAMETER!
//    @GetMapping("/sensor/add")
//    public List<SensorDto> addSensorTest() {
//        return sensorClient.addSensor(5, 'SNS-5', true, 'Pennsylvania Sensor');
//    }

    //Update(Put) Sensor
    //TODO: FIGURE OUT WHY SENSOR DTO CAN NOT BE ENTERED AS A PARAMETER!
//    @GetMapping("/sensor/update")
//    public List<SensorDto> updateSensorTest() {
//        return sensorClient.updateSensor(1, 'SNS-1', false, 'Ohio Sensor');
//    }

    //Delete Sensor By Name
    @GetMapping("/sensor/delete")
    public void deleteSensorTest() {
        sensorClient.deleteSensor("SNS-5");
    }


    //Get Sensor Data By Id
    @GetMapping("/sensordata/sensorId")
    public List<SensorDataDto> getSensorDataByIdTest() {
        return sensorDataClient.getSensorDataById(1l);
    }

    //Get Sensor Data By Name
    @GetMapping("/sensordata/sensorName")
    public

    //Get Sensor Data List By Year & Month

    //Get Sensor Data List By Year

    //Save(Post) Sensor Data

    //Update(Put) Sensor Data

    //Delete Sensor Data By Sensor ID



    //Get Sensor Data Report By Name

    //Get Sensor Data Report By Year & Month

    //Get Sensor Data Report By Year

}


//    @GetMapping("/multiple")
//    public List<SensorDto> clientTest_two() {
//
//        //  return sensorClient.save();
//
//        //  return sensorClient.update();
//
//        return sensorClient.delete("SNS-5");
//    }