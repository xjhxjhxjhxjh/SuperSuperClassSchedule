package xjhxjhxjhxjh.com.github.pojo;

public class Message {
    private Integer sId;
    private Integer tId;
    private Integer cId;
    private Integer gScore;
    private String sName;
    private String tName;
    private String cName;
    private String cPlace;
    
    public Integer getsId() {
        return sId;
    }
    public void setsId(Integer sId) {
        this.sId = sId;
    }
    public Integer gettId() {
        return tId;
    }
    public void settId(Integer tId) {
        this.tId = tId;
    }
    public Integer getcId() {
        return cId;
    }
    public void setcId(Integer cId) {
        this.cId = cId;
    }
    public Integer getgScore() {
        return gScore;
    }
    public void setgScore(Integer gScore) {
        this.gScore = gScore;
    }
    public String getsName() {
        return sName;
    }
    public void setsName(String sName) {
        this.sName = sName;
    }
    public String gettName() {
        return tName;
    }
    public void settName(String tName) {
        this.tName = tName;
    }
    public String getcName() {
        return cName;
    }
    public void setcName(String cName) {
        this.cName = cName;
    }
    public String getcPlace() {
        return cPlace;
    }
    public void setcPlace(String cPlace) {
        this.cPlace = cPlace;
    }
    
    @Override
    public String toString() {
        return "Message [sId=" + sId + ", tId=" + tId + ", cId=" + cId + ", gScore=" + gScore + ", sName=" + sName
                + ", tName=" + tName + ", cName=" + cName + ", cPlace=" + cPlace + "]";
    }
  
}
