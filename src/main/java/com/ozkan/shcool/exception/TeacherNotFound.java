package com.ozkan.shcool.exception;

public class TeacherNotFound extends ClassNotFoundException{
    public TeacherNotFound(String s) {
        super(s);
    }
}
