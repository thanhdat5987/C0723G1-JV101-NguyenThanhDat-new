package case_study.furama.service;

public interface IPersonService<E> extends IService<E> {
    void editPerson(String employeeId);
    void deletePeron(String employeeId);
    E getPerson(int id);
}
