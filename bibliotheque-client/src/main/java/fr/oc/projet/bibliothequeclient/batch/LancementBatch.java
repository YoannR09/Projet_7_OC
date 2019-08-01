package fr.oc.projet.bibliothequeclient.batch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.Timer;


/**
 * Classe main du batch
 * On lance la classe SheduledTasks via sheduledAtFixedRate
 * Le délai de répétition est définit dans le config.properties
 */
@EnableScheduling
public class LancementBatch
{
    public static void main( String[] args ){

        final Logger logger = LogManager.getLogger();

        try (InputStream input = new FileInputStream("C:\\Users\\El-ra\\Documents\\Projet_7_OC\\resources\\config.properties")) {

            Properties prop = new Properties();
            // load a properties file
            prop.load(input);

            Timer timer;
            timer = new Timer();
            timer.scheduleAtFixedRate(new ScheduledTasks(logger), 1000, Integer.parseInt(prop.getProperty("timeMail")));
        }catch (Exception e){
            logger.error(e);
            e.printStackTrace();
        }
    }
}
