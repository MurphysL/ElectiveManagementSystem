package bean.sc;


public class SC {
    private int clzno;
    private int sno;
    private int Grade;

    public int getClzno() {
        return clzno;
    }

    public void setClzno(int clzno) {
        this.clzno = clzno;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int grade) {
        Grade = grade;
    }

    @Override
    public String toString() {
        return "SC{" +
                "clzno=" + clzno +
                ", sno=" + sno +
                ", Grade=" + Grade +
                '}';
    }
}
