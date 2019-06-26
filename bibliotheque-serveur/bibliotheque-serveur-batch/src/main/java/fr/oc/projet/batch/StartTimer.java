package fr.oc.projet.batch;


import java.util.Date;
import java.util.Timer;

public class StartTimer {


    public static void main(final String[] args) {
        Timer timer;
        timer = new Timer();
        timer.scheduleAtFixedRate(new ActionMailTask(), new Date(), 86400000);
    }
}
