package com.experiments;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.naming.NamingException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Liberator on 03.06.2017.
 */
public class JNDIContextRepositoryImpl implements JNDIContextRepository {

    private static JSONObject repository;

    static {
        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(JNDIContextRepositoryImpl.class.getClassLoader().getResourceAsStream("META-INF/JNDIrepository.txt"))
                );
        ) {
            repository = new JSONObject(reader.readLine()); // załadowanie repozytorium
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object lookup(String name) throws NamingException {
        JSONObject jsonObject = repository.getJSONObject(name);

        return null;
    }

    @Override
    public void bindObj(String name, Object obj) throws NamingException {

    }

    @Override
    public void remove(String name) throws NamingException {

    }
}
