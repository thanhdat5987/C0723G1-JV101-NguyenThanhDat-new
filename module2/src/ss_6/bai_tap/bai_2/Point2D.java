package ss_6.bai_tap.bai_2;

public class Point2D {
    private float x = 0.0f;
    private float y = 0.0f;

    Point2D() {
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setXY(float x, float y) {
        setX(x);
        setY(y);
    }

    public float[] getXY() {
        return new float[]{getX(), getY()};
    }

    public String toString() {
        return "(" + getX() + "," + getY() + ")";
    }

}
