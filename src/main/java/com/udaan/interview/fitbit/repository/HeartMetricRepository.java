package com.udaan.interview.fitbit.repository;

import com.udaan.interview.fitbit.model.Pair;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class HeartMetricRepository {

    Map<Long, Map<Long, List<Pair>>> heartMetrics;

    public void recordAndSet(Long userId, Long deviceId, Double value) {
        Pair data = new Pair(System.currentTimeMillis(), value);
        heartMetrics.get(userId).get(deviceId).add(data);
    }

    public List<Double> getRange(Long userId, long start, long end) {
        List<Double> rangeList = new ArrayList<>();
        Map<Long, List<Pair>> metricsPerDevice = heartMetrics.get(userId);
        for(Long deviceId: metricsPerDevice.keySet()) {
            List<Pair> deviceMetric = metricsPerDevice.get(deviceId);
            for (Pair data: deviceMetric) {
                if (data.getTime() >= start && data.getTime() <= end) {
                    rangeList.add(data.getValue());
                }
            }
        }
        return rangeList;
    }
}
