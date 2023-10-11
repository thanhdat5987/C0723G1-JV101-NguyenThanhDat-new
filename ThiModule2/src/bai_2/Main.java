package bai_2;

public class Main {
    public static void main(String[] args) {
        System.out.println(findMaxNumber(9899));
    }

    public static int findMaxNumber(int n) {
        if (n > 999 && n < 10000) {
            return findNumber(n);
        }
        return -1;
    }
    public static int findNumber(int n){
        String stringN = String.valueOf(n);
        String n1Str=String.valueOf(stringN.charAt(0))+String.valueOf(stringN.charAt(1))+String.valueOf(stringN.charAt(2));
        String n2Str=String.valueOf(stringN.charAt(0))+String.valueOf(stringN.charAt(1))+String.valueOf(stringN.charAt(3));
        String n3Str=String.valueOf(stringN.charAt(0))+String.valueOf(stringN.charAt(2))+String.valueOf(stringN.charAt(3));
        String n4Str=String.valueOf(stringN.charAt(1))+String.valueOf(stringN.charAt(2))+String.valueOf(stringN.charAt(3));
        int n1 = Integer.parseInt(n1Str);
        int n2 = Integer.parseInt(n2Str);
        int n3 = Integer.parseInt(n3Str);
        int n4 = Integer.parseInt(n4Str);
        int[] arrNumber = {n1,n2,n3,n4};
        int maxNumber =n1;
        for(int i=0; i<arrNumber.length;i++){
            if(arrNumber[i]>maxNumber){
                maxNumber=arrNumber[i];
            }
        }
        return maxNumber;
    }
}
