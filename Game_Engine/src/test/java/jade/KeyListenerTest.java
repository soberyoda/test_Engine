package jade;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class KeyListenerTest {

    @Test
    public void testGet() throws NoSuchFieldException, IllegalAccessException {
        // Reset the instance field to null (to ensure the test starts with clean state)
        Field instance = KeyListener.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);

        // call get() method
        KeyListener keyListener1 = KeyListener.get();
        KeyListener keyListener2 = KeyListener.get();

        // ensure two instances are the same
        assertSame(keyListener1, keyListener2);
    }
}