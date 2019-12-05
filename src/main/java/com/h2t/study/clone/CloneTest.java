package com.h2t.study.clone;

import java.io.*;

/**
 * 拷贝方法测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/12/05 11:24
 */
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Student student = new Student();
        student.setId(1);
        student.setName("h2t");
        Score score = new Score();
        score.setChinese(100);
        score.setMath(100);
        student.setScore(score);

//        Student cloneStudent = (Student)student.clone();
//        cloneStudent.getScore().setChinese(59);
//        System.out.println(student);

        //序列化拷贝
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(student);
        oos.flush();

        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        Student cloneStudent = (Student) ois.readObject();
        cloneStudent.getScore().setChinese(59);
        System.out.println(student);
    }
}
