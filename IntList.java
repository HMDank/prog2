import java.util.Arrays;

public class IntList {
    public static int countNumbers(int num) {
        return (int) (Math.log10(num)) + 1;
    }

    public static int[] intToList(int value) {
        int[] list;
        int temp = value;
        int num_digits = countNumbers(value);
        list = new int[num_digits];
        for (int index = 1; index <= num_digits; index++) {
            int digit = temp % 10;
            list[num_digits - index] = digit;
            temp = (temp - digit) / 10;
        }
        return list;

        // Source: https://www.behindjava.com/java-convert-int-to-array/
        // return String.valueOf(value).chars().map(c -> c - '0').toArray();
    }

    public static int listToInt(int[] numbers) {
        int value = 0;
        for (int index = 0; index < numbers.length; index++) {
            value *= 10;
            value += numbers[index];
        }
        return value;
    }

    public static int[] addOne(int[] numbers) {
        int num = listToInt(numbers);
        return intToList(num + 1);
    }

    public static void main(String[] args) {
        int example = 9999;
        System.out.println(Arrays.toString(intToList(example)));
        System.out.println(Arrays.toString(addOne(intToList(example))));
        System.out.println(listToInt(addOne(intToList(example))));
    }
}
