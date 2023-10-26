package jade;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class MouseListenerTest {

    @Test
    public void testGet() throws NoSuchFieldException, IllegalAccessException{
        // Reset the instance field to null (to ensure the test starts with clean state)
        Field instance = MouseListener.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);

        // call get() method
        MouseListener mouseListener1 = MouseListener.get();
        MouseListener mouseListener2 = MouseListener.get();

        // ensure two instances are the same
        assertSame(mouseListener1, mouseListener2);
    }

}