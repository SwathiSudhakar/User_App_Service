package com.app.userservice.repository;

import com.app.userservice.entity.sensor.SensorInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<SensorInfo, Long> {
    List<SensorInfo> findByVendorId(Long vendorId);
}
