package eu.happycoders.reflection.string_hacker;

import java.lang.reflect.Field;

public class StringHacker_Java7 {
    public static void hackString(String from, String to) {
        try {
            Field VALUE = String.class.getDeclaredField("value");
            VALUE.setAccessible(true);
            VALUE.set(from, VALUE.get(to));

            // For "Compact Strings" introduced in Java 9
            try {
                Field CODER = String.class.getDeclaredField("coder");
                CODER.setAccessible(true);
                CODER.set(from, CODER.get(to));
            } catch (NoSuchFieldException e) {
                // Ignore
            }
        } catch (ReflectiveOperationException e) {
            throw new Error(e);
        }
    }
}
