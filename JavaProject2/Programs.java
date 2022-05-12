package Univercity;

import java.util.ArrayList;
import java.util.List;

public class Programs {
    private String name;
    private ProgramType programType;
    private List<Courses> courses;

    public Programs(String name) {
        this.name = name;
        this.programType = ProgramType.MAJOR;
        courses = new ArrayList<>();
    }

    public Programs(String name, ProgramType programType) {
        this.name = name;
        this.programType = programType;
        courses = new ArrayList<>();
    }

    public Programs(String name, ProgramType programType, List<Courses> courses) {
        this.name = name;
        this.programType = programType;
        this.courses = courses;
    }

    public void addCourse(Courses course) {
        if (!this.courses.contains(course)) {
            this.courses.add(course);
        }
    }

    public void printCourse() {
        System.out.println("Program: " + this.name);
        for (Courses course : this.courses) {
            System.out.println(course);
        }
    }

    public String getName() {
        return name;
    }

    public ProgramType getProgramType() {
        return programType;
    }

    public List<Courses> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Programs{" +
                "name='" + name + '\'' +
                ", programType=" + programType +
                '}';
    }
}
