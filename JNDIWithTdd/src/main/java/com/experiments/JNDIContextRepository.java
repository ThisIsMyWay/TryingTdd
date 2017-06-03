package com.experiments;

import javax.naming.Name;
import javax.naming.NamingException;

/**
 * Created by Liberator on 03.06.2017.
 */
public interface JNDIContextRepository {
    Object lookup(String name) throws NamingException;
    void bindObj(String name, Object obj) throws NamingException;
    void remove(String name) throws NamingException;
}
