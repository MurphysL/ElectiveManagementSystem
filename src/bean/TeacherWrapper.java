package bean;

import java.util.List;

/**
 * Created by lenovo on 2017/6/1.
 */
public class TeacherWrapper {
    private List<Teacher> list;
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<Teacher> getList() {
        return list;
    }

    public void setList(List<Teacher> list) {
        this.list = list;
    }
}
