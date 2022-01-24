package com.example.studentlist_navgraph.ui.home.model;

public class Student {
    String name = "a";
    String id = "b";
    boolean flag = false;

    public Student(){}
    public Student(String name, String id, boolean flag) {
        this.name = name;
        this.id = id;
        this.flag = flag;
    }

    public void setId(String id) {
        if(id==null)
            return;
        this.id = id;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public boolean isFlag() {
        return flag;
    }
}
