package jhtaTEST01.sol4;

public class ChildShape extends Shape {
    private int width;
    private int height;
    public ChildShape(int x, int y, int width, int height) {
        super(x,y);
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width*height;
    }

}
