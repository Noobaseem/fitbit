package com.udaan.interview.fitbit.service.user;

import com.udaan.interview.fitbit.exceptions.DeviceNotFoundException;
import com.udaan.interview.fitbit.exceptions.UserNotFoundException;
import com.udaan.interview.fitbit.repository.UserRepository;
import com.udaan.interview.fitbit.service.device.DeviceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DeviceService  deviceService;

    /**
     *
     * @param userId
     */
    public void addNewUser(Long userId) {
        try {
            this.userRepository.addNewUser(userId);
        } catch (Exception e) {
            log.error("User Registration Failed");
        }
    }

    /**
     *
     * @param userId
     * @return
     */
    public boolean isRegisteredUser(Long userId) {
        return this.userRepository.isRegisteredUser(userId);
    }

    /**
     *
     * @param userId
     * @param deviceId
     * @throws DeviceNotFoundException
     */
    public void addDeviceToUser(Long userId, Long deviceId) throws DeviceNotFoundException {
        if (!this.deviceService.isDeviceAvailable(deviceId)) {
            throw new DeviceNotFoundException("No device found: 404");
        }
        if (!this.isRegisteredUser(userId)) {
            throw new UserNotFoundException("No user found: 404");
        }
        this.userRepository.addUserDevice(userId, deviceId);
    }

    void transferOwnership(Long deviceId, Long prevOwnerId, Long newOwnerId){
        //Validations

    }

}
