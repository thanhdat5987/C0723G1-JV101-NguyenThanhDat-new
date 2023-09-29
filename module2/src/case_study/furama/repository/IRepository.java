package case_study.furama.repository;

import java.util.List;

public interface IRepository <E> {
    void add(E e);
    List<E> display();
}
