package edu.sdccd.cisc191;

import java.util.Random;

public class Week {
    private Day[] week;

    public Week() {
        week = new Day[]{Day.SUNDAY, Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, Day.THURSDAY, Day.FRIDAY, Day.SATURDAY};
    }

    public Day[] getWeek() {
        return week;
    }

    @Override
    public String toString() {
        StringBuilder weekAsString = new StringBuilder();

        for(int i = 0; i < week.length; i++) {
            if(i > 0) weekAsString.append(" ");
            weekAsString.append(week[i]);
        }

        return weekAsString.toString();
    }

    public Day getRandomDay() {
        return week[new Random().nextInt(week.length)];
    }

    public void removeWeekends() {
        Day[] newWeek = new Day[5];
        int i = 0;
        for(Day day: week) {
            if(!day.equals(Day.SUNDAY) && !day.equals(Day.SATURDAY)) {
                newWeek[i++] = day;
            }
        }
        week = newWeek;
    }
}
