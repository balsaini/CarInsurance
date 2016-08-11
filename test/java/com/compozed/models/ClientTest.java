package com.compozed.models;

import com.compozed.enums.Gender;
import com.compozed.util.Mysql;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientTest {
    @Before
    public void setUp() throws Exception {
        Session session = Mysql.getSession();
        session.beginTransaction();
        session.createNativeQuery("set FOREIGN_KEY_CHECKS = 0").executeUpdate();
        session.createNativeQuery("truncate table clients").executeUpdate();
        session.createNativeQuery("truncate table vehicles").executeUpdate();
        session.createNativeQuery("set FOREIGN_KEY_CHECKS = 1").executeUpdate();
        Client client = new Client("Alex", "123 Real Street", 25, Gender.M);
        Vehicle v1 = new Vehicle("VW", "Jetta", 2010, client);
        Vehicle v2 = new Vehicle("GM", "Cruise", 2012, client);
        client.getVehicles().add(v1);
        client.getVehicles().add(v2);
        session.save(client);
        session.getTransaction().commit();
        session.close();

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateNewClientAndSave() throws Exception {
        Session session = Mysql.getSession();
        session.beginTransaction();
        Client client = new Client("Bal", "123 Fake Street", 25, Gender.M);
        session.save(client);
        session.getTransaction().commit();
        session.close();
        assertEquals(2, client.getId());
    }

    @Test
    public void shouldGetExistingClient() throws Exception {
        Session session = Mysql.getSession();
        Client client = session.get(Client.class, 1);
        session.close();
        assertEquals(1, client.getId());
        assertEquals("Alex", client.getName());
    }

    @Test
    public void shouldUpdateExistingClient() throws Exception {
        Session session = Mysql.getSession();
        session.beginTransaction();
        Client client = session.get(Client.class, 1);
        client.setAge(21);
        session.getTransaction().commit();
        session.close();
        assertEquals(1,client.getId());
        assertEquals(21,client.getAge());
    }


}