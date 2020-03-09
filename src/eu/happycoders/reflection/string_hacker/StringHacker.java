package eu.happycoders.reflection.string_hacker;

import java.lang.reflect.Field;

public class StringHacker {
    public static void hackString(String from, String to) {
        try {
            Field VALUE = String.class.getDeclaredField("value");
            VALUE.setAccessible(true);
            VALUE.set(from, VALUE.get(to));

            // "offset" and "count" for Strings up to Java 6
            try {
                Field OFFSET = String.class.getDeclaredField("offset");
                OFFSET.setAccessible(true);
                OFFSET.setInt(from, OFFSET.getInt(to));

                Field COUNT = String.class.getDeclaredField("count");
                COUNT.setAccessible(true);
                COUNT.setInt(from, COUNT.getInt(to));
            } catch (NoSuchFieldException e) {
                // Ignore
            }

            // For "Compact Strings" introduced in Java 9
            try {
                Field CODER = String.class.getDeclaredField("coder");
                CODER.setAccessible(true);
                CODER.set(from, CODER.get(to));
            } catch (NoSuchFieldException e) {
                // Ignore
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
