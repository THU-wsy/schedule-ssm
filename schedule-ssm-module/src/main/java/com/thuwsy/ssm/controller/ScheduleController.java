package com.thuwsy.ssm.controller;

import com.thuwsy.ssm.pojo.Schedule;
import com.thuwsy.ssm.service.ScheduleService;
import com.thuwsy.ssm.utils.PageBean;
import com.thuwsy.ssm.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: ScheduleController
 * Package: com.thuwsy.ssm.controller
 * Description:
 *
 * @Author THU_wsy
 * @Create 2023/9/15 16:25
 * @Version 1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/{pageSize}/{currentPage}")
    public R showList(@PathVariable("pageSize") Integer pageSize, @PathVariable("currentPage") Integer currentPage) {
        PageBean<Schedule> pageBean = scheduleService.findByPage(pageSize, currentPage);
        return R.ok(pageBean);
    }

    @PostMapping
    public R saveSchedule(@RequestBody Schedule schedule) {
        scheduleService.saveSchedule(schedule);
        return R.ok(null);
    }

    @DeleteMapping("/{id}")
    public R removeSchedule(@PathVariable("id") Integer id) {
        scheduleService.removeSchedule(id);
        return R.ok(null);
    }

    @PutMapping
    public R changeSchedule(@RequestBody Schedule schedule) {
        scheduleService.updateSchedule(schedule);
        return R.ok(null);
    }
}
