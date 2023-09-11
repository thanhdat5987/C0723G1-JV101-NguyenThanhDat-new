package ss_5.bai_tap.access_modifier_02;

import ss_5.bai_tap.access_modifier_01.Circle;

public class Test {
    public static void main(String[] args) {
        // access modifier public can use outside class
        Student student = new Student();
        student.setName("Henry");
        student.setClasses("C0723G1");
        // access modifier private can not use outside the class
        //  Student student1 = new Student();
        //  student1.setName1("Dat");
        //  student1.setClasses1("C0823G1");
    }
}
