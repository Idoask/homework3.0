public class ex3 {
    public static void main(String[] args) {

        divideToThePartsThePrimeNumbers(12600);
    }

    // the function returns prime numbers array that their multiplication equal to given number
    public static int[] divideToThePartsThePrimeNumbers (int number){
        int[] array=new int[0];
        int index=0;
        for (int i = 2; i <= number; i++) {
            if (primeNum(i)==true && number%i==0){
                array = addElementToArray(array,i);
                number=number/i;
                i=1;
            }
        }
        return array;
    }

    // the function add given element to given array
    public static int[] addElementToArray(int[] arr1,int number){
        int[] array=new int[arr1.length+1];
        for (int i = 0; i < arr1.length ; i++) {
            array[i]=arr1[i];
        }
        array[array.length-1]=number;
        return array;
    }

    // the function checks if a number is a prime number
    public static boolean primeNum(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
