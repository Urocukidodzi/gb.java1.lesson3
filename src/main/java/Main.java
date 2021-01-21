import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;


public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        changeGame();

    }

    private static void changeGame() {
        System.out.println("CHANGE YOUR GAME:\n\nSUPER NUMBER press 1\nMAGIC WORDS press 2\nOUT press 0\nplease input your change:");
        int game = giveMeNumber();
        if (game == 1) {
            startGame();
        } else if (game == 2) {
            startGame2();
        } else if (game == 0) {
            return;
        } else {

            System.out.println("нет такой игры\n");
            changeGame();
        }

    }


    ////////////////////////////////////////////
////////////////////////// TASK 2 ////////////////////
    ////////////////////////////////////////////


    public static void startGame2() {

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String rightWord = randomWord(words);


        System.out.println("*****************************");
        System.out.println("******* MAGIC WORDS *********");
        System.out.println("*****************************");

        System.out.println("\nYou need guess a word\n");

        System.out.println("word list: ");
        wordswatch(words);
        while (true) {
            System.out.print("write your word: ");
//            System.out.println(rightWord);
            String userWord = giveMeWord().toLowerCase();
            if (equivalentToWord(rightWord, userWord)) {
                System.out.println("Congratulations! You WIN!!!");
                break;
            }
            showError(rightWord, userWord);
        }

        replaing(2);
    }

    private static void showError(String rightWord, String userWord) {
        int length = 0;
        char rightChar = 0;
        char userChar = 0;
        if (rightWord.length() > userWord.length()) {
            length = userWord.length();
        } else {
            length = rightWord.length();
        }
        System.out.println("\nYou wrong young paddavan (Star Wars). I show you right letter: ");
        for (int i = 0; i < 15; i++, length--) {
            if (length <= 0) {
                System.out.print("#");
            } else {
                rightChar = rightWord.charAt(i);
                userChar = userWord.charAt(i);
                if (!equivalentChar(rightChar, userChar)) {
                    System.out.print("#");
                } else {
                    System.out.print(rightChar);
                }
            }
        }
        System.out.println();


    }

    private static boolean equivalentChar(char rightChar, char userChar) {
        if (rightChar == userChar) {
            return true;
        }
        return false;
    }

    private static boolean equivalentToWord(String rightWord, String userWord) {
        if (rightWord.equals(userWord)) {
            return true;
        }
        return false;
    }

    private static String randomWord(String[] words) {
        return words[randomNumber(words.length)];
    }

    private static void wordswatch(String[] words) {
        int i = 0;
        for (String word : words) {
            i++;
            System.out.print(word + ", ");
            if (i == 6) {
                System.out.println();
                i = 0;
            }
        }
        System.out.println("\n");
    }

    ////////////////////////////////////////////
/////////////////////////// TASK 1 /////////////////////
    ////////////////////////////////////////////
    public static void startGame() {
        System.out.println("*****************************");
        System.out.println("******* SUPER NUMBER ********");
        System.out.println("*****************************");

        System.out.println("\nYou need guess a number\n");

        int between0And = 9;
        int rightNumber = randomNumber(9);
        int lives = 3;

        int userNumber = -1;

        for (int i = lives - 1; i >= 0; i--) {
            lives = i;
            System.out.print("Please insert number between 0 and " + between0And + ": ");
            userNumber = giveMeNumber();

            if (equivalentNumbers(rightNumber, userNumber)) {
                lives++;
                break;
            }

        }
        if (lives == 0) {
            System.out.println("Sorry. You lost.");
        }

        replaing(1);


    }

    private static void replaing(int gameID) {
        System.out.println("\nDo you want to try again?");
        System.out.println("Yes press \"1\" or No press \"0\"");

        if (giveMeNumber() == 1) {
            System.out.println();
            switch (gameID) {
                case 1:
                    startGame();
                case 2:
                    startGame2();
            }
        }

    }

    private static boolean equivalentNumbers(int rightNumber, int userNumber) {
        if (rightNumber == userNumber) {
            System.out.println("Congratulation! You win!!!");
            return true;
        } else if (rightNumber < userNumber) {
            System.out.println("Your number is greater");
        } else if (rightNumber > userNumber) {
            System.out.println("Your number is less");
        }
        return false;
    }


    public static int randomNumber(int pool) {
        Random random = new Random();
        return random.nextInt(pool + 1);
    }

    public static int giveMeNumber() {
        if (sc.hasNextInt()) {
            return sc.nextInt();
        } else {
            System.out.println("It is not a number. Please try again.");
            return giveMeNumber();
        }
    }

    public static String giveMeWord() {
        if (sc.hasNextInt()) {
            sc.nextInt();
            sc.nextLine();
            System.out.println("you input number. Please try again: ");

            return giveMeWord();
        }
        return sc.nextLine();

    }

}

