package com.app.userservice.repository;

import com.app.userservice.entity.vendor.VendorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends JpaRepository<VendorData, Long> {

}
