import java.util.*;

public class App {

    private static Set<int[]> combinations = new HashSet<>();

    public static Set<int[]> makeChange(int n) {

        combinations.clear();

        for (int quarters = 0; quarters <= n / 25; quarters++) {
            for (int nickels = 0; nickels <= n / 10; nickels++) {
                for (int dimes = 0; dimes <= n / 5; dimes++) {
                    int pennies = n - (quarters * 25 + nickels * 10 + dimes * 5);
                    if (pennies >= 0) {
                        int[] combination = { quarters, nickels, dimes, pennies };
                        combinations.add(combination);
                    }
                }
            }
        }
        return combinations;
    }

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        System.out.println("Type a value in cents:");
        int n = input.nextInt();
        input.close();

        if (n <= 0) {
            System.out.println("The given value is not valid. Please inform a number bigger than 0.");
        } else {
            Set<int[]> result = makeChange(n);

            System.out.printf("Ways of representing %d coins: \n", n);
            for (int[] combination : result) {
                System.out.println(Arrays.toString(combination));
            }
        }

    }
}
