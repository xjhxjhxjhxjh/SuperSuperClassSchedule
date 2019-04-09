package xjhxjhxjhxjh.com.github.utils;

import javax.servlet.http.HttpServletRequest;
/**
 * 判断验证码是否正确
 * @author xjhxjhxjh
 *
 */
public class JudgeValiCodeUtils {
    // 错误时跳转的页面
    public static final String WRONG = "loginError";
    // 正确时返回right
    public static final String RIGHT = "right";
    
    public static String judge(HttpServletRequest req) {
        // 获取前台录入的验证码
        String validCode = req.getParameter("validCode");
        // 从Session中获取验证码
        String sessionValiCode = (String)req.getSession().getAttribute("sessionValidCode");
        // 清空session保证点击登录的时候验证码是最新的
        req.getSession().removeAttribute("sessionValidCode");
        
        // 校验验证码
        if (validCode == null || validCode.trim().length() == 0) {
            // 把错误信息放入request域中
            req.setAttribute("msg", "请输入验证码");
            // 使用请求转发跳转到loginError.jsp
            return WRONG;
        } else if (!validCode.equalsIgnoreCase(sessionValiCode)){
            req.setAttribute("msg", "请输入正确的验证码");
            return WRONG;
        }
        return  RIGHT;
    }
}
