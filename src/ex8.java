import java.util.Scanner;

public class ex8 {
    public static void main(String[] args) {
        String[] array = {"java","aaaaa","a1235"};
        subStringOfString("java");
        maxSubstring(array);
    }

    // the function caculate the sucstring with the most appearences
    public static String maxSubstring(String[] input){
        String[] allSubstrings = new String [0];
        String[] stringsFounded = new String [0];
        int[] stringCounter = new int[0];
        for (int i = 0; i < input.length; i++) {
            allSubstrings = concatSubstrings(allSubstrings,subStringOfString(input[i]));
        }
        for (int i = 0; i < allSubstrings.length; i++) {
            if ( isStringInArray(allSubstrings[i],stringsFounded)==-1){
                stringCounter = addCounterToArrsay(stringCounter);
                stringsFounded = addStrToArray(stringsFounded,allSubstrings[i]);
            }
            else{
                stringCounter[isStringInArray(allSubstrings[i],stringsFounded)]++;
            }
        }
        return stringsFounded[returnMaxIndex(stringCounter)];
    }


    // the function combine to strings arrays to one
    public static String[] concatSubstrings(String[] input1, String[] input2){
        String[] combine = new String[input1.length + input2.length];
        for (int i = 0; i < input1.length; i++) {
            combine[i] = input1[i];
        }
        for (int i = 0; i < input2.length; i++) {
            combine[i+input1.length] = input2[i];
        }
        return combine;
    }

    // the function return array of substrings of string
    public static String[] subStringOfString(String input) { //2
        String[] ans = new String[0];
        for (int i = 0; i <= input.length(); i++) {
            for (int j = 0; j <= input.length(); j++) {
                if (j - i >= 2) {
                    ans = addStrToArray(ans, input.substring(i, j));
                }
            }
        }
        return ans;
    }

    // the function return the index of the value with the most appearanes
    public static int returnMaxIndex(int[] input){
        int max = -1;
        int maxIndex = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i]>max) {
                max = input[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }



    // the function split string to array
    public static String[] stringToArray(){ //1
        Scanner sc=new Scanner(System.in);
        String[] array=new String[0];
        String inputStr= sc.nextLine();
        while (inputStr.length()>4){
            array=addStrToArray(array,inputStr);
            inputStr=sc.nextLine();

        }
        return array;
    }

    // the function append 1 to the end of an array
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

    // the function append given string to the end of an array
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

    // the function checks if string is within an array
    public static int isStringInArray(String str, String[] input){
        for (int i = 0; i < input.length; i++) {
            if (compareStrings(input[i],(str)))
                return i;
        }
        return -1;
    }

    // the function compare between two strings
    public static boolean compareStrings(String s1, String s2){
        if (s1.length()!= s2.length())
            return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i)!= s2.charAt(i)){
                return false;
            }
        }
        return true;
    }
}