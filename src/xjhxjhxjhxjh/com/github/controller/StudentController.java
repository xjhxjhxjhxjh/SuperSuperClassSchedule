package xjhxjhxjhxjh.com.github.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xjhxjhxjhxjh.com.github.pojo.Apply;
import xjhxjhxjhxjh.com.github.pojo.Course;
import xjhxjhxjhxjh.com.github.pojo.Message;
import xjhxjhxjhxjh.com.github.pojo.Student;
import xjhxjhxjhxjh.com.github.pojo.Teacher;
import xjhxjhxjhxjh.com.github.service.StudentService;
import xjhxjhxjhxjh.com.github.utils.JudgeValiCodeUtils;
/**
 * 学生模块控制器
 * @author xjhxjhxjh
 *
 */
@Controller
public class StudentController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Resource
    private StudentService studentServiceImpl;
    
    /**
     * 学生登录
     * @param req
     * @param student
     * @return
     */
    @RequestMapping("studentLogin")
    public String login(HttpServletRequest req, Student student) {
        // 使用JudgeValiCodeUtils判断验证码
        String judge = JudgeValiCodeUtils.judge(req);

        // 如果验证码正确
        if ("right".equals(judge)) {
            // 校验用户名和密码
            Student login = studentServiceImpl.login(student);
            if (login == null) {
                req.setAttribute("msg", "请输入正确的用户名和密码");
                return "loginError";
            } else {
                student = studentServiceImpl.getMessage(login.getsId());
                req.getSession().setAttribute("student", login);
                return "redirect:/getMessage";
            }
        } else {
            // 如果不正确跳转到相应页面
            return judge;
        }
    }
    /**
     * 查询学生的课程及其相关信息
     * @param req
     * @return
     */
    @RequestMapping("getMessage")
    public String findMessage(HttpServletRequest req) {
        // 获取session里的学生信息
        Student student = (Student)req.getSession().getAttribute("student");
        // 调用查询方法
        student = studentServiceImpl.getMessage(student.getsId());
        req.setAttribute("student", student);
        req.getSession().setAttribute("student",student);
        return "studentHomePage";
    }
    /**
     * 查询所有课程
     * @param req
     * @return
     */
    @RequestMapping("findAllCourse")
    public String findAllCourse(HttpServletRequest req) {
        List<Course> allCourse = studentServiceImpl.findAllCourse();
        req.setAttribute("list", allCourse);
        return "studentAllCourse";
    }
    
    /**
     * 判断申请的课程是否已选
     * @param req
     * @param cId
     * @return
     */
    @ResponseBody
    @RequestMapping("addCourse")
    public List<Teacher> addCourse(HttpServletRequest req, int cId) {
        // 获得学生信息
        Student student = (Student)req.getSession().getAttribute("student");
        // 获得想要申请的课程编号
        List<Message> list = student.getsList();
        // 判断是否已经选过
        for (Message message : list) {
            if (message.getcId() == cId) {
                return null;
            }
        }
        req.getSession().setAttribute("cId", cId);
        // 返回教该课程的老师信息
        return studentServiceImpl.findTeacherBycId(cId);
    }
    
    /**
     * 申请课程
     * @param req
     */
    @ResponseBody
    @RequestMapping("applyCourse")
    public void applyCourse(HttpServletRequest req, int tId) {
       // 获取学生，课程和老师的id
       Integer cId = (Integer)req.getSession().getAttribute("cId");
       Student student = (Student)req.getSession().getAttribute("student");
       Integer sId = student.getsId();
       // 封装数据
       Apply apply = new Apply();
       apply.setaCId(cId);
       apply.setaSId(sId);
       apply.setaTId(tId);
       // 调用申请方法
       studentServiceImpl.insApply(apply);
    }
    
}
