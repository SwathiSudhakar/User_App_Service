package com.app.userservice.service.sensor;

import com.app.userservice.entity.sensor.SensorInfo;
import com.app.userservice.exception.InvalidDataException;
import com.app.userservice.exception.NoRecordFoundException;
import com.app.userservice.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    public SensorInfo getSensorInfoById(String incomingId) {
        try {
            if (incomingId.equals("0")) {
                throw new InvalidDataException();
            }
            final Long id = Long.parseLong(incomingId);
            Optional<SensorInfo> sensorInfoOptional = sensorRepository.findById(id);
            if (sensorInfoOptional.isPresent()) {
                return sensorInfoOptional.get();
            } else {
                throw new NoRecordFoundException();
            }
        } catch (NumberFormatException e) {
            throw new InvalidDataException("Invalid id provided.");
        } catch (NoRecordFoundException e) {
            throw new NoRecordFoundException("No record found with the provided id.");
        }
    }

    public List<SensorInfo> getAllSensorsByVendorId(String vendorIdIncoming) {
        try {
            if (vendorIdIncoming.equals("0")) {
                throw new InvalidDataException();
            }
            final Long vendorId = Long.parseLong(vendorIdIncoming);
            return sensorRepository.findByVendorId(vendorId);
        } catch (NumberFormatException e) {
            throw new InvalidDataException("Invalid vendorId provided.");
        }
    }
}
