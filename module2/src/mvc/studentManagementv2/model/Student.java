package mvc.studentManagementv2.model;

public class Student {
    private int Id;
    private String name;
    private String dateOfBirth;
    private String className;

    public Student(int id, String name, String dateOfBirth, String className) {
        Id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.className = className;
    }

     Student() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "StudentServiceImpl{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
