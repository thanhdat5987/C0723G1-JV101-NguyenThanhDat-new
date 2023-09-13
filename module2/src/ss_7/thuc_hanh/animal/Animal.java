package ss_7.thuc_hanh.animal;

public abstract class Animal implements IEdible {
    public abstract String makeSound();

    @Override
    public String howToEat() {
        return "could be fried";
    }
}
