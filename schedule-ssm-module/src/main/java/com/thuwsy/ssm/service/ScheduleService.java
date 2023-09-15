package com.thuwsy.ssm.service;


import com.thuwsy.ssm.pojo.Schedule;
import com.thuwsy.ssm.utils.PageBean;

import java.util.List;

/**
 * ClassName: ScheduleService
 * Package: com.thuwsy.ssm.service
 * Description:
 *
 * @Author THU_wsy
 * @Create 2023/9/15 16:15
 * @Version 1.0
 */

public interface ScheduleService {
    PageBean<Schedule> findByPage(int pageSize, int currentPage);
    void saveSchedule(Schedule schedule);
    void removeSchedule(Integer id);
    void updateSchedule(Schedule schedule);
}
