package com.udaan.interview.fitbit.service.dashboard;

import com.udaan.interview.fitbit.model.DailyAggregates;
import com.udaan.interview.fitbit.model.DashboardResponse;
import com.udaan.interview.fitbit.model.HeartResponse;
import com.udaan.interview.fitbit.model.WeeklyAggregates;
import com.udaan.interview.fitbit.service.metrics.HeartMetric;
import com.udaan.interview.fitbit.service.metrics.MetricService;
import com.udaan.interview.fitbit.service.metrics.WeightMetric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class DashboardService {

    @Autowired
    private HeartMetric heartMetric;

    @Autowired
    private WeightMetric  weightMetric;

    private WeeklyAggregates getWeeklyAggregates(Long userId) {
        Long start = LocalDate.now().minusDays(7).atStartOfDay(ZoneId.of("Asia/Kolkata")).toInstant().toEpochMilli();
        Long end = LocalDate.now().atStartOfDay(ZoneId.of("Asia/Kolkata")).toInstant().toEpochMilli();
        Double heartMax = heartMetric.computeMax(userId, start, end);
        Double heartMin = heartMetric.computeMin(userId, start, end);
        Double heartAvg = heartMetric.computeAvg(userId, start, end);
        HeartResponse response =  new HeartResponse(heartMax, heartMin, heartAvg);
        return new WeeklyAggregates().builder().heartResponse(response).build();
    }

    private DailyAggregates getDailyAggregates(Long userId) {
        Long start = LocalDate.now().atStartOfDay(ZoneId.of("Asia/Kolkata")).toInstant().toEpochMilli();
        Long end = LocalDate.now().plusDays(1).atStartOfDay(ZoneId.of("Asia/Kolkata")).toInstant().toEpochMilli();
        Double heartMax = heartMetric.computeMax(userId, start, end);
        Double heartMin = heartMetric.computeMin(userId, start, end);
        Double heartAvg = heartMetric.computeAvg(userId, start, end);
        HeartResponse response =  new HeartResponse(heartMax, heartMin, heartAvg);
        return new DailyAggregates().builder().heartResponse(response).build();
    }

    public DashboardResponse getDashboard(Long userId) {
        return new DashboardResponse()
                .builder()
                .dailyAggregates(getDailyAggregates(userId))
                .weeklyAggregates(getWeeklyAggregates(userId)).build();
    }
}
