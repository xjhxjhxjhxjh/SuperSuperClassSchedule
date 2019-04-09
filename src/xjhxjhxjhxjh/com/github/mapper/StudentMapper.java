package xjhxjhxjhxjh.com.github.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import xjhxjhxjhxjh.com.github.pojo.Apply;
import xjhxjhxjhxjh.com.github.pojo.Course;
import xjhxjhxjhxjh.com.github.pojo.Student;
import xjhxjhxjhxjh.com.github.pojo.Teacher;

public interface StudentMapper {
    /**
     * 查询学生 
     * @param student
     * @return
     */
    @Select("select * from Student where sPassword = #{sPassword} and sName = #{sName}")
    Student selStudentByNameAndPwd(Student student);
    
    /**
     * 查询课程信息
     * @param student
     * @return
     */
    Student selCourseMessage(Integer sId);
    
    /**
     * 查询所有课程
     * @return
     */
    @Select("select * from Course")
    List<Course> selAllCourse(); 
    
    /**
     * 根据课程号查询相应的老师
     * @param cId
     * @return
     */
    @Select("select * from Teacher where tid in (select gtid from Grade where gcid = #{cId})")
    List<Teacher> selTeacherBycId(Integer cId);
    
    /**
     * 添加申请课程
     * @param apply
     */
    @Insert("insert into Apply values (default,#{aTId},#{aSId},#{aCId})")
    int insApply(Apply apply);
}
