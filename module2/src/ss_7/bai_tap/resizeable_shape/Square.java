package ss_7.bai_tap.resizeable_shape;

public class Square extends Shape implements Resizeable {
    private double edge = 1.0;

    public Square() {
    }

    public Square(double edge) {
        this.edge = edge;
    }

    public Square(double edge, String color, boolean filled) {
        super(color, filled);
        this.edge = edge;
    }

    public double getEdge() {
        return edge;
    }

    public void setEdge(double edge) {
        this.edge = edge;
    }

    public double getArea() {
        return this.edge * this.edge;
    }

    public double getPerimeter() {
        return 4 * this.edge;
    }

    @Override
    public String toString() {
        return "A Rectangle with edge="
                + getEdge()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        edge = edge * (1 + percent/100);
    }
}
