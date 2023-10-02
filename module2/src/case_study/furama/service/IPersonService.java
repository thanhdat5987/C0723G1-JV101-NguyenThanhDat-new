package case_study.furama.service;

public interface IPersonService<E> extends IService<E> {
    void editPerson(int index, E person);
    void deletePerson(int index);
    E getPerson(int index);
}
