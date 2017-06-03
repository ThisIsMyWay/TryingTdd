package com.experiments;

import java.util.Hashtable;

import javax.naming.Binding;
import javax.naming.Context;
import javax.naming.Name;
import javax.naming.NameClassPair;
import javax.naming.NameParser;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

public class JNDIContext implements Context {

    public Object lookup(Name name) throws NamingException {
        
        return null;
    }

    public Object lookup(String name) throws NamingException {
        // TODO Auto-generated method stub
        return null;
    }

    public void bind(Name name, Object obj) throws NamingException {
        // TODO Auto-generated method stub
        
    }

    public void bind(String name, Object obj) throws NamingException {
        // TODO Auto-generated method stub
        
    }

    public void rebind(Name name, Object obj) throws NamingException {
        // TODO Auto-generated method stub
        
    }

    public void rebind(String name, Object obj) throws NamingException {
        // TODO Auto-generated method stub
        
    }

    public void unbind(Name name) throws NamingException {
        // TODO Auto-generated method stub
        
    }

    public void unbind(String name) throws NamingException {
        // TODO Auto-generated method stub
        
    }

    public void rename(Name oldName, Name newName) throws NamingException {
        // TODO Auto-generated method stub
        
    }

    public void rename(String oldName, String newName) throws NamingException {
        // TODO Auto-generated method stub
        
    }

    public NamingEnumeration<NameClassPair> list(Name name) throws NamingException {
        // TODO Auto-generated method stub
        return null;
    }

    public NamingEnumeration<NameClassPair> list(String name) throws NamingException {
        // TODO Auto-generated method stub
        return null;
    }

    public NamingEnumeration<Binding> listBindings(Name name) throws NamingException {
        // TODO Auto-generated method stub
        return null;
    }

    public NamingEnumeration<Binding> listBindings(String name) throws NamingException {
        // TODO Auto-generated method stub
        return null;
    }

    public void destroySubcontext(Name name) throws NamingException {
        // TODO Auto-generated method stub
        
    }

    public void destroySubcontext(String name) throws NamingException {
        // TODO Auto-generated method stub
        
    }

    public Context createSubcontext(Name name) throws NamingException {
        // TODO Auto-generated method stub
        return null;
    }

    public Context createSubcontext(String name) throws NamingException {
        // TODO Auto-generated method stub
        return null;
    }

    public Object lookupLink(Name name) throws NamingException {
        // TODO Auto-generated method stub
        return null;
    }

    public Object lookupLink(String name) throws NamingException {
        // TODO Auto-generated method stub
        return null;
    }

    public NameParser getNameParser(Name name) throws NamingException {
        // TODO Auto-generated method stub
        return null;
    }

    public NameParser getNameParser(String name) throws NamingException {
        // TODO Auto-generated method stub
        return null;
    }

    public Name composeName(Name name, Name prefix) throws NamingException {
        // TODO Auto-generated method stub
        return null;
    }

    public String composeName(String name, String prefix) throws NamingException {
        // TODO Auto-generated method stub
        return null;
    }

    public Object addToEnvironment(String propName, Object propVal) throws NamingException {
        // TODO Auto-generated method stub
        return null;
    }

    public Object removeFromEnvironment(String propName) throws NamingException {
        // TODO Auto-generated method stub
        return null;
    }

    public Hashtable<?, ?> getEnvironment() throws NamingException {
        // TODO Auto-generated method stub
        return null;
    }

    public void close() throws NamingException {
        // TODO Auto-generated method stub
        
    }

    public String getNameInNamespace() throws NamingException {
        // TODO Auto-generated method stub
        return null;
    }

}
