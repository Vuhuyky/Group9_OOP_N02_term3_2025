package com.group9oop.dormitorymanagement.model;

import java.time.LocalDate;

public class ServiceUsage {
    private Room room;
    private int electricityUsage; // số kw điện
    private int waterUsage;       // số m3 nước
    private LocalDate usageDate;

    public ServiceUsage(Room room, int electricityUsage, int waterUsage, LocalDate usageDate) {
        this.room = room;
        this.electricityUsage = electricityUsage;
        this.waterUsage = waterUsage;
        this.usageDate = usageDate;
    }

    public Room getRoom() {
        return room;
    }

    public int getElectricityUsage() {
        return electricityUsage;
    }

    public int getWaterUsage() {
        return waterUsage;
    }

    public LocalDate getUsageDate() {
        return usageDate;
    }
}
