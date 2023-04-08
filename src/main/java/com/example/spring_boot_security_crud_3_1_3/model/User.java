package com.example.spring_boot_security_crud_3_1_3.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "Строка имя не должна быть пустым")
    @Size(message = "Имя должно быть от 2-ух до 50 символов")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Строка фамилия не должна быть пустым")
    @Size(message = "Фамилия должна быть от 2-ух до 50 символов")
    @Column(name = "last_name")
    private String surname;

    @Min(value = 0, message = "минимум 0")
    @Column(name = "age")
    private Integer age;

    @Column(name = "password")
    @NotEmpty(message = "Строка не должна быть пустой")
    @Size(message = "Строка не должна быть пустой")
    private String password;
    @Column(name = "username")
    @NotEmpty(message = "Строка не должна быть пустой")
    @Size(message = "Строка не должна быть пустой")
    private String username;


//    @ManyToMany
//    @JoinTable(name = "users_roles",
//    joinColumns = @JoinColumn(name = "user_id"),
//    inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Collection<Role> roles;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public User(String name, String surname, Integer age, String password, String username) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.password = password;
        this.username = username;
    }

    public User() {
    }

//    public Collection<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Collection<Role> roles) {
//        this.roles = roles;
//    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
