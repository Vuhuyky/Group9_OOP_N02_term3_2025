package com.example.dormmanagement.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Đối tượng Dorm (tòa ký túc xá).
 */
@Entity
@Table(name = "dorms")
public class Dorm extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "dorm_name", nullable = false, length = 100)
    private String dormName;     // Tên tòa ký túc xá (ví dụ: "KTX A")

    @Column(name = "address", length = 255)
    private String address;      // Địa chỉ tòa nhà

    @Column(name = "total_floors")
    private int totalFloors;     // Số tầng

    @Column(name = "manager_name", length = 100)
    private String managerName;  // Tên người quản lý

    public Dorm() {
        super();
    }

    public Dorm(String id, String dormName, String address, int totalFloors, String managerName) {
        super();
        this.id = id;  // Gán id thủ công
        this.dormName = dormName;
        this.address = address;
        this.totalFloors = totalFloors;
        this.managerName = managerName;
    }

    // Getters & Setters

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getDormName() {
        return dormName;
    }

    public void setDormName(String dormName) {
        this.dormName = dormName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTotalFloors() {
        return totalFloors;
    }

    public void setTotalFloors(int totalFloors) {
        this.totalFloors = totalFloors;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
}
