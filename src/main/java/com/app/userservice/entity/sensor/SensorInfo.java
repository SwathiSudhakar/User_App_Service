package com.app.userservice.entity.sensor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tbl_sensor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SensorInfo {

    //TODO add required changes
    @Id
    private Long id;
    private Long vendorId;
    private String IpAddress;
    private Boolean isActive;
}
