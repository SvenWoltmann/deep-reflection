package eu.happycoders.reflection.string;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Experimental {

    private static final String SOURCE = "Hello world ✓";
    private static final String DEST = "You have been hacked";

    static {
        try {
            Field VALUE = String.class.getDeclaredField("value");
            VALUE.setAccessible(true);


            byte[] sourceBytes = (byte[]) VALUE.get(SOURCE);
            System.out.println("Source \"" + SOURCE + "\" as bytes:      " + hexString(sourceBytes));
            System.out.println("Source \"" + SOURCE + "\" as UTF-16:     " + hexString(SOURCE.getBytes(StandardCharsets.UTF_16)));
            System.out.println("Source \"" + SOURCE + "\" as ISO_8859_1: " + hexString(SOURCE.getBytes(StandardCharsets.ISO_8859_1)));

            byte[] bytes = DEST.getBytes();
            System.out.println("Dest \"" + DEST + "\" as bytes: " + hexString(bytes));
            System.out.println("Dest \"" + DEST + "\" as UTF-16: " +hexString(DEST.getBytes(StandardCharsets.UTF_16)));

            VALUE.set(SOURCE, bytes);
            // VALUE.set("Hello world", "You have been hacked €".getBytes());
        } catch (ReflectiveOperationException e) {
            throw new Error(e);
        }
    }

    private static String hexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (byte b:bytes) {
            if (sb.length()>1)sb.append(" ");
            String h = Integer.toHexString(b);
            // sb.append('x');
            if (h.length()==1)sb.append('0');
            sb.append(h);
        }
        sb.append(']');
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(SOURCE);
        System.out.println(SOURCE.length());
    }
}
