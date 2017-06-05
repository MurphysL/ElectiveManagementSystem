package bean.sc;

/**
 * 详细Sc类
 */
public class DetailSC {
    private int clzno;
    private long start;
    private String address;
    private int cno;
    private String cname;
    private int credit;
    private int duration;
    private int tno;
    private String tname;
    private String tsex;
    private int sno;
    private String sname;
    private String ssex;
    private String dept;
    private String avatar;
    private int grade;

    public int getClzno() {
        return clzno;
    }

    public void setClzno(int clzno) {
        this.clzno = clzno;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getTno() {
        return tno;
    }

    public void setTno(int tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "DetailSC{" +
                "clzno=" + clzno +
                ", start=" + start +
                ", address='" + address + '\'' +
                ", cno=" + cno +
                ", cname='" + cname + '\'' +
                ", credit=" + credit +
                ", duration=" + duration +
                ", tno=" + tno +
                ", tname=" + tname +
                ", tsex=" + tsex +
                ", sno=" + sno +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", dept='" + dept + '\'' +
                ", avatar='" + avatar + '\'' +
                ", grade=" + grade +
                '}';
    }
}
