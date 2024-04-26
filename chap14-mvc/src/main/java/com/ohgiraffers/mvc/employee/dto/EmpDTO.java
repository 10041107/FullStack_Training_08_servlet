package com.ohgiraffers.mvc.employee.dto;

public class EmpDTO {

    private int empId;
    private String empName;
    private String email;
    private String phone;


    public EmpDTO() {
    }

    public EmpDTO(int empId, String empName, String email, String phone) {
        this.empId = empId;
        this.empName = empName;
        this.email = email;
        this.phone = phone;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "EmpDTO{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
