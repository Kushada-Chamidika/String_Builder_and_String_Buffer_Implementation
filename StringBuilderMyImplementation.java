package dsa_assignment_05;

import java.util.Arrays;

/**
 *
 * @author 1999k
 */
public class StringBuilderMyImplementation {

    private char[] characterBuffer;
    private int curIndex;

    public StringBuilderMyImplementation() {
        characterBuffer = new char[5];
        curIndex = 0;
    }

    public void append(String anotherString) {
        if (anotherString != null) {
            char[] charArray = anotherString.toCharArray();
            int charArrayLength = charArray.length;
            if (overflow(charArrayLength)) {
                characterBuffer = Arrays.copyOf(characterBuffer, newLength(charArrayLength));
            }
            for (int i = 0; i < charArray.length; i++) {
                characterBuffer[curIndex++] = charArray[i];
            }
        }
    }

    private int newLength(int arrayLength) {
        return (characterBuffer.length + arrayLength) + 10;
    }

    private boolean overflow(int arrayLength) {
        return (arrayLength + curIndex) > characterBuffer.length;
    }

    public String toString() {
        return new String(characterBuffer, 0, curIndex);
    }

    public static void main(String[] args) {

        StringBuilderMyImplementation sbmi = new StringBuilderMyImplementation();

        sbmi.append("This is my String Builder Implementation.");

        System.out.println(sbmi);

    }

}
