package xjhxjhxjhxjh.com.github.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

   /**
    * 生成验证码
    * @author xjhxjhxjh
    *
    */
@Controller
public class ValidCodeController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @RequestMapping("validCode")
    public void getValidCode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 使用java图形界面技术绘制一张图片
        int charNum = 4;
        int width = 20 * 4;
        int height = 28;

        // 创建一张内存图片
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // 获得绘图对象
        Graphics graphics = bufferedImage.getGraphics();

        // 绘制背景颜色
        graphics.setColor(Color.yellow);
        graphics.fillRect(0, 0, width, height);

        // 绘制图片边框
        graphics.setColor(Color.GRAY);
        graphics.drawRect(0, 0, width - 1, height - 1);

        // 输出验证码内容
        graphics.setColor(Color.RED);
        graphics.setFont(new Font("宋体", Font.BOLD, 22));

        // 随机输出4个字符
        String s = "ABCDEFGHGKLMNPQRSTUVWXYZ23456789";
        Random random = new Random();

        // session中要用到
        StringBuilder sb = new StringBuilder();

        int x = 5;
        for (int i = 0; i < charNum; i++) {
            int index = random.nextInt(32);
            String content = String.valueOf(s.charAt(index));
            sb.append(content);
            graphics.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            graphics.drawString(content, x, 22);
            x += 20;
        }
        req.getSession().setAttribute("sessionValidCode", sb.toString());

        // 绘制干扰线
        graphics.setColor(Color.GRAY);
        for (int i = 0; i < 5; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            graphics.drawLine(x1, y1, x2, y2);
        }

        // 释放资源
        graphics.dispose();

        // 图片输出 ImageIO
        ImageIO.write(bufferedImage, "jpg", resp.getOutputStream());
    }
}