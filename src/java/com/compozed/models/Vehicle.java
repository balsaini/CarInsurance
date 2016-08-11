package com.compozed.models;

import javax.persistence.*;

@Entity
@Table(name = "vehicles")
@Access(AccessType.PROPERTY)
public class Vehicle {
    private int id;
    private String make;
    private String model;
    private int year;
    private Client client;

    public Vehicle(String make, String model, int year, Client client) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.client = client;
    }

    public Vehicle(String make, String model, int year) {
        this(make, model, year, null);
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
    @Column(name = "make", length = 45)
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }

    @Basic
    @Column(name = "model", length = 45)
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "year")
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    public Client getClient() {return client;}
    public void setClient(Client client) {this.client = client;}
}
