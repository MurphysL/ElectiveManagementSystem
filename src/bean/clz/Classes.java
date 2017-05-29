package bean.clz;

import bean.clz.Class;

import java.util.List;

/**
 * 课程包装类
 */
public class Classes {
    /**
     * 总课数
     */
    private int num;
    private List<Class> list;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<Class> getList() {
        return list;
    }

    public void setList(List<Class> list) {
        this.list = list;
    }
}
