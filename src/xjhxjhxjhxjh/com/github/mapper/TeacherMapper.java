package xjhxjhxjhxjh.com.github.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import xjhxjhxjhxjh.com.github.pojo.Message;
import xjhxjhxjhxjh.com.github.pojo.Teacher;

public interface TeacherMapper {
    /**
     * 查询老师
     * @param teacher
     * @return
     */
    @Select("select * from Teacher where tName = #{tName} and Tpassword = #{tPassword}")
    Teacher selTeacherByTNameAndPwd(Teacher teacher);
    
    /**
     * 查询老师的教学信息
     * @param tId
     * @return
     */
    Teacher selCourseMessage(Integer tId);
    
    /**
     * 查询指定老师和课程的学生信息
     * @param tId
     * @param cId
     * @return
     */
    List<Message> selStudentBytIdAndcId(Integer tId, Integer cId);
    
    /**
     * 编辑学生成绩
     * @param gSId
     * @param gCId
     * @param gScore
     * @return
     */
    @Update("update Grade set gScore = #{2} where gSId = #{0} and gCId = #{1}")
    int updGrade(Integer gSId, Integer gCId, Integer gScore);
    
    /**
     * 查询成绩
     * @param gSId
     * @param gCId
     * @return
     */
    @Select("select gScore from Grade where gSId = #{0} and gCId = #{1}")
    int selGrade(Integer gSId, Integer gCId);
    
    /**
     * 获取申请选课的学生名单
     * @param tId
     * @return
     */
    List<Message> selApplyList(Integer tId);
    
    /**
     * 删除学生的请求
     * @param sId
     * @param cId
     * @param tId
     * @return
     */
    @Delete("delete from Apply where aSId = #{0} and aCId = #{1} and aTId = #{2}")
    int delApply(Integer sId, Integer cId, Integer tId);
    
    /**
     * 增加学生的课程
     * @param sId
     * @param cId
     * @param tId
     * @return
     */
    @Insert("insert into Grade values (default, #{2}, #{1}, #{0}, default)")
    int insGrade(Integer sId, Integer cId, Integer tId);
}
