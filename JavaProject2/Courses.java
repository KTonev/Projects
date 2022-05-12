package Univercity;

public class Courses {
    private long id;
    private String name;
    private int numberOfCredits;
    private CourseType courseType;
    private static long courseNumber;

    public Courses(String name, int numberOfCredits, CourseType courseType) {
        Courses.courseNumber++;
        this.id = courseNumber;
        this.name = name;
        this.numberOfCredits = numberOfCredits;
        this.courseType = courseType;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfCredits=" + numberOfCredits +
                ", courseType=" + courseType +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public CourseType getCourseType() {
        return courseType;
    }
}