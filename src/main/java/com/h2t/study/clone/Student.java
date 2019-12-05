package com.h2t.study.clone;

import java.io.Serializable;

/**
 * 用户实体
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/12/05 11:22
 */
public class Student implements Cloneable, Serializable {
    private int id;
    private String name;
    private Score score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        Student student = (Student) super.clone();
//        Score score = student.getScore();
//        student.setScore((Score)score.clone());
//        return student;
//    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
