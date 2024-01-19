package com.waterquality.waterqualitymanagementrest.repository;

import com.waterquality.waterqualitymanagementrest.entity.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParameterRepository extends JpaRepository<Parameter, Long> {

    Parameter findParameterByParameterId(Long parameterId);

    Parameter findParameterByParameterName(String parameterName);

    Parameter findParameterByParameterNameContaining(String parameterName);

    Parameter findParameterByParameterNameIsEmpty();
}
