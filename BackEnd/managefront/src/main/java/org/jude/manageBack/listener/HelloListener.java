package org.jude.manageBack.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HelloListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
        System.out.println("I'm listener");
    }

    public void contextDestroyed(ServletContextEvent event) {

    }
}
