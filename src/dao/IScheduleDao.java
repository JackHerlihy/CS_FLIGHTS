package dao;

import model.Schedule;

import java.util.List;

public interface IScheduleDao {
    List<Schedule> getFlightSchedule(Schedule flight);
}
