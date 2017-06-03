package com.experiments;

import com.experiments.types.DbConnection;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import javax.naming.NameAlreadyBoundException;
import javax.naming.NamingException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Liberator on 03.06.2017.
 */
public class JNDIContextRepositoryTest {

    private JNDIContextRepository jndiContextRepository;


    @BeforeEach
    public void inicjalize() {
        jndiContextRepository = new JNDIContextRepositoryImpl();
    }

    @Test
    public void lookup() throws NamingException {
        // given
        jndiContextRepository.bindObj("json:/testconnection/oracledb", new JSONObject());
        // when
        Object obj = jndiContextRepository.lookup("json:/testconnection/oracledb");
        // then
        assertTrue(obj instanceof JSONObject);
    }

    @Test
    public void lookupReturnNull() throws NamingException {
        // given
        // when
        Object obj = jndiContextRepository.lookup("json:/testconnection/oracledb");
        // then
        assertNull(obj);
    }

    @Test
    public void bindObj() throws NamingException {
        // given
        JSONObject jsonObject = new JSONObject();
        jsonObject.append("host", "localhost");
        jsonObject.append("user", "joe");
        jsonObject.append("password", "pw");
        jndiContextRepository.bindObj("json:/testconnection/oracledb", jsonObject);
        // when
        Object obj = jndiContextRepository.lookup("json:/testconnection/oracledb");
        // then
        assertEquals(jsonObject, obj);
    }

    @Test
    public void doubleBindObjThrowException() throws NamingException {
        // given
        JSONObject jsonObject = new JSONObject();
        jsonObject.append("host", "localhost");
        jsonObject.append("user", "joe");
        jsonObject.append("password", "pw");
        jndiContextRepository.bindObj("json:/testconnection/oracledb", jsonObject);
        // when
        // then
        assertThrows(NameAlreadyBoundException.class, () -> {
            jndiContextRepository.bindObj("json:/testconnection/oracledb", jsonObject);
        });
    }

    @Test
    public void remove() throws NamingException {
        // given
        jndiContextRepository.bindObj("json:/testconnection/oracledb", new JSONObject());
        // when
        jndiContextRepository.remove("json:/testconnection/oracledb");
        Object obj = jndiContextRepository.lookup("json:/testconnection/oracledb");
        // then
        assertNull(obj);
    }

    @Test
    public void removeWithoutBindObj() throws NamingException {
        // given
        // when
        // then
        assertThrows(NamingException.class, () -> {
            jndiContextRepository.remove("json:/testconnection/oracledb");
        });
    }

    @Test
    public void removeWrongNamej() throws NamingException {
        // given
        // when
        // then
        assertThrows(NamingException.class, () -> {
            jndiContextRepository.remove("json:\\testconnection\\oracledb");
        });
    }

}
