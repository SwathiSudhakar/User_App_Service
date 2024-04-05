package com.app.userservice.service.vendor;

import com.app.userservice.entity.vendor.VendorData;
import com.app.userservice.exception.InvalidDataException;
import com.app.userservice.exception.NoRecordFoundException;
import com.app.userservice.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.List;


@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    public VendorData addNewVendor(VendorData vendorData) {
        return vendorRepository.save(vendorData);
    }

    public List<VendorData> fetchAll() {
        // TODO Auto-generated method stub
        return vendorRepository.findAll();
    }

    public VendorData updateVendor(VendorData vendorData) {
        if (vendorData.getVendorId() == 0) {
            throw new InvalidDataException("vendorId is empty or not valid");
        } else {
            VendorData existingVendorData = this.getVendorById(vendorData.getVendorId());
            if (ObjectUtils.isEmpty(existingVendorData)) {
                throw new NoRecordFoundException("No record found with vendorId : " + vendorData.getVendorId());
            }

            if (!ObjectUtils.isEmpty(vendorData.getName())){
                vendorData.setName(existingVendorData.getName());
            }

            //TODO Do validation for other fields as well
            //email
            //

            return vendorRepository.save(vendorData);
        }
    }

    public Object deleteVendorById(final Long id) {
        if (id == 0) {
            throw new InvalidDataException("vendorId is empty or not valid");
        }
        VendorData existingVendorData = this.getVendorById(id);
        if (ObjectUtils.isEmpty(existingVendorData)) {
            throw new NoRecordFoundException("No record found with vendorId : " + id);
        } else {
            vendorRepository.deleteById(id);
            return new HashMap<>().put("isRemoved", Boolean.TRUE);
        }
    }

    public VendorData getVendorById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
}
