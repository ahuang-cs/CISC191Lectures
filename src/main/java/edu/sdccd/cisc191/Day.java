package edu.sdccd.cisc191;

import java.util.Random;

public enum Day {
    SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY;

    /**
     * Day.getRandomDay returns a random Day of the week
     * @return random Day
     */
    public static Day getRandomDay() {
        return Day.values()[new Random().nextInt(Day.values().length)];
    }
}
