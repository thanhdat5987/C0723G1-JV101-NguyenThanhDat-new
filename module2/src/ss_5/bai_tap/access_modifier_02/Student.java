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

    public String getName() {
        return name;
    }

    public String getClasses() {
        return classes;
    }



    //access modifier private and public can use inside the class:
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setName("Henry");
        student1.setClasses("C0723G1");
        System.out.println("student1: name: " + student1.getName() + ", class:" + student1.getClasses());
        Student student2 = new Student();
        student2.setName1("Dat");
        student2.setClasses1("C0823G1");
        System.out.println("student2: name: " + student2.getName() + ", class:" + student2.getClasses());
    }
}
