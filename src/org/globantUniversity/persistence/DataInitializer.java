package org.globantUniversity.persistence;

import org.globantUniversity.data.Student;
import org.globantUniversity.data.PartTimeTeacher;
import org.globantUniversity.data.FullTimeTeacher;


public class DataInitializer {
    public static University loadUniversity() {
        University university = new University();
        return university;
    }

    private static void loadTeachersIntoUniversity(University university) {
        Teacher partTimeTeacher1 = new PartTimeTeacher("Juan", (byte) 15);
        Teacher partTimeTeacher2 = new PartTimeTeacher("Ximena", (byte) 20);
        Teacher fullTimeTeacher1 = new FullTimeTeacher("Felipe", (byte) 4);
        Teacher fullTimeTeacher2 = new FullTimeTeacher("Sofia", (byte) 10);
        university.addTeacher(partTimeTeacher1);
    }
}
