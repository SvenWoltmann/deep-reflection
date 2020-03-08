package eu.happycoders.reflection.integer;

import java.lang.reflect.Field;

import static java.lang.System.exit;

public class ImpossibleThings3 {
    static {
        try {
            Field VALUE = Integer.class.getDeclaredField("value");
            VALUE.setAccessible(true);
            Integer two = Integer.valueOf(2);
            VALUE.set(two, 3);
        } catch (ReflectiveOperationException e) {
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        Integer a, b;
        a = Integer.valueOf(2);
        b = Integer.valueOf(3);
        if (a.intValue() + b.intValue() != 5) exit(1);
    }
}
