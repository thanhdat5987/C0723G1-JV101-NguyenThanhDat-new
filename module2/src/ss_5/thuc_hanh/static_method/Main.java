package ss_5.thuc_hanh.static_method;

public class Main {
    public static void main(String[] args) {
        Student.change();
        Student s1 = new Student(111, "Khanh");
        Student s2 = new Student(112, "Nam");
        Student s3 = new Student(113, "Hoang");
        s1.display();
        s2.display();
        s3.display();
    }
}
