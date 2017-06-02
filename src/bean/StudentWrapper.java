package bean;

import java.util.List;

/**
 * 学生包装类
 */
public class StudentWrapper {
    private List<Student> list;

    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }
}
