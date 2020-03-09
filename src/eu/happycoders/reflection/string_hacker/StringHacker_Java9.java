package eu.happycoders.reflection.string_hacker;

import java.lang.reflect.Field;

public class StringHacker_Java9 {
    public static void hackString(String victim, String replacement) {
        try {
            Field VALUE = String.class.getDeclaredField("value");
            VALUE.setAccessible(true);

            Field CODER = String.class.getDeclaredField("coder");
            CODER.setAccessible(true);

            VALUE.set(victim, VALUE.get(replacement));
            CODER.set(victim, CODER.get(replacement));
        } catch (ReflectiveOperationException e) {
            throw new Error(e);
        }
    }
}
