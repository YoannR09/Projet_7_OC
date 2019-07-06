package fr.oc.projet.batch;

import fr.oc.projet.business.contract.ManagerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * Hello world!
 *
 */
@ComponentScan
@EnableScheduling
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext vApplicationContext
                = new ClassPathXmlApplicationContext("classpath:/bootstrapContext.xml");

        ManagerFactory managerFactory = vApplicationContext.getBean("managerFactoryImpl", ManagerFactory.class);

        Timer timer;
        timer = new Timer();

        timer.scheduleAtFixedRate(new ScheduledTasks(managerFactory), 1000, 10000);
    }
}
