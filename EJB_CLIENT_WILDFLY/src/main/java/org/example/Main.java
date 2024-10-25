package org.example;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws NamingException {
        Properties jndiProps = new Properties();
        jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProps.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        jndiProps.put("jboss.naming.client.ejb.context", true);

        Context context = new InitialContext(jndiProps);
        String jndiName = "ejb:/EJB-1.0-SNAPSHOT/HelloImpl!org.example.Hello";

        Hello helloBean = (Hello) context.lookup(jndiName);
        String message = helloBean.sayHello("World");
        System.out.println(message);
    }
}
