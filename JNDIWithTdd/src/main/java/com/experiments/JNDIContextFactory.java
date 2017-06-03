package com.experiments;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.spi.InitialContextFactory;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Liberator on 03.06.2017.
 */
public class JNDIContextFactory implements InitialContextFactory {

    @SuppressWarnings("unchecked")
    @Override
    public Context getInitialContext(Hashtable<?, ?> environment) throws NamingException {
        return new JNDIContext((Map<String, Object>)environment);
    }

}
