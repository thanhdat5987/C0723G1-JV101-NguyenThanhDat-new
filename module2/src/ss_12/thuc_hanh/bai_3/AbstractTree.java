package ss_12.thuc_hanh.bai_3;

public class AbstractTree<E> implements Tree<E> {

    @Override
    public boolean insert(E e) {
        return false;
    }

    @Override
    public void inorder() {

    }

    @Override
    public int getSize() {
        return 0;
    }
}
