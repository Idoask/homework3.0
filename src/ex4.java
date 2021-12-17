public class ex4 {
    public static void main(String[] args) {
        int[] array={15,19,17,16,18,14};
        System.out.println(areAllTheNumbersBetweenMaxAndMiniAreInTheArray(array)); // this function answers both of the questions.
    }

    //the function checks if all number in range of min-max founded in the array
    public static boolean areAllTheNumbersBetweenMaxAndMiniAreInTheArray(int[] arr1){
        if (ifTherAreMoreThenOneOfTheSameValue(arr1)){
            return false;
        }
        int miniValue= minivalue(arr1);
        int maxvalue=maxvalue(arr1);
        for (int i =miniValue ; i <=maxvalue; i++) {
            if (ifValueIsInArrayAreNot(arr1,i)==false){
                return false;
            }
        }
        return true;
    }

    // the function checks if given value is in the array or not
    public static boolean ifValueIsInArrayAreNot(int[] arr1,int number){
        for (int i = 0; i <arr1.length; i++) {
            if (arr1[i]==number){
                return true;
            }
        }
        return false;
    }

    // the function return minimum value in array
    public static int minivalue(int[] arr1){
        int mini= 2147483647;
        for (int i = 0; i < arr1.length ; i++) {
            if (mini>arr1[i]){
                mini=arr1[i];
            }
        }
        return mini;
    }

    // the function return maximum value in array
    public static int maxvalue(int[] arr1) {
        int max=-2147483648;
        for (int i = 0; i <arr1.length ; i++) {
            if (max<arr1[i]){
                max=arr1[i];
            }
        }
        return max;
    }

    // the function checks if there are duplications within the array
    public static boolean ifTherAreMoreThenOneOfTheSameValue(int[] arr1){
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[i]==arr1[j] && i!=j){
                    return true;
                }
            }
        }
        return false;
    }
}
