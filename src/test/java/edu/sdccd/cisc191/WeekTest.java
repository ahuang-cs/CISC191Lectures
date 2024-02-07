package edu.sdccd.cisc191;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeekTest {
    Week week;

    @BeforeEach
    void setUp() {
        week = new Week();
    }

    @Test
    void removeWeekends() {
        assertEquals(7, week.getWeek().length);
        week.removeWeekends();
        assertEquals(5, week.getWeek().length);
    }
}