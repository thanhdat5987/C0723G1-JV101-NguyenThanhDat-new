package ss_19.bai_tap.validate_class_name;

import java.util.Scanner;

public class ClassNameExampleTest {
    public static void main(String[] args) {
        ClassNameExample classNameExample = new ClassNameExample();
        System.out.println("Enter a class name: ");
        Scanner scanner = new Scanner(System.in);
        String className = scanner.nextLine();
        System.out.println(classNameExample.validate(className));
    }
}
