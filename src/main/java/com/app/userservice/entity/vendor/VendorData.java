package com.app.userservice.entity.vendor;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_vendor")
public class VendorData {

    @Id
    @Column(name = "vendor_id")
    @SequenceGenerator(
            name = "vender_sequence",
            sequenceName = "vendor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendor_sequence")
    private long vendorId;

    @Column(name = "sensor_id", unique = true, nullable = false)
    //TODO : name should be changed to email_id or something not sensor_id
    private String emailId;

    @Column(name = "name", nullable = false)
    private String name;

    
    
  
    
	public VendorData() {
		super();
	}

	public VendorData(long vendorId, String emailId, String name) {
		super();
		this.vendorId = vendorId;
		this.emailId = emailId;
		this.name = name;
	}

	public long getVendorId() {
		return vendorId;
	}

	public void setVendorId(long vendorId) {
		this.vendorId = vendorId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	

	
}
