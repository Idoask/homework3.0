public class ex2 {
    public static void main(String[] args) {
        int[] array=new int[]{12,90,4,78,95};
        int[] array2=new int[]{50,41,13,40,22};
        whatAreTheMostBrothers(array,array2);

    }

    // the function return the index of the element with the most brothers from the other array
    public static int whatAreTheMostBrothers(int[] arr1,int[] arr2){
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i <arr1.length ; i++) {
            if (howManyBrothers(arr2,arr1[i])>max){
                max = howManyBrothers(arr2,arr1[i]);
                maxIndex = i;
            }
        }
        System.out.println(maxIndex);
        return maxIndex;
    }

    // the function checks how many brothers given value has in array
    public static int howManyBrothers(int[] arr1,int number){
        int conter=0;
        for (int i = 0; i < arr1.length; i++) {
            if (areBrothers(number,arr1[i])){
                conter=conter+1;
            }
        }
        return conter;
    }

    // the function check if two numbers are brothers
    public static boolean areBrothers(int number1,int number2){
        if (sumOfNum(number1)==sumOfNum(number2)){
            return true;
        }
        return false;
    }

    // the function calculate the sum of numbers of given number
    public static int sumOfNum (int number){
        int sum=0;
        while (number!=0){
            sum=sum+number%10;
            number=number/10;
        }
        return sum;
    }
}

