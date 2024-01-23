package com.waterquality.waterqualitymanagementrest.repository;

import com.waterquality.waterqualitymanagementrest.entity.Sensor;
import com.waterquality.waterqualitymanagementrest.entity.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorDataRepository extends JpaRepository<SensorData, Long> {

    //top to bottom : controller -> service -> repository
    //bottom to top : repository -> service -> controller
    //top to bottom : service : dto -> entity
    //bottom to top : service : entity -> dto
    //@Modifying //SAVE AND FLUSH
    //@Query //(JPQL SELECT STRING)//JPQL CONVERTED INTO POSTGRESQL QUERY
    List<SensorData> findSensorDataBySensor(Sensor sensor);

    List<SensorData> findBySensorAndYearAndMonth(Sensor sensor, String year,String month);

    List<SensorData> findBySensorAndYear(Sensor sensor, String year);


}