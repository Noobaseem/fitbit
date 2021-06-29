package com.udaan.interview.fitbit.repository;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserRepository {
    private Set<Long> userIds;
    private Map<Long, Set<Long>> userToDevice;

    public void addNewUser(Long userId) {
        this.userIds.add(userId);
    }

    public boolean isRegisteredUser(Long userId) {
        return this.userIds.contains(userId);
    }

    public void addUserDevice(Long userId, Long deviceId) {
        if (userToDevice.containsKey(userId)) {
            this.userToDevice.get(userId).add(deviceId);
        } else {
            Set<Long> deviceList = new HashSet<>();
            deviceList.add(deviceId);
            this.userToDevice.put(userId, deviceList);
        }
    }
}
