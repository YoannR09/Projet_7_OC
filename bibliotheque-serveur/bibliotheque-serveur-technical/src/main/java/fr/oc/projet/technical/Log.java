package fr.oc.projet.technical;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.inject.Named;

@Named("log")
public class Log {

    @Inject
    private static final Logger logger = LogManager.getLogger();

    public void info(String text){
        logger.info(text);
    }

    public void error(String text){
        logger.error(text);
    }
}
