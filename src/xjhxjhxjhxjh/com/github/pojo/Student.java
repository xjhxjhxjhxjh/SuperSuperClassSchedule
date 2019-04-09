package xjhxjhxjhxjh.com.github.pojo;

import java.util.List;

/**
 * 学生表
 * @author xjhxjhxjh
 *
 */
public class Student {
    private Integer sId;
    private String sName;
    private String sPassword;
    private List<Message> sList;
    
    public Integer getsId() {
        return sId;
    }
    public void setsId(Integer sId) {
        this.sId = sId;
    }
    public String getsName() {
        return sName;
    }
    public void setsName(String sName) {
        this.sName = sName;
    }
    public String getsPassword() {
        return sPassword;
    }
    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }
    public List<Message> getsList() {
        return sList;
    }
    public void setsList(List<Message> sList) {
        this.sList = sList;
    }
    @Override
    public String toString() {
        return "Student [sId=" + sId + ", sName=" + sName + ", sPassword=" + sPassword + ", sList=" + sList + "]";
    }   
    
}
