package com.udaan.interview.fitbit.service.metrics;

public class SleepMetric implements MetricService{

    @Override
    public void recordAndStore(Long userId, Long deviceId, Double value) {

    }

    @Override
    public Double computeMax(Long userId, long start, long end) {
        return null;
    }

    @Override
    public Double computeMin(Long userId, long start, long end) {
        return null;
    }

    @Override
    public Double computeAvg(Long userId, long start, long end) {
        return null;
    }
}
