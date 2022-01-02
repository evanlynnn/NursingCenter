package edu.jsut.nursing.model;

public class User {
    private Integer userId;

    private String idCard;

    private String name;

    private Integer age;

    private Integer status;

    private String sex;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", idCard='" + idCard + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", status=" + status +
                ", sex='" + sex + '\'' +
                '}';
    }
}