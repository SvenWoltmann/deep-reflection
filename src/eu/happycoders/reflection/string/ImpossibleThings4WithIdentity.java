package eu.happycoders.reflection.string;

import java.lang.reflect.Field;

public class ImpossibleThings4WithIdentity {
    static {
        try {
            Field VALUE = String.class.getDeclaredField("value");
            VALUE.setAccessible(true);
            String s1 = "Hello world";
            System.out.println("identityHashCode(s1) = " + System.identityHashCode(s1));
            VALUE.set(s1, "You have been hacked".getBytes());
        } catch (ReflectiveOperationException e) {
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        String s2 = "Hello world";
        System.out.println("identityHashCode(s2) = " + System.identityHashCode(s2));
        System.out.println(s2);
    }
}
