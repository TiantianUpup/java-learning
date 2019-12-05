package com.h2t.study.clone;

import java.io.Serializable;

/**
 * 成绩实体
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/12/05 15:43
 */
public class Score implements Cloneable, Serializable {
    private int math;

    private int chinese;

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

    @Override
    public String toString() {
        return "Score{" +
                "math=" + math +
                ", chinese=" + chinese +
                '}';
    }
}
