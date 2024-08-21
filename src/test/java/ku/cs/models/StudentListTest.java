package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
        @Test
        @DisplayName("ทดสอบหารายชื่อนักเรียน")
        public void testStudentListAddStudent() {
            // TODO: add 3 users to UserList
            StudentList studentList = new StudentList();
            Student student = new Student(6610450001, 'Tim Berners-Lee' );
            StudentList.addNewStudent(student);

            assertEquals(6610450001,student.getfindStudentById());

            // TODO: find one of them


            // TODO: assert that UserList found User
            // String expected = "<one of username>"
            // String actual = user.getUsername();
            // assertEquals(expected, actual);
        }
}