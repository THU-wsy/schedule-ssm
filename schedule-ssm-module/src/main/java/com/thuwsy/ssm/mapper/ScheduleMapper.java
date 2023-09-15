package com.thuwsy.ssm.mapper;

import com.thuwsy.ssm.pojo.Schedule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName: ScheduleMapper
 * Package: com.thuwsy.ssm.mapper
 * Description:
 *
 * @Author THU_wsy
 * @Create 2023/9/15 16:11
 * @Version 1.0
 */
public interface ScheduleMapper {
    List<Schedule> queryPage();
    void insert(Schedule schedule);
    void delete(@Param("id") Integer id);
    void update(Schedule schedule);
}
