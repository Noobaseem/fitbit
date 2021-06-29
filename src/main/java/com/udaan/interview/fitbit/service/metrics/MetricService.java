package com.udaan.interview.fitbit.service.metrics;

public interface MetricService {
    void recordAndStore(final Long userId, final Long deviceId, final Double value);
    Double computeMax(Long userId, long start, long end);
    Double computeMin(Long userId, long start, long end);
    Double computeAvg(Long userId, long start, long end);
}
