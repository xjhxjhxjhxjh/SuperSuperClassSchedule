package xjhxjhxjhxjh.com.github.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xjhxjhxjhxjh.com.github.mapper.StudentMapper;
import xjhxjhxjhxjh.com.github.pojo.Apply;
import xjhxjhxjhxjh.com.github.pojo.Course;
import xjhxjhxjhxjh.com.github.pojo.Student;
import xjhxjhxjhxjh.com.github.pojo.Teacher;
import xjhxjhxjhxjh.com.github.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService{
    @Resource
    private StudentMapper studentMapper;
    
    /**
     * 学生登录
     */
    @Override
    public Student login(Student student) {
        return studentMapper.selStudentByNameAndPwd(student);
        
    }
    /**
     * 获得学生的课程信息
     */
    @Override
    public Student getMessage(Integer sId) {
        return studentMapper.selCourseMessage(sId);
    }
    
    /**
     * 获得所有课程
     */
    @Override
    public List<Course> findAllCourse() {
        return studentMapper.selAllCourse();
    }
    
    /**
     * 根据课程号查询相应的老师
     */
    @Override
    public List<Teacher> findTeacherBycId(Integer cId) {
        return studentMapper.selTeacherBycId(cId);
    }
    
    /**
     * 添加申请课程
     */
    @Override
    public void insApply(Apply apply) {
        studentMapper.insApply(apply);
    }

}
