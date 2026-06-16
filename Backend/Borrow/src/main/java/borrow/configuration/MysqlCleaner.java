package borrow.configuration;


import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MysqlCleaner implements ServletContextListener {

	@Override
    public void contextDestroyed(ServletContextEvent sce) {

        try {

            AbandonedConnectionCleanupThread.checkedShutdown();	
            
	            Enumeration<Driver> drivers =
	                    DriverManager.getDrivers();
	
	            while (drivers.hasMoreElements()) {
	
	                Driver driver = drivers.nextElement();
	
	                DriverManager.deregisterDriver(driver);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
