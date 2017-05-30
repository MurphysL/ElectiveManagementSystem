package bean;

/**
 * 详细Sc类
 */
public class DetailSc {
    private int Cno;
    private int Tno;
    private Long Time;
    private int Sno;
    private String Sname;
    private String Ssex;
    private String Sdept;
    private String avatar;
    private int Grade;

    public int getCno() {
        return Cno;
    }

    public void setCno(int cno) {
        Cno = cno;
    }

    public int getTno() {
        return Tno;
    }

    public void setTno(int tno) {
        Tno = tno;
    }

    public Long getTime() {
        return Time;
    }

    public void setTime(Long time) {
        Time = time;
    }

    public int getSno() {
        return Sno;
    }

    public void setSno(int sno) {
        Sno = sno;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSsex() {
        return Ssex;
    }

    public void setSsex(String ssex) {
        Ssex = ssex;
    }

    public String getSdept() {
        return Sdept;
    }

    public void setSdept(String sdept) {
        Sdept = sdept;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int grade) {
        Grade = grade;
    }

    @Override
    public String toString() {
        return "DetailSc{" +
                "Cno=" + Cno +
                ", Tno=" + Tno +
                ", Time=" + Time +
                ", Sno=" + Sno +
                ", Sname='" + Sname + '\'' +
                ", Ssex='" + Ssex + '\'' +
                ", Sdept='" + Sdept + '\'' +
                ", avatar='" + avatar + '\'' +
                ", Grade=" + Grade +
                '}';
    }
}
