package com.shhy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shhy.dao.CourseMapper;
import com.shhy.domain.Course;
import com.shhy.service.CourseService;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    //@Qualifier(value = "userMapper")
    @Autowired
    private  CourseMapper courseMapper;

    @Override
    public Integer insert(Course course) {
        return null;
    }

    @Override
    public Integer delete(Integer cid) {
        return null;
    }

    @Override
    public Integer update(Course course) {
        return null;
    }

    @Override
    public List<Course> findAll() {
        return CourseMapper.findAll();
    }

    @Override
    public Course findOne(Integer cid) {
        return null;
    }


/*
    @Override
    public User findOneByUser(User user) {
        return userMapper.findOneByUser(user);
    }

 */
}
