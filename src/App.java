import java.util.*;

public class App {


    // First off, I declared the Set in wich all the possible combinations will be stored:
    private static Set<int[]> combinations = new HashSet<>();

    // Then, I created the funcion makeChange(), wich receives the value typed by the user (n) and calculates
    // the possible combinations. it does so by putting the 'n' value through 'chained' "for" loops
    // that will verify if the given 'n' value is divisible by the value of each coin, in decrescent order.
    // So, in the first loop, I verify if 'n' is divisible by 25 (a quarter dollar), and then increment 1 in the 'quarter' variable
    // for each time it is in fact divisible by 25 (if it is not divisible by the coin value, the coin variable remains as declared
    // with the value 0, and therefore the loop won't repeat itself).
    // The same goes all the way to the nicklels loop, in wich the program will verify with how many nickels the value
    // can be represented and then calculate the remnant value, that will be assigned to the pennies variable (considering that
    // '1 pennie == 1 cent', to calculate how many pennies will go to the combination, we just have to see how much is left on
    // the 'n' variable after all the loops).
    // At the end of each loop, when one whole combination has been calculated, the 'combination' array is declared,
    // , receives the current calculated combination, and then is added to the 'combinations' Set.
    // The process repeats itself until all the exclusive combinations are added to the 'combinations' Set, and then the 
    // function returns the Set.

    public static Set<int[]> makeChange(int n) {

        combinations.clear();

        for (int quarters = 0; quarters <= n / 25; quarters++) {
            for (int dimes = 0; dimes <= n / 10; dimes++) {
                for (int nickels = 0; nickels <= n / 5; nickels++) {
                    int pennies = n - (quarters * 25 + dimes * 10 + nickels * 5);
                    if (pennies >= 0) {
                        int[] combination = { quarters, dimes, nickels, pennies };
                        combinations.add(combination);
                    }
                }
            }
        }
        return combinations;
    }


    // When the program is compiled, it asks for the user to type an Integer value ( that must be positive and > 0, or
    // else an error message will appear and the code will stop) that is assigned to the 'n' variable. Then, the makeChange
    // function is called with the parameter ('n'), wich does all the calculation of the combinations. When the makeChange
    // function is over, 'main' receives the 'combinations' Set and the display it, with
    // all the possible ways of representing 'n' cents with the US Dollar coins.

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
