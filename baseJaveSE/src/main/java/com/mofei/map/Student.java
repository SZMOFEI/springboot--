package com.mofei.map;

/**
 * @author mofei
 * @date 2018/10/17 9:29
 */
public class Student {
    private String userName;
    private String age;

    @Override
    public String toString() {
        return "Student{" +
                "userName='" + userName + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
