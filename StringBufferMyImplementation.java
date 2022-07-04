package dsa_assignment_05;

/**
 *
 * @author 1999k
 */
public class StringBufferMyImplementation {

    private char[] buffer;
    private int capacity;
    private int length;

    public StringBufferMyImplementation() {
        this(16);
    }

    public StringBufferMyImplementation(int l) {
        capacity = l;
        buffer = new char[capacity];
        length = 0;
    }

    public synchronized StringBufferMyImplementation append(String str) {
        String s = str;
        if (s == null) {
            s = "null";
        }
        if (length + s.length() > capacity) {
            int l = Math.max(length + s.length(), 2 * capacity);
            char[] b = new char[l];
            for (int i = 0; i < length; i++) {
                b[i] = buffer[i];
            }
            buffer = b;
            capacity = l;
        }
        for (int i = 0; i < s.length(); i++) {
            buffer[length + i] = s.charAt(i);
        }
        length += s.length();
        return this;
    }

    public String toString() {
        return new String(buffer, 0, length);
    }

    public static void main(String[] args) {

        StringBufferMyImplementation sbmi = new StringBufferMyImplementation();

        sbmi.append("This is my String Buffer Implementation.");

        System.out.println(sbmi);

    }

}
