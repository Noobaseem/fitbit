package com.udaan.interview.fitbit.service.activity;

import com.udaan.interview.fitbit.service.metrics.HeartMetric;
import com.udaan.interview.fitbit.service.metrics.SleepMetric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FitnessActivity {

    @Autowired
    private HeartMetric heartMetric;
    @Autowired
    private SleepMetric sleepMetric;

    Double computeActivityScore(Long userId, Long start, Long end) {
        //Compute Aggregates
        return (heartMetric.computeAvg(userId, start,end) + sleepMetric.computeAvg(userId, start, end)) / 2;
    }
}
