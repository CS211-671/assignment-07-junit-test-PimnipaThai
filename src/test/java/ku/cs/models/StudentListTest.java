package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    private StudentList studentList;

    @BeforeEach
    void setUp() {
        studentList = new StudentList();
    }

    @Test
    void testAddNewStudentWithoutScore() {
        studentList.addNewStudent("6610450001", "Tim Berners-Lee");
        assertEquals(1, studentList.getStudents().size());
        assertNotNull(studentList.findStudentById("6610450001"));
        assertEquals("Tim Berners-Lee", studentList.findStudentById("6610450001").getName());
    }

    @Test
    void testAddNewStudentWithScore() {
        studentList.addNewStudent("6610450002", "Barbara Liskov", 42.7);
        assertEquals(1, studentList.getStudents().size());
        Student student = studentList.findStudentById("6610450002");
        assertNotNull(student);
        assertEquals("Barbara Liskov", student.getName());
        assertEquals(42.7, student.getScore(), 0.01);
    }

    @Test
    void testAddDuplicateStudent() {
        studentList.addNewStudent("6610450003", "Alan Turing");
        studentList.addNewStudent("6610450003", "Alan Turing");
        assertEquals(1, studentList.getStudents().size());
    }

    @Test
    void testGiveScoreToExistingStudent() {
        studentList.addNewStudent("6410450004", "John McCarthy");
        studentList.giveScoreToId("6410450004", 43.8);
        assertEquals(43.8, studentList.findStudentById("6410450004").getScore(), 0.01);
    }

    @Test
    void testViewGradeOfId() {
        studentList.addNewStudent("6410450005", "Alan Kay", 46.0);
        assertEquals("F", studentList.viewGradeOfId("6410450005"));
    }

    @Test
    void testFindStudentById_NotFound() {
        assertNull(studentList.findStudentById("999"));
    }
}