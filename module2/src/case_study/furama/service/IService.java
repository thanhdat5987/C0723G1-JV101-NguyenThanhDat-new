package case_study.furama.service;

import java.util.List;

public interface IService<E> {
    void add(E e);
    List<E> display();
}
