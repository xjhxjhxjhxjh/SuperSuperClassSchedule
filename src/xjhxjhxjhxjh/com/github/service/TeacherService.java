package xjhxjhxjhxjh.com.github.service;

import java.util.List;

import xjhxjhxjhxjh.com.github.pojo.Message;
import xjhxjhxjhxjh.com.github.pojo.Teacher;

public interface TeacherService {
    /**
     * 老师登录
     * @param teacher
     * @return
     */
    Teacher login(Teacher teacher);
    
    /**
     * 获得老师的课程信息
     * @param tId
     * @return
     */
    Teacher getClassMessage(Integer tId);
    
    /**
     * 获得老师某个课程的学生信息
     * @param Tid
     * @param Cid
     * @return
     */
    List<Message> getStudentMessage(Integer Tid, Integer Cid);
    
    /**
     * 编辑学生成绩
     * @param gSId
     * @param gCId
     * @param gScore
     * @return
     */
    int updGrade(Integer gSId, Integer gCId, Integer gScore);
    
    /**
     * 查询学生成绩
     * @param gSId
     * @param gCId
     * @return
     */
    String selGrade(Integer gSId, Integer gCId);
    
    /**
     * 获取申请选课的学生名单
     * @param tId
     * @return
     */
    List<Message> getApplyList(Integer tId);
    
    /***
     * 删除学生的请求
     * @param sId
     * @param cId
     * @param tId
     * @return
     */
    int delApply(Integer sId, Integer cId, Integer tId);
    
    /**
     * 增加学生的课程
     * @param sId
     * @param cId
     * @param tId
     * @return
     */
    int insCourse(Integer sId, Integer cId, Integer tId);
}
