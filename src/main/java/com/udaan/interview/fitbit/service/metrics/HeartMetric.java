package com.udaan.interview.fitbit.service.metrics;

import com.udaan.interview.fitbit.repository.HeartMetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class HeartMetric implements MetricService {

    @Autowired
    private HeartMetricRepository heartMetricRepository;

    @Override
    public void recordAndStore(Long userId, Long deviceId, Double value) {
        heartMetricRepository.recordAndSet(userId, deviceId, value);
    }

    @Override
    public Double computeMax(Long userId, long start, long end) {
        List<Double> rangeList = heartMetricRepository.getRange(userId, start, end);
        Collections.sort(rangeList);
        return rangeList.get(rangeList.size()-1);
    }

    @Override
    public Double computeMin(Long userId, long start, long end) {
        List<Double> rangeList = heartMetricRepository.getRange(userId, start, end);
        Collections.sort(rangeList);
        return rangeList.get(0);
    }

    @Override
    public Double computeAvg(Long userId, long start, long end) {
        List<Double> rangeList = heartMetricRepository.getRange(userId, start, end);
        Double sum = 0.00;
        for (Double value: rangeList) {
            sum += value;
        }
        return sum / rangeList.size();
    }
}
