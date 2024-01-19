package com.waterquality.waterqualitymanagementrest.repository;

import com.waterquality.waterqualitymanagementrest.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {

    Sensor findSensorBySensorName(String sensorName);

    void deleteSensorBySensorName(String sensorName);

    Sensor findSensorBySensorNameEquals(String name);

    List<Sensor> findSensorBySensorNameIsNot(String name);

    List<Sensor> findSensorsBySensorNameStartingWith(String name);

    List<Sensor> findSensorsBySensorNameEndingWith(String name);

    List<Sensor> findSensorsBySensorNameContainingOrderBySensorName(String name);

    List<Sensor> findSensorsBySensorNameContainingOrderBySensorNameDesc(String name);

    List<Sensor> findSensorsBySensorNameStartingWithAndSensorDescriptionIsNotNull(String name);

    Sensor findSensorBySensorDescription(String description);

    List<Sensor> findSensorsBySensorDescriptionIsNull();

    List<Sensor> findSensorsBySensorDescriptionIsNotNull();

    Sensor findSensorBySensorNameAndActive(String name, boolean status);

    List<Sensor> findSensorByActive(boolean status);

    List<Sensor> findSensorsByActiveIsTrue();

    List<Sensor> findSensorsByActiveIsFalse();
}