package com.udaan.interview.fitbit.service.device;

import com.udaan.interview.fitbit.exceptions.DeviceRegistrationFailedException;
import com.udaan.interview.fitbit.repository.DeviceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    void registerNewDevice(Long deviceId) throws DeviceRegistrationFailedException {
        try {
            this.deviceRepository.addNewDevice(deviceId);
        }  catch (Exception e) {
            log.error("Registration Failed", e);
            throw new DeviceRegistrationFailedException("Device Registration Failed");
        }
    }

    public boolean isDeviceAvailable(Long devideId) {
        return this.deviceRepository.isValidDevice(devideId);
    }
}
