package bean.course;

import bean.course.Course;

import java.util.List;

/**
 * 课程包装类
 */
public class Courses {

    /**
     * 总课程数
     */
    private int num;
    private List<Course> courses;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

}
