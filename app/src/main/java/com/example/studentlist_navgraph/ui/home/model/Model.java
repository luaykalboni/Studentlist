package com.example.studentlist_navgraph.ui.home.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.LinkedList;
import java.util.List;

public class Model {
    public static final Model instance = new Model();

    private Model(){
        for(int i=0;i<5;i++){
            Student s = new Student("name",""+i,false);
            data.add(s);
        }
    }

    List<Student> data = new LinkedList<Student>();

    public List<Student> getAllStudents(){
        return data;
    }

    public void addStudent(Student student){
        data.add(student);
    }

    public void editStudent(Student student, int index) {
        data.set(index, student);
    }

    public Student getStudentById(String studentId) {
        for (Student s:data
             ) {
            if (s.getId().equals(studentId)){
                return s;
            }
        }
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void removeStudent(String id) {
        data.removeIf(s -> s.getId().equals(id));
    }
}
