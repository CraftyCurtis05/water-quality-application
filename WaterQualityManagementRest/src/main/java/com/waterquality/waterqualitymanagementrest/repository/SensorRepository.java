package com.waterquality.waterqualitymanagementrest.repository;

import com.waterquality.waterqualitymanagementrest.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {

    Sensor findSensorBySensorName(String sensorName);

    void deleteSensorBySensorName(String sensorName);

//    Sensor findSensorByDescription(String description);
//
//    List<Sensor> findSensorsByNameStartingWithAndDescriptionIsNotNull(String name);
//
//    List<Sensor> findSensorByActive(boolean status);
//
//    Sensor findSensorByNameAndActive(String name, boolean status);
//
//    Sensor findSensorByNameEquals(String name);
//
//    List<Sensor> findSensorByNameIsNot(String name);
//
//    List<Sensor> findSensorsByDescriptionIsNull();
//
//    List<Sensor> findSensorsByDescriptionIsNotNull();
//
//    List<Sensor> findSensorsByActiveIsTrue();
//
//    List<Sensor> findSensorsByActiveIsFalse();
//
//    List<Sensor> findSensorsByNameStartingWith(String name);
//
//    List<Sensor> findSensorsByNameEndingWith(String name);
//
//    List<Sensor> findSensorsByNameContainingOrderByName(String name);
//
//    List<Sensor> findSensorsByNameContainingOrderByNameAsc(String name);
//
//    List<Sensor> findSensorsByNameContainingOrderByNameDesc(String name);
}