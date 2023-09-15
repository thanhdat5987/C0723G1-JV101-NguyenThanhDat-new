package ss_10.bai_tap.list;

import javax.xml.bind.Element;
import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapa() {
        int newSize = elements.length * (elements.length / 2 + 1);
        elements = Arrays.copyOf(elements, newSize);
    }

    public boolean checkIndex(int index) {
        if (index >= size || index < 0) {
            return false;
        } else {
            return true;
        }
    }

    public void add(int index, E element) {
        if (checkIndex(index)) {
            elements[index] = element;
        } else {
            System.out.println("\n" + "index must be greater than 0 and less than size of array");
        }
    }

    public E remove(int index) {
        if (checkIndex(index)) {
            E temp;
            for (int i = index; i < size - 1; i++) {
                temp = (E) elements[i + 1];
                elements[i] = elements[i + 1];
                elements[i + 1] = temp;
            }
            size--;
        }
        return (E) elements;
    }

    public int size() {
        return size;
    }

    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }

    public Boolean add(E element) {
        if (size == elements.length) {
            return false;
        }
        elements[size] = element;
        size++;
        return true;
    }

    public Object clone() {
        Object[] newElements = new Object[size];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        return newElements;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }
}