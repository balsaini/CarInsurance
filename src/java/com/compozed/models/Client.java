package com.compozed.models;

import com.compozed.enums.Gender;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
@Access(AccessType.PROPERTY)
public class Client {
    private int id;
    private String name;
    private String address;
    private int age;
    private Gender gender;

    private List<Vehicle> vehicles;

    public Client(String name, String address, int age, Gender gender) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.gender = gender;
        this.vehicles = new ArrayList<>();
    }

    public Client(){

    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "address", length = 200)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Basic
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    public List<Vehicle> getVehicles() {
        return vehicles;
    }
    public void setVehicles(List<Vehicle> vehicles){
        this.vehicles = vehicles;
    }
}
