package jhtaTEST01.sol3;

class Circle{
    public static final double PI=3.141592;
    public static double getArea(double r){
        double area= r*r*PI;
        return area;
    }

    public static void main(String[] args) {
        //Circle circle = new Circle();
        System.out.println(Circle.getArea(5));
    }
}

