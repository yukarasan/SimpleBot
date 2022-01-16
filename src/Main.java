import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    // Instantiating a scanner object from the Scanner class
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        greet();
        enterName();
        guessAge();
        count();
        quiz();
        end();
    }

    private static void greet() {
        // Greeting the user and asking for their name
        System.out.println("Hello! My name is BotAid 3000.");
        System.out.println("I was created in 2021 by Yusuf.");
        System.out.println("Please, remind me of your name:");
    }

    private static void enterName() {
        // Converting the first character of the input to upper case since it's a name
        String name = scanner.nextLine();

        // If the name contains any numbers between 0 - 9, they will be replaced with an empty string.
        String[] numbersInName = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        name = name.replaceAll(Arrays.toString(numbersInName),"");

        String[] otherCharacters = {"?", "´", "`", "+", "|", "~", "^", "¨", "'", "*", "_", ".", ":", ";", ","
                                    + "=", ")", "(", "/", "&", "%", "¤", "#", "\"", "!", "\\", "§", "½", "<", ">"
                                    + "@", "£", "$", "€", "{", "}", "[", "]"};
        name = name.replaceAll(Arrays.toString(otherCharacters),"");

        char firstChar = name.charAt(0);  // localizing the first character at index 0
        char lastChar = name.charAt(name.length() - 1);  // localizing the last character at index "name length"
        String firstLetter = (Character.toString(firstChar)).toUpperCase(Locale.ROOT);  // Converting to a string and making
        String restOfName = name.substring(1);  // Making a variable that separates the name at index 1

        // Determining if input contains " " and then trimming the string before computing the rest of the statements
        if (Character.toString(firstChar).matches(" ") || Character.toString(lastChar).matches(" ")) {
            name = name.trim();
            firstChar = name.charAt(0);
            firstLetter = (Character.toString(firstChar)).toUpperCase(Locale.ROOT);
            restOfName = name.substring(1);
        }

        // Detecting if the rest of the name contains any upper case letters, and converting them to lowercase
        restOfName = restOfName.toLowerCase();

        System.out.println("What a great name you have, " + firstLetter + restOfName + "!" + "\n");
    }

    private static void guessAge() {
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");

        boolean booleanAge = false;
        int remainder3;
        int remainder5;
        int remainder7;

        while (!booleanAge) {
            try {
                // Reading all remainders
                remainder3 = scanner.nextInt();
                remainder5 = scanner.nextInt();
                remainder7 = scanner.nextInt();

                // Calculating age
                booleanAge = true;
                int age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;

                // Outputs to user by printing result
                if (age > 100) {
                    System.out.println("Your age is " + age + " that's a little late to start programming.");
                    System.out.println("You should probably just relax." + "\n");
                } else {
                    System.out.println("Your age is " + age + " that's a good time to start programming!" + "\n");
                }

                break;
            } catch (InputMismatchException e) {  // Giving an error message if the input is not an integer
                System.err.println("That is not an integer. Please try again: ");  // Using err instead of out to make it red

                // Clears the scanner buffer of the wrong input
                scanner.next();
            }
        }
    }

    private static void count() {
        // The bot will now start with a new task by counting to the number that the user inputs
        System.out.println("Now I will prove to you that I can count to any number you want." + "\n"
                            + "Please enter a number: ");

        boolean numberFalse = false;

        while (!numberFalse) {
            try {
                int number = scanner.nextInt();

                if (number >= 0) {
                    for (int i = 0; i <= number; i++) {
                        if (number == 0) {
                            System.out.println(i + "! --- Can you even count to that? xD");
                            break;
                        }
                        if (i == 0) {
                            System.out.println(i + "! #Counting ｡◕ ‿ ◕｡");
                            i++;
                        }
                        System.out.println(i + "!");
                    }
                }

                if (number < 0) {
                    for (int i = 0; i >= number; i--) {
                        if (i == 0) {
                            System.out.println(i + "! #Counting ｡◕ ‿ ◕｡");
                            i--;
                        }
                        System.out.println(i + "!");
                    }
                }

                numberFalse = true;

            } catch (InputMismatchException e) {
                System.err.println("That is not an integer. Please try again:");

                // Clears the scanner buffer of the wrong input
                scanner.next();
            }
        }

        System.out.println();
    }

    private static void quiz() {
        System.out.println("Let's test your programming knowledge.\n"
                + "Why do we use methods?");

        System.out.println("""
                1. To repeat a statement multiple times.
                2. To decompose a program into several small subroutines.
                3. To determine the execution time of a program.
                4. To interrupt the execution of a program.""");

        boolean ans = false;
        int answer;

        while (!ans) {
            try {
                answer = scanner.nextInt();

                if (answer > 4 || answer <= 0) {
                    System.err.println("That's not an option");
                }

                while (answer != 2) {
                    try {
                        System.out.println("Please, try again.");
                        answer = scanner.nextInt();

                        if (answer > 4 || answer <= 0) {
                            System.err.println("That's not an option");
                        }

                    } catch (InputMismatchException e) {
                        System.err.println("That is not an integer. Please try again:");

                        // Clears the scanner buffer of the wrong input
                        scanner.next();
                    }

                    ans = true;

                }
            } catch (InputMismatchException e) {
                System.err.println("That is not an integer. Please try again:");

                // Clears the scanner buffer of the wrong input
                scanner.next();
            }
        }
    }

    private static void end() {
        System.out.println("Congratulations, you have finished your interaction with me. Have a nice day! ʕ•́ᴥ•̀ʔっ♡");
    }

}