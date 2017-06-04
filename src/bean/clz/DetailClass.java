package bean.clz;


public class DetailClass {
    private int clzno;
    private long start;
    private String address;
    private int cno;
    private String cname;
    private int credit;
    private int duration;
    private int tno;
    private String tname;
    private String sex;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "DetailClass{" +
                "clzno=" + clzno +
                ", start=" + start +
                ", address=" + address +
                ", cno=" + cno +
                ", cname='" + cname + '\'' +
                ", credit=" + credit +
                ", duration=" + duration +
                ", tno=" + tno +
                ", tname='" + tname + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
