package org.example.EJB_Connexion;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class CDManagerAdmin {

    public static <T> T lookup(String jndiName, Class<T> clazz) {
        try {
            // Configuration de JNDI
            Properties props = new Properties();
            props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
            props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
            props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
            props.setProperty("org.omg.CORBA.ORBInitialPort", "1099");

            InitialContext ctx = new InitialContext(props);
            return clazz.cast(ctx.lookup(jndiName));
        } catch (NamingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
