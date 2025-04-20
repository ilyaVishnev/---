package com.workers.workers.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "worker_info")
public class Worker {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "date_of_birth")
    private Date date_of_birth;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;

    public Worker(Long id,String last_name,String first_name,String patronymic
            ,Date date_of_birth, String email,String phone) {
        this.id = id;
        this.last_name = last_name;
        this.first_name = first_name;
        this.patronymic = patronymic;
        this.date_of_birth = date_of_birth;
        this.email = email;
        this.phone = phone;
    }

    public Worker(){}

    public Long getId() {
        return id;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(this.getId()+"");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return Objects.equals(this.getId(), worker.getId());
    }
}
