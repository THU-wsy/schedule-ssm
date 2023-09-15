package com.thuwsy.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.thuwsy.ssm.mapper.ScheduleMapper;
import com.thuwsy.ssm.pojo.Schedule;
import com.thuwsy.ssm.service.ScheduleService;
import com.thuwsy.ssm.utils.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClassName: ScheduleServiceImpl
 * Package: com.thuwsy.ssm.service.impl
 * Description:
 *
 * @Author THU_wsy
 * @Create 2023/9/15 16:16
 * @Version 1.0
 */
@Slf4j
@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleMapper scheduleMapper;

    @Override
    public PageBean<Schedule> findByPage(int pageSize, int currentPage) {
        PageHelper.startPage(currentPage, pageSize);
        List<Schedule> schedules = scheduleMapper.queryPage();
        PageInfo<Schedule> pageInfo = new PageInfo<>(schedules);
        PageBean<Schedule> pageBean = new PageBean<>(pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal(), pageInfo.getList());
        log.info("分页查询结果:{}", pageBean);
        return pageBean;
    }

    @Override
    public void saveSchedule(Schedule schedule) {
        scheduleMapper.insert(schedule);
    }

    @Override
    public void removeSchedule(Integer id) {
        scheduleMapper.delete(id);
    }

    @Override
    public void updateSchedule(Schedule schedule) {
        scheduleMapper.update(schedule);
    }
}
