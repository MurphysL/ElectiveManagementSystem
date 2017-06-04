package bean.course;

/**
 * 科目
 */
public class Course {
    private int Cno;
    private String name;
    private int credit;
    private int duration; // 持续周数

    public int getCno() {
        return Cno;
    }

    public void setCno(int cno) {
        Cno = cno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Course{" +
                "Cno=" + Cno +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                ", duration=" + duration +
                '}';
    }
}
