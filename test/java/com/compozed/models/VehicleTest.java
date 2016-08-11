package com.compozed.models;
import com.compozed.enums.Gender;
import com.compozed.util.Mysql;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.Basic;

import static org.junit.Assert.*;



public class VehicleTest {
    @Before
    public void setUp() throws Exception {
        Session session = Mysql.getSession();
        session.beginTransaction();
        session.createNativeQuery("set FOREIGN_KEY_CHECKS = 0").executeUpdate();
        session.createNativeQuery("truncate table vehicles").executeUpdate();
        session.createNativeQuery("set FOREIGN_KEY_CHECKS = 1").executeUpdate();
        Client client = new Client("Alex", "123 Real Street", 25, Gender.M);
        Vehicle vehicle = new Vehicle("Volvo", "S70", 2017);
        session.save(vehicle);
        session.getTransaction().commit();
        session.close();

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateNewVehicleAndSave() throws Exception {
        Session session = Mysql.getSession();
        session.beginTransaction();
        Vehicle vehicle = new Vehicle("Volvo", "S90", 2016);
        session.save(vehicle);
        session.getTransaction().commit();
        session.close();
        assertEquals(2, vehicle.getId());

    }

}