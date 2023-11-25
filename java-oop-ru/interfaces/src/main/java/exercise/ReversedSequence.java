package exercise;

import java.util.stream.IntStream;

// BEGIN
public class ReversedSequence implements CharSequence{
    private final String value;

    public ReversedSequence(String value) {
        this.value = reverse(value);
    }

    private String reverse(String str) {
        StringBuilder result = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            result.append(str.charAt(i));
        }

        return result.toString();
    }

    @Override
    public int length() {
        return value.length();
    }

    @Override
    public char charAt(int index) {
        return value.charAt(index);
    }

    @Override
    public boolean isEmpty() {
        return value.isEmpty();
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return value.subSequence(start, end);
    }

    @Override
    public IntStream chars() {
        return value.chars();
    }

    @Override
    public IntStream codePoints() {
        return value.codePoints();
    }

    @Override
    public String toString() {
        return value;
    }
}
// END
