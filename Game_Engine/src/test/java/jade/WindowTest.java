package jade;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class WindowTest {

    @Test
    public void testGet() throws NoSuchFieldException, IllegalAccessException {
        // Reset the instance field to null (to ensure the test starts with clean state)
        Field window = Window.class.getDeclaredField("window");
        window.setAccessible(true);
        window.set(null, null);

        // call get() method
        Window window1 = Window.get();
        Window window2 = Window.get();

        // ensure two instances are the same
        assertSame(window1, window2);
    }
}