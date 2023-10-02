package case_study.furama.repository;

import case_study.furama.model.Employee;
import case_study.furama.model.Person;

public interface IPersonRepository<E> extends IRepository<E> {
    void editPerson(int index, E person);
    void deletePerson(int index);
    E getPerson(int index);
}
