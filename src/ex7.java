import java.util.Scanner;

public class ex7 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("please enter valid equation");
        String equation = sc.nextLine();
        int a = findA(equation);
        int b = findB(equation);
        int c = findC(equation);
        if (a==0 || b==0 || c==0 || !isEndWithEqualZero(equation)){
            System.out.println("Invalid Equation");
        }
        else{
            double sol1 = ((-1*b) + (Math.sqrt(b*b-4*a*c)))/ (2*a);
            double sol2 = ((-1*b) - (Math.sqrt(b*b-4*a*c)))/ (2*a);
            System.out.println(sol1);
            System.out.println(sol2);
        }
    }

    //the function checks if the string ends with =0
    public static boolean isEndWithEqualZero(String str){
        if (str.charAt(str.length()-2)!='=' || str.charAt(str.length()-1)!='0'){
            return false;
        }
        return true;
    }
    //the function calculate the value of a from the equation
    public static int findA (String str){
        String a = "";
        int aValue;
        int xIndex = findXIndexInString(str);
        if (xIndex == -1) {
            return 0;
        }
        for (int i = 0; i < xIndex; i++) {
            a = a + str.charAt(i);
        }
        if (a.equals("-"))
            return -1;
        if (a.equals(""))
            return 1;
        try {
            aValue = Integer.parseInt(a);
            return aValue;
        }
        catch (Exception e){
            return 0;
        }

    }

    //the function calculate the value of b from the equation
    public static int findB (String str){
        String b = "";
        int bValue;
        int powIndex = findPowerIndex(str);
        if (powIndex == -1) {
            return 0;
        }
        for (int i = powIndex; i < str.length(); i++) {
            if (str.charAt(i)!='x') {
                b = b + str.charAt(i);
            }
            else{
                i = str.length();
            }
        }
        if (b.equals("-"))
            return -1;
        if (b.equals("+"))
            return 1;
        try {
            bValue = Integer.parseInt(b);
            return bValue;
        }
        catch (Exception e){
            return 0;
        }

    }

    //the function calculate the value of c from the equation
    public static int findC (String str){
        String c = "";
        int cValue;
        for (int i = str.length()-3; i > -1 ; i--) {
            if (str.charAt(i)!='x'){
                c = c + str.charAt(i);
            }else{
                i = -1;
            }
        }
        c = reverseString(c);
        try {
            cValue = Integer.parseInt(c);
            return cValue;
        }
        catch (Exception e){
            return 0;
        }
    }

    //the function return the index of the first 'x' in the equation
    public static int findXIndexInString(String str){
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)=='x')
                return i;
        }
        return -1;
    }
    //the function return the index of the "^2" in the equation
    public static int findPowerIndex(String str){
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)=='^' && i+2 <str.length() && str.charAt(i+1)=='2')
                return i+2;
        }
        return -1;
    }

    // the function reverse given string
    public static String reverseString (String str){
        String ans = "";
        for (int i = str.length()-1; i >-1 ; i--) {
            ans = ans + str.charAt(i);
        }
        return ans;
    }

}
