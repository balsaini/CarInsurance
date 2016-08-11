package com.compozed.models;
import com.compozed.util.Mysql;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;

import static org.junit.Assert.*;


public class PaymentTest {
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Before
    public void setUp() throws Exception {
        Session session = Mysql.getSession();
        session.beginTransaction();
        session.createNativeQuery("set FOREIGN_KEY_CHECKS = 0").executeUpdate();
        session.createNativeQuery("truncate table payments").executeUpdate();
        session.createNativeQuery("set FOREIGN_KEY_CHECKS = 1").executeUpdate();
        Payment payment = new Payment(100, format.parse("2016-08-01", 20,  ))
        session.save(vehicle);
        session.getTransaction().commit();
        session.close();

    }

    @After
    public void tearDown() throws Exception {

    }

}