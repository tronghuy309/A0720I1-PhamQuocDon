package exercises.optional_demerging;

import java.awt.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class DemergingQueue {
    public static void main(String[] args) {
        LinkedList <Student> studentList = new LinkedList<>();
        Queue<Student> newStudentList = new LinkedList<>();
        Student student1 = new Student("Nam", "male" , "01/01/1991");
        Student student2 = new Student("Dat", "male" , "01/05/1992");
        Student student3 = new Student("Huong", "female" , "03/09/2003");
        Student student4 = new Student("Ngoc", "female" , "04/05/2004");
        Student student5 = new Student("Hung", "male" , "02/04/2005");
        Student student6 = new Student("Ha", "female" , "04/03/2006");
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        studentList.add(student6);
        Queue<Student> tempList = new LinkedList<>();
        while (!studentList.isEmpty()){
            Student student = studentList.remove();
            if (student.getGender().equals("female")){
                newStudentList.add(student);
            } else {
                tempList.add(student);
            }
        }
        while (!tempList.isEmpty()){
            newStudentList.add(tempList.remove());
        }

        while (!newStudentList.isEmpty()){
            System.out.println(newStudentList.remove().toString());
        }
    }
}
