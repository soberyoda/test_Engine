package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeTest {

    @Test
    public void testGetTime() {
        float epsilon = 0.001f;
        float startTime = Time.timeStarted;
        float elapsedTime = Time.getTime();

        assertTrue(elapsedTime >= 0);
        assertEquals(elapsedTime, (System.nanoTime()-startTime)*1E-9, epsilon);

    }
}