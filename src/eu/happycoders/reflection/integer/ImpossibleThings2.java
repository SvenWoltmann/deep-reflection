package eu.happycoders.reflection.integer;

import java.lang.reflect.Field;

import static java.lang.System.exit;

public class ImpossibleThings2 {
    static {
        try {
            Field VALUE = Integer.class.getDeclaredField("value");
            VALUE.setAccessible(true);
            VALUE.set(2, 3);
        } catch (NoSuchFieldException e) {
            throw new Error(e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Integer a, b;
        a = 2; b = 3; if (a + b != 5) exit(1);
    }
}
