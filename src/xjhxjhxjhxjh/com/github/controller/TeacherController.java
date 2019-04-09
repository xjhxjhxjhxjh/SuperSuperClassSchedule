package xjhxjhxjhxjh.com.github.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xjhxjhxjhxjh.com.github.pojo.Message;
import xjhxjhxjhxjh.com.github.pojo.Teacher;
import xjhxjhxjhxjh.com.github.service.TeacherService;
import xjhxjhxjhxjh.com.github.utils.JudgeValiCodeUtils;
/**
 * 老师模块控制器
 * @author xjhxjhxjh
 *
 */
@Controller
public class TeacherController extends HttpServlet{
    private static final long serialVersionUID = 1L;
    @Resource
    private TeacherService teacherServiceImpl;
    
    /**
     * 老师登录
     * @param req
     * @param teacher
     * @return
     */
    @RequestMapping("teacherLogin")
    public String login(HttpServletRequest req, Teacher teacher) {
        // 使用JudgeValiCodeUtils判断验证码
        String judge = JudgeValiCodeUtils.judge(req);

        // 如果验证码正确
        if ("right".equals(judge)) {
            // 校验用户名和密码
            Teacher login = teacherServiceImpl.login(teacher);
            if (login == null) {
                req.setAttribute("msg", "请输入正确的用户名和密码");
                return "loginError";
            } else {
                req.getSession().setAttribute("teacher", login);
                return "redirect:/findClassMessage";
            }
        } else {
            // 如果不正确跳转到相应页面
            return judge;
        }
    }
    
    /**
     * 查询课程信息
     * @param req
     * @return
     */
    @RequestMapping("findClassMessage")
    public String findClassMessage(HttpServletRequest req) {
        // 获取session里的老师信息
        Teacher teacher = (Teacher)req.getSession().getAttribute("teacher");
        // 调用查询方法
        teacher = teacherServiceImpl.getClassMessage(teacher.gettId());
        req.setAttribute("teacher", teacher);
        req.getSession().setAttribute("teacher",teacher);
        return "teacherHomePage";
    }
    
    /**
     * 查询学生信息
     * @param req
     * @param cId
     * @param tId
     * @return
     */
    @RequestMapping("findStudentMessage")
    public String findStudentMessage(HttpServletRequest req, Integer cId, Integer tId) {
        // 调用查询方法
        List<Message> studentMessage = teacherServiceImpl.getStudentMessage(tId, cId);
        // 返回参数
        req.setAttribute("teacher",(Teacher)req.getSession().getAttribute("teacher"));
        req.setAttribute("list", studentMessage);
        return "teacherStudent";
    }
    
    /**
     * 编辑成绩
     * @param gSId
     * @param gCId
     * @param gScore
     * @return
     */
    @ResponseBody
    @RequestMapping("editGrade")
    public int editGrade(Integer gSId, Integer gCId, Integer gScore) {
        return teacherServiceImpl.updGrade(gSId, gCId, gScore);
    }
    
    /**
     * 查询成绩
     * @param gSId
     * @param gCId
     * @return
     */
    @ResponseBody
    @RequestMapping(value="findGrade",produces="text/html;charset=UTF-8")
    public String findGrade(Integer gSId, Integer gCId) {
        // 获得成绩
        String grade = teacherServiceImpl.selGrade(gSId, gCId);
        return grade;
    }
    
    /**
     * 获取申请选课的学生名单
     * @param req
     * @param tId
     * @return
     */
    @RequestMapping("getApplyList")
    public String getApplyList(HttpServletRequest req, Integer tId) {
        // 调用查询方法
        List<Message> list = teacherServiceImpl.getApplyList(tId);
        // 返回参数
        req.setAttribute("list", list);
        return "applyList";
    }
    
    /**
     * 删除学生的请求
     * @param sId
     * @param cId
     * @param tId
     * @return
     */
    @ResponseBody
    @RequestMapping("delApply")
    public String delApply(Integer sId, Integer cId, Integer tId) {
        teacherServiceImpl.delApply(sId, cId, tId);
        return "";
    }
    
    /**
     * 增加学生课程
     * @param sId
     * @param cId
     * @param tId
     * @return
     */
    @ResponseBody
    @RequestMapping("insCourse")
    public String insCourse(Integer sId, Integer cId, Integer tId) {
        // 删除学生的请求
        teacherServiceImpl.delApply(sId, cId, tId);
        // 添加课程
        teacherServiceImpl.insCourse(sId, cId, tId);
        return "";
    }
    
}
