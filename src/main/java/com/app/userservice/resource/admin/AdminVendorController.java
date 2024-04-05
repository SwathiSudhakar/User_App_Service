package com.app.userservice.resource.admin;

import com.app.userservice.entity.vendor.VendorData;
import com.app.userservice.service.vendor.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/vendor")
public class AdminVendorController {

    @Autowired
    private VendorService vendorService;

    @PostMapping("/add")
    public ResponseEntity<?> addVendor(@RequestBody @NonNull VendorData vendorData) {
        return ResponseEntity.ok(vendorService.addNewVendor(vendorData));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateVendor(@RequestBody @NonNull VendorData vendorData) {
        return ResponseEntity.ok(vendorService.updateVendor(vendorData));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVendor(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(vendorService.deleteVendorById(id));
    }
}
