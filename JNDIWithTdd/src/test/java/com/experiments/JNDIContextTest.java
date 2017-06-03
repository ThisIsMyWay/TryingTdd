package com.experiments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.naming.NameAlreadyBoundException;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.experiments.types.DbConnection;

public class JNDIContextTest {

    JNDIContext contextToTest;

    @BeforeEach
    public void initializeContext() {
        contextToTest = new JNDIContext();
    }

    @Test
    public void lookupByName() throws NamingException {
        // given
        DbConnection dbConnection = new DbConnection();
        dbConnection.setHost("localhost");
        dbConnection.setUser("joe");
        dbConnection.setPw("pw");
        contextToTest.bind("json:/testconnection/oracledb", dbConnection);
        // when
        Object obj = contextToTest.lookup("json:/connection/oracledb");

        // then
        assertTrue(obj instanceof DbConnection);

    }

    @Test
    public void lookupByNameCheckNull() throws NamingException {
        // given

        // when
        Object obj = contextToTest.lookup("json:/connection/randomname");

        // then
        assertNull(obj);
    }

    @Test
    public void lookupByNameException() throws NamingException {

        // then
        assertThrows(NamingException.class, () -> {
            contextToTest.lookup("jsoneeefsda:\\connection/randomname");
        });
    }

    @Test
    public void bindTest() throws NamingException {
        // given
        DbConnection dbConnection = new DbConnection();
        dbConnection.setHost("localhost");
        dbConnection.setUser("joe");
        dbConnection.setPw("pw");
        contextToTest.bind("json:/testconnection/oracledb", dbConnection);

        // when
        Object obj = contextToTest.lookup("json:/testconnection/oracledb");

        // then
        assertEquals(dbConnection, obj);
    }

    @Test
    public void bindTestNullable() throws NamingException {
        // given
        DbConnection dbConnection = new DbConnection();
        dbConnection.setHost("localhost");
        dbConnection.setUser("joe");
        dbConnection.setPw("pw");
        contextToTest.bind("json:/testconnection/oracledb", dbConnection);

        // when
        Object obj = contextToTest.lookup("json:/testconnection/mssqldb");

        // then
        assertEquals(dbConnection, obj);
    }

    @Test
    public void doubleBinnding() throws NamingException {
        // given
        DbConnection dbConnection = new DbConnection();
        dbConnection.setHost("localhost");
        dbConnection.setUser("joe");
        dbConnection.setPw("pw");
        contextToTest.bind("json:/testconnection/oracledb", dbConnection);

        // when
        // then
        assertThrows(NameAlreadyBoundException.class, () -> {
            contextToTest.bind("json:/testconnection/oracledb", dbConnection);
        });
    }

    @Test
    public void rebind() throws NamingException {
        // given
        DbConnection dbConnection = new DbConnection();
        dbConnection.setHost("localhost");
        dbConnection.setUser("joe");
        dbConnection.setPw("pw");
        contextToTest.bind("json:/testconnection/oracledb", dbConnection);

        // when
        DbConnection dbConn = new DbConnection();
        dbConn.setHost("localhost2");
        dbConn.setUser("mit");
        dbConn.setPw("pw2");
        contextToTest.rebind("json:/testconnection/oracledb", dbConn);

        // then
        assertEquals(dbConn, contextToTest.lookup("json:/testconnection/oracledb"));
    }

    @Test
    public void rebindFailure() throws NamingException {
        // given
        DbConnection dbConn = new DbConnection();
        dbConn.setHost("localhost2");
        dbConn.setUser("mit");
        dbConn.setPw("pw2");

        // when
        // then
        assertThrows(NamingException.class, () -> {
            contextToTest.bind("json:/testconnection/oracledb", dbConn);
        });
    }

    @Test
    public void unbind() throws NamingException {
        // given
        DbConnection dbConn = new DbConnection();
        dbConn.setHost("localhost2");
        dbConn.setUser("mit");
        dbConn.setPw("pw2");
        contextToTest.bind("json:/testconnection/oracledb", dbConn);

        // when
        contextToTest.unbind("json:/testconnection/oracledb");

        // then
        assertNull(contextToTest.lookup("json:/testconnection/oracledb"));
    }

    @Test
    public void unbindNotExisting() throws NamingException {
        // given
        // when
        // then
        assertThrows(NameNotFoundException.class, () -> {
            contextToTest.unbind("json:/testconnection/oracledb");
        });
    }

    @Test
    public void rename() throws NamingException {
        // given
        DbConnection dbConn = new DbConnection();
        dbConn.setHost("localhost2");
        dbConn.setUser("mit");
        dbConn.setPw("pw2");
        contextToTest.bind("json:/testconnection/oracledb", dbConn);

        // when
        contextToTest.rename("json:/testconnection/oracledb", "json:/testconnection/mssqldb");

        // then
        assertEquals(dbConn, contextToTest.lookup("json:/testconnection/mssqldb"));
    }

    @Test
    public void renameFailure() throws NamingException {
        // given
        DbConnection oracledbConn = new DbConnection();
        oracledbConn.setHost("localhost2");
        oracledbConn.setUser("mit");
        oracledbConn.setPw("pw2");
        contextToTest.bind("json:/testconnection/oracledb", oracledbConn);

        DbConnection mssqlDBConn = new DbConnection();
        mssqlDBConn.setHost("localhost3");
        mssqlDBConn.setUser("mssql");
        mssqlDBConn.setPw("pw2");
        contextToTest.bind("json:/testconnection/mssql", mssqlDBConn);

        // when
        // then
        assertThrows(NameAlreadyBoundException.class, () -> {
            contextToTest.rename("json:/testconnection/oracledb", "json:/testconnection/mssql");
        });
    }

    @Test
    public void renameEmpty() {
        // given
        // when
        // then
        assertThrows(NamingException.class, () -> {
            contextToTest.rename("json:/testconnection/oracledb", "json:/testconnection/mssql");
        });
    }

}
