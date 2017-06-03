package com.experiments;

import javax.naming.CompoundName;
import javax.naming.Name;
import javax.naming.NameParser;
import javax.naming.NamingException;
import java.util.Properties;

/**
 * Created by Liberator on 03.06.2017.
 */
public class JNDIParser implements NameParser{

    public static Properties syntax = new Properties();

    static {
        syntax.put("jndi.syntax.direction", "left_to_right");
        syntax.put("jndi.syntax.separator", "/");
        syntax.put("jndi.syntax.ignorecase", "false");
    }

    @Override
    public Name parse(String name) throws NamingException {
        return new CompoundName(name, syntax);
    }
}
