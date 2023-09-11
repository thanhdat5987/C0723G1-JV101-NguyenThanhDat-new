package ss_5.bai_tap.access_modifier_02;

public class Student {
    private String name = "John";
    private String classes = "CO2";

    Student() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    private void setName1(String name) {
        this.name = name;
    }

    private void setClasses1(String classes) {
        this.classes = classes;
    }

    //access modifier private and public can use inside the class:
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Henry");
        student.setClasses("C0723G1");
        Student student1 = new Student();
        student1.setName1("Dat");
        student1.setClasses1("C0823G1");
    }
}
