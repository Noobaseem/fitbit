package com.udaan.interview.fitbit.dto;

import com.udaan.interview.fitbit.enums.DeviceType;
import lombok.Data;

@Data
public class Device {
    private Long deviceId;
    private DeviceType deviceType;
}
