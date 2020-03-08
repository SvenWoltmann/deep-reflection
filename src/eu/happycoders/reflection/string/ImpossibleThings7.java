package eu.happycoders.reflection.string;

import java.lang.reflect.Field;

public class ImpossibleThings7 {
    static {
        try {
            Field VALUE = String.class.getDeclaredField("value");
            VALUE.setAccessible(true);
            VALUE.set("Hello world ✓", "You have been hacked".getBytes());
        } catch (ReflectiveOperationException e) {
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello world ✓");
    }
}
