package com.connxun.morui.model.entity;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

/**
 * Created by wushange on 2017/7/12.
 */

@Entity
public class User implements Serializable {
    static final long serialVersionUID = 42L;


    /**
     * id : 1
     * role_id : 1
     * role_name : 系统管理员
     * username : admin
     * password : f87e483f8b40f78054335172d28e07cc
     * randomcode : 860232
     * status : 1
     * realname : 管理员
     * sex : 男
     * telephone : 13811111111
     * email : null
     * enterpriseId : 1
     * enterpriseName : 道可二厂
     * departmentId : 3
     * departmentName : 生产技术部
     * jobsId : 1
     * jobsName : 总经理
     * create_person : 开发者
     * create_date : 2017-05-10 19:24
     * rowIndex : 0
     */
    @PrimaryKey
    private long   id;
    private int    role_id;
    private String role_name;
    private String username;
    private String password;
    private String randomcode;
    private int    status;
    private String realname;
    private String sex;
    private String telephone;
    private String email;
    private int    enterpriseId;
    private String enterpriseName;
    private int    departmentId;
    private String departmentName;
    private int    jobsId;
    private String jobsName;
    private String create_person;
    private String create_date;
    private int    rowIndex;
    private String token;
    private String realPwd;


    public User() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRole_id() {
        return this.role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return this.role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRandomcode() {
        return this.randomcode;
    }

    public void setRandomcode(String randomcode) {
        this.randomcode = randomcode;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRealname() {
        return this.realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEnterpriseId() {
        return this.enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return this.enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public int getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getJobsId() {
        return this.jobsId;
    }

    public void setJobsId(int jobsId) {
        this.jobsId = jobsId;
    }

    public String getJobsName() {
        return this.jobsName;
    }

    public void setJobsName(String jobsName) {
        this.jobsName = jobsName;
    }

    public String getCreate_person() {
        return this.create_person;
    }

    public void setCreate_person(String create_person) {
        this.create_person = create_person;
    }

    public String getCreate_date() {
        return this.create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public int getRowIndex() {
        return this.rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRealPwd() {
        return this.realPwd;
    }

    public void setRealPwd(String realPwd) {
        this.realPwd = realPwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", randomcode='" + randomcode + '\'' +
                ", status=" + status +
                ", realname='" + realname + '\'' +
                ", sex='" + sex + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", enterpriseId=" + enterpriseId +
                ", enterpriseName='" + enterpriseName + '\'' +
                ", departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", jobsId=" + jobsId +
                ", jobsName='" + jobsName + '\'' +
                ", create_person='" + create_person + '\'' +
                ", create_date='" + create_date + '\'' +
                ", rowIndex=" + rowIndex +
                ", token='" + token + '\'' +
                ", realPwd='" + realPwd + '\'' +
                '}';
    }
}
