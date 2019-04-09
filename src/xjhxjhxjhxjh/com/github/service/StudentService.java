package xjhxjhxjhxjh.com.github.service;

import java.util.List;

import xjhxjhxjhxjh.com.github.pojo.Apply;
import xjhxjhxjhxjh.com.github.pojo.Course;
import xjhxjhxjhxjh.com.github.pojo.Student;
import xjhxjhxjhxjh.com.github.pojo.Teacher;

public interface StudentService {
    /**
     * 学生登录
     * @param student
     * @return
     */
    Student login(Student student);
    
    /**
     * 获得学生的课程信息
     * @return
     */
    Student getMessage(Integer sId);
    
    /**
     * 查询所有课程
     * @return
     */
    List<Course> findAllCourse();
    
    /**
     * 根据课程号查询相应的老师
     * @param cId
     * @return
     */
    List<Teacher> findTeacherBycId(Integer cId);
    
    /**
     * 添加申请课程
     * @param apply
     */
    void insApply(Apply apply);
}
