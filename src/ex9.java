import java.util.Scanner;

public class ex9 {
    public static void main(String[] args) {
        int level = chooseLevel();
        int chances = caclculateChances(level);
        int[] code = createCode();
        int countGusses = 0;
        while (countGusses < chances){
            int[] userGuess = getUserGuess();
            int correctGuesses = howManyCorrectGuess(code,userGuess);
            int partialGuesses = howManyPartialGuess(code,userGuess);
            boolean isFined = areDuplicatedValues(userGuess);
            if (correctGuesses == 4){
                System.out.println("congarts you made it");
                break;
            }else{
                System.out.println("you guessed partialy: "+partialGuesses+", you guessed correctly "+ correctGuesses);
            }
            if (isFined){
                System.out.println("you lost two guesses");
                countGusses = countGusses + 2;
            }
            countGusses++;
            if (level!=4){
                System.out.println((chances - countGusses)+" guesses left");
            }
        }
        System.out.println("game over");
    }

    // the function calculates how many chances the user will geet according to the level he choose
    public static int caclculateChances(int level){
        if (level == 1)
            return 20;
        if (level == 2)
            return 15;
        if (level == 3)
            return 10;
        if (level == 4)
            return  (createRandomInRange(5,26));
        return -1;
    }

    // the function ask the user to choose valid level
    public static int chooseLevel(){
        Scanner sc = new Scanner(System.in);
        int level = -1;
        while (level<1 || level > 4){
            System.out.println("please enter one path: ");
            System.out.println("1 for easy - 20 chances");
            System.out.println("2 for medium - 15 chances");
            System.out.println("3 for hard - 10 chances");
            System.out.println("4 for suprising - 5-25 chances");
            level = sc.nextInt();
        }
        return level;

    }

    // the function checks if there are duplicated values within an array
    public static boolean areDuplicatedValues(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i]==array[j] && i !=j)
                    return true;
            }
        }
        return false;
    }


    // the function get the user guess
    public static int[] getUserGuess(){
        int[] guess = new int[4];
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter your 4 digits guess");
        for (int i = 0; i < guess.length; i++) {
            System.out.println("please enter your "+(i+1)+" digits");
            guess[i] = sc.nextInt();
            if (guess[i] > 6 || guess[i] < 1){
                System.out.println("please enter numbers between 1-6");
                i--;
            }
        }
        return guess;
    }

    // the function calculates how many correct guesses the user made
    public static int howManyCorrectGuess(int[] code,int[] guess){
        int counter = 0;
        for (int i = 0; i < guess.length; i++) {
            if (code[i] == guess[i]){
                counter ++;
            }
        }
        return counter;
    }

    // the function calculates how many partial guesses the user made
    public static int howManyPartialGuess(int[] code,int[] guess){
        int counter = 0;
        for (int i = 0; i < guess.length; i++) {
            for (int j = 0; j < guess.length; j++) {
                if (code[i] == guess[j] && i !=j){
                    counter ++;
                }
            }
        }
        return counter;
    }


    // the function creates the secret code
    public static int[] createCode(){
        int[] code = new int[4];
        for (int i = 0; i < code.length; i++) {
            code[i] = -1;
        }
        for (int i = 0; i < code.length; i++) {
            int currentNumber = createRandomInRange(1,7);
            if (!isNumberInArray(code,currentNumber)){
                code[i] = currentNumber;
            }
            else{
                i = i -1;
            }
        }
        System.out.println("");
        return code;

    }

    // the function generate random number within given range
    public static int createRandomInRange(int min, int max) {

        return (int) ((Math.random() * (max - min)) + min);
    }

    // the function checks if number is in array
    public static boolean isNumberInArray(int[] arr, int number){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number)
                return true;
        }
        return false;
    }
}

