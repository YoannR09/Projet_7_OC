package fr.oc.projet.batch;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class StartTimer {


    public static void main(final String[] args) {
        Timer timer;
        timer = new Timer();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE,1);
        timer.scheduleAtFixedRate(new ActionMailTask(), cal.getTime(), 86400000);
    }
}
