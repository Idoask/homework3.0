import java.util.Scanner;

public class ex5 {
    public static void main(String[] args) {
        System.out.println(changeLetters());
    }

    // the function get input from user and change the most frequent char with the second most
    public static String changeLetters(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String maxChar = maxChar(input,false);
        String secondMaxChar = maxChar(input,true);
        String ans = "";
        for (int i = 0; i < input.length(); i++) {
            if (compareStrings(""+input.charAt(i) ,maxChar)) {
                ans = ans + secondMaxChar;
            }
            else {
                if (compareStrings("" + input.charAt(i),secondMaxChar))
                    ans = ans + maxChar;
                else{
                    ans = ans + input.charAt(i);
                }
            }
        }
        return ans;
    }

    // the function out guven string to array
    public static String[] stringToArray(String str){
        String[] ans = new String [str.length()];
        for (int i = 0; i < str.length(); i++) {
            ans[i] = ""+str.charAt(i);
        }
        return ans;
    }

    // the function return the max char or second max char frequent in array
    public static String maxChar (String str, boolean isSecondMax) {
        String[] arr = stringToArray(str);
        int[] counters = new int [0];
        String[] founded = new String[0];
        for (int i = 0; i < arr.length; i++) {
            if (isStringInArr(founded,arr[i])==-1){
                founded = addStrToArray(founded,arr[i]);
                counters = addCounterToArrsay(counters);
            }
            else{
                counters[isStringInArr(founded,arr[i])]++;
            }
        }
        if (isSecondMax)
            return founded[secondMaxIndex(counters)];
        else{
            return founded[maxIndex(counters)];
        }
    }

    //the function return the index of the value that appear the most with an array
    public static int maxIndex(int[] arr){
        int maxIndex = 0;
        int maxValue = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>maxValue){
                maxValue = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    // the function return the index of the second value that appear the second most with an array
    public static int secondMaxIndex(int[] arr){
        int maxIndex = maxIndex(arr);
        int maxValue = arr[maxIndex];
        int secondIndex = 0;
        int secondValue = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<maxValue && arr[i] > secondValue){
                secondIndex = i;
                secondValue = arr[i];
            }
        }
        return secondIndex;
    }

    // the function checks if given string founded in given array
    public static int isStringInArr(String[] arr, String str){
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i].equals(str))
                return i;
        }
        return -1;
    }

    // the function append 1 in the end of an array
    public static int[] addCounterToArrsay(int[] input){
        int[] array=new int[input.length+1];
        if (input.length==0){
            return new int[]{1};
        }
        for (int i = 0; i < input.length ; i++) {
            array[i]=input[i];
        }
        array[array.length-1]=1;
        return array;
    }

    // // the function append given string in the end of an array
    public static String[] addStrToArray(String[] input,String str){
        String[] array=new String[input.length+1];
        if (input.length==0){
            return new String[]{str};
        }
        for (int i = 0; i < input.length ; i++) {
            array[i]=input[i];
        }
        array[array.length-1]=str;
        return array;
    }

    // the function compare between two strings
    public static boolean compareStrings (String str1,String str2){
        if (str1.length()!= str2.length())
            return false;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i))
                return false;
        }
        return true;
    }


}
