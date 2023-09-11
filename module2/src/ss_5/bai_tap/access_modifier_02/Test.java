package ss_5.bai_tap.access_modifier_02;

import ss_5.bai_tap.access_modifier_01.Circle;

public class Test {
    public static void main(String[] args) {
        // access modifier public can use outside class
        Student student1 = new Student();
        student1.setName("Henry");
        student1.setClasses("C0723G1");
        System.out.println("student1: name: " + student1.getName() + ", class:" + student1.getClasses());
        // access modifier private can not use outside the class
        //  Student student2 = new Student();
        //  student2.setName1("Dat");
        //  student2.setClasses1("C0823G1");
        //  System.out.println("student2: name: " + student2.getName() + ", class:" + student2.getClasses());
    }
}
