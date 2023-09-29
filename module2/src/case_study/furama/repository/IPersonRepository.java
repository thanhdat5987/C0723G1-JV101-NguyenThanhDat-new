package case_study.furama.repository;

public interface IPersonRepository<E> extends IRepository<E> {
    void editPerson(String employeeId);
    void deletePeron(String employeeId);
    E getPerson(int id);
}
