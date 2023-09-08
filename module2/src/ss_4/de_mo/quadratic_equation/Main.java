package ss_4.de_mo.quadratic_equation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a: ");
        double a = scanner.nextDouble();
        System.out.println("Please enter b: ");
        double b = scanner.nextDouble();
        System.out.println("Please enter c:");
        double c = scanner.nextDouble();
        QuadraticEquation myQua = new QuadraticEquation(a,b,c);
        if(myQua.getDiscriminant()>0){
            System.out.println("root1 = "+myQua.getRoot1()+", root2= "+myQua.getRoot2());
        } else if (myQua.getDiscriminant()==0) {
            System.out.println("root= "+myQua.getRoot1());
        }else {
            System.out.println("no solution");
        }
    }


}
