package bean.clz;

/**
 * 课程详细信息
 */
public class DetailClass {
    private int Cno;
    private String Cname;
    private int Ccredit;
    private int Tno;
    private String Tname;
    private String Tsex;
    private String Address;
    private Long Time;

    public int getCno() {
        return Cno;
    }

    public void setCno(int cno) {
        Cno = cno;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public int getCcredit() {
        return Ccredit;
    }

    public void setCcredit(int ccredit) {
        Ccredit = ccredit;
    }

    public int getTno() {
        return Tno;
    }

    public void setTno(int tno) {
        Tno = tno;
    }

    public String getTname() {
        return Tname;
    }

    public void setTname(String tname) {
        Tname = tname;
    }

    public String getTsex() {
        return Tsex;
    }

    public void setTsex(String tsex) {
        Tsex = tsex;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Long getTime() {
        return Time;
    }

    public void setTime(Long time) {
        Time = time;
    }

    @Override
    public String toString() {
        return "DetailClass{" +
                "Cno=" + Cno +
                ", Cname='" + Cname + '\'' +
                ", Ccredit=" + Ccredit +
                ", Tno=" + Tno +
                ", Tname='" + Tname + '\'' +
                ", Tsex='" + Tsex + '\'' +
                ", Address='" + Address + '\'' +
                ", Time=" + Time +
                '}';
    }
}
