package com.app.userservice.resource.vendor;

import com.app.userservice.service.sensor.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendor/sensor")
public class VendorController {

    @Autowired
    private SensorService sensorService;

    @GetMapping("/all/{vendorId}")
    public ResponseEntity<?> getAllVendorSensors(@RequestParam(value = "vendorId", required = true, defaultValue = "0") String vendorId) {
        return ResponseEntity.ok(sensorService.getAllSensorsByVendorId(vendorId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSensorInfo(@RequestParam(value = "id", required = true, defaultValue = "0") String id) {
        return ResponseEntity.ok(sensorService.getSensorInfoById(id));
    }
}
