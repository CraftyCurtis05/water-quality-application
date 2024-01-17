package com.waterquality.waterqualitymanagementrest.repository;

import com.waterquality.waterqualitymanagementrest.entity.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorDataRepository extends JpaRepository<SensorData, Long> {

}