package xjhxjhxjhxjh.com.github.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xjhxjhxjhxjh.com.github.mapper.TeacherMapper;
import xjhxjhxjhxjh.com.github.pojo.Message;
import xjhxjhxjhxjh.com.github.pojo.Teacher;
import xjhxjhxjhxjh.com.github.service.TeacherService;;
@Service
public class TeacherServiceImpl implements TeacherService{
    @Resource
    private TeacherMapper teacherMapper;
    
    /**
     * 老师登录
     */
    @Override
    public Teacher login(Teacher teacher) {
        return teacherMapper.selTeacherByTNameAndPwd(teacher);
    }
    
    /**
     * 获得老师的课程信息
     */
    @Override
    public Teacher getClassMessage(Integer tId) {
        return teacherMapper.selCourseMessage(tId);
    }
    
    /**
     * 获得老师某个课程的学生信息
     */
    @Override
    public List<Message> getStudentMessage(Integer tId, Integer cId) {
        return teacherMapper.selStudentBytIdAndcId(tId, cId);
    }
    
    /**
     * 编辑学生成绩
     */
    @Override
    public int updGrade(Integer gSId, Integer gCId, Integer gScore) {
        return teacherMapper.updGrade(gSId, gCId, gScore);
    }
    
    /**
     * 查询学生成绩
     */
    @Override
    public String selGrade(Integer gSId, Integer gCId) {
        // 获得学生成绩
        int grade = teacherMapper.selGrade(gSId, gCId);
        String str = null;
        // 判断返回成绩类型
        if (grade == -4) {
            str = "缓考";
        } else if (grade == -3) {
            str = "考试作弊";
        } else if (grade == -2) {
            str = "暂无考试成绩";
        } else if (grade == -1) {
            str = "缺考";
        } else {
            str = grade + "";
        }
        return str;
   }
    
    /**
     * 获取申请选课的学生名单
     */
    @Override
    public List<Message> getApplyList(Integer tId) {
        return teacherMapper.selApplyList(tId);
    }
    
    /**
     * 删除学生的请求
     */
    @Override
    public int delApply(Integer sId, Integer cId, Integer tId) {
        return teacherMapper.delApply(sId, cId, tId);
    }
    
    /**
     * 增加学生的课程
     */
    @Override
    public int insCourse(Integer sId, Integer cId, Integer tId) {
        return teacherMapper.insGrade(sId, cId, tId);
    }
}
