public class Debug { // "ckass" instead of "class"
    // Methode that checks whether a given number is prime
    public static boolean isPrime(int n) {
        // Return false if number is one, zero or negative
        if (n < 2) { // Includes 2
            return false;
        }
        // Check for all factors smaller and equal to n/2 whether it is a prime factor.
        // If it is a prime factor, return false.
        for (int i = 2; i <= n / 2; i++) { // Loops backwards, which means it only runs once with i = 2
            if (n % i == 0) {
                return false;
            }
        }
        // If no prime factor was found, return true.
        return true;
    }

    // Method that prints all numbers in an array that are prime
    public static void printPrime(int[] arr) { // void instead of String for return type
        for (int i = 0; i < arr.length; i++) { // Loops over length of array
            if (isPrime(arr[i])) {
                System.out.println(arr[i]);
            }
        }
    }

    public static void main(String[] args) { // Missing main()
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        printPrime(arr);
    }

    // output should be as follows:
    // 2
    // 3
    // 5
    // 7

    /*
     * 1. "ckass" instead of "class" :
     ************
     * Debug.java:1: error: class, interface, enum, or record expected
     * ckass Debug {
     * ^
     ************
     * The Compiler expects one of the keywords, which is not the case here. The
     * error message also points to "ckass" being mistyped.
     *
     * 2. main() missing :
     ************
     * Debug.java:30: error: invalid method declaration; return type required
     * printPrime(arr);
     * ^
     ************
     * It's obvious that the function is called within class Debug without a main()
     * function.
     *
     * 3. printPrime() doesn't return a String :
     ************
     * Debug.java:26: error: missing return statement
     * }
     * ^
     * 1 error
     ************
     * printPrime() is expected to return a string, which is not found within the
     * function.
     * (it doens't make sense for a print function to return a String as well, so
     * the expected return type should therefore be changed to void)
     *
     * 4. For loop loops beyond the length of the array :
     **********
     * Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 10
     * out of bounds for length 10
     * at Debug.printPrime(Debug.java:22)
     * at Debug.main(Debug.java:31)
     **********
     * The for loop loops from arr[0] to arr[arr.length], which is bad since that
     * indicates the array is of length arr.length + 1
     *
     * 5. For loop loops beyond the length of the arra
     **********
     * // Return false if number is one, zero or negative
     * if (n <= 2) {
     **********
     * This includes 2 as well, which contradicts the doccumentation.
     *
     * 6. Loop doesn't actually "loop"
     **********
     * // Check for all factors smaller and equal to n/2 whether it is a prime
     * factor.
     * // If it is a prime factor, return false.
     * for (int i = 2; i <= n / 2; i--) {
     **********
     * The loop loops backwards, which means it only runs once with i = 2.
     *
     * 7. Wrong return
     **********
     * // If it is a prime factor, return false.
     * for (int i = 2; i <= n / 2; i++) { // Loops backwards, which means it only
     * runs once with i = 2
     * if (n % i == 0) {
     * return true;
     * }
     * }
     **********
     * Returns true instead of false according to the documentation.
     *
     */
}
