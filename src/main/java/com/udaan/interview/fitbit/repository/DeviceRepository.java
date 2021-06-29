package com.udaan.interview.fitbit.repository;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DeviceRepository {
    private Set<Long> deviceList;

    public void addNewDevice(Long deviceId) {
        this.deviceList.add(deviceId);
    }

    public boolean isValidDevice(Long devideId) {
        return this.deviceList.contains(devideId);
    }
}
