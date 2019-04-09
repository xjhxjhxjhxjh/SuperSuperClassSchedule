package xjhxjhxjhxjh.com.github.pojo;

import java.util.List;

/**
 * 老师表
 * @author xjhxjhxjh
 *
 */
public class Teacher {
    private Integer tId;
    private String tName;
    private String tPassword;
    private List<Message> tList;
    
    public Integer gettId() {
        return tId;
    }
    public void settId(Integer tId) {
        this.tId = tId;
    }
    public String gettName() {
        return tName;
    }
    public void settName(String tName) {
        this.tName = tName;
    }
    public String gettPassword() {
        return tPassword;
    }
    public void settPassword(String tPassword) {
        this.tPassword = tPassword;
    }
    public List<Message> gettList() {
        return tList;
    }
    public void settList(List<Message> tList) {
        this.tList = tList;
    }
    
}
