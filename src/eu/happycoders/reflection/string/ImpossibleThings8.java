package eu.happycoders.reflection.string;

import java.lang.reflect.Field;

public class ImpossibleThings8 {
    static {
        try {
            Field VALUE = String.class.getDeclaredField("value");
            VALUE.setAccessible(true);

            Field CODER = String.class.getDeclaredField("coder");
            CODER.setAccessible(true);

            VALUE.set("Hello world ✓", VALUE.get("You have been hacked"));
            CODER.set("Hello world ✓", CODER.get("You have been hacked"));
        } catch (ReflectiveOperationException e) {
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello world ✓");
    }
}
