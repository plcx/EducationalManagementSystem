package com.shhy.dao;

import com.shhy.domain.Course;

import java.util.List;

public interface CourseMapper {
    Integer insert(Course course);//插入一条新的记录 insert into user (username,password) values (xxx,xxx)
    Integer delete(Integer cid);//删除一条记录  delete from user where id=xxx;
    Integer update(Course course);//更新一条记录  update user set username=xxxx,password=xxxxx,id=xxxx where id=xxx

    static List<Course> findAll() {
        return null;
    }

    Course findOne(Integer id);//查找一条记录,   select * from user where id=xxx
//    Student findOneByUser(Student user);//根据user对象的多个属性匹配,此例中用于登录检查
//    Student findOneByUsername(String username);//根据用户名返回用户信息,用于检测用户是否存在
}
