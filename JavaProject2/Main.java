package Univercity;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Courses course1 = new Courses("First",8,CourseType.REQUIRED);
        Courses course2 = new Courses("Second",3,CourseType.ELECTIVE);
        Courses course3 = new Courses("Third",3,CourseType.ELECTIVE);
        Courses course4 = new Courses("Fourth",8,CourseType.REQUIRED);
        List<Courses> coursesList = new ArrayList<>();
        coursesList.add(course1);
        coursesList.add(course2);
        coursesList.add(course3);
        coursesList.add(course4);

        Programs program1 = new Programs("Informatics");
        Programs program2 = new Programs("Music", ProgramType.MAJOR, coursesList);

        program1.addCourse(course1);
        program1.addCourse(course2);
        program1.addCourse(course3);

        program1.printCourse();
        program2.printCourse();

    }
}
