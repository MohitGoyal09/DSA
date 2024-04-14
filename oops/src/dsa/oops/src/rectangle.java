package dsa.oops.src;

public class rectangle extends shape{
    double width;
    double length;
    void area ( double l , double w ){
        this.width = w;
        this.length = l;
        System.out.println("Area of rectangle is : "+(l*w));
    }
}
