package lol;

public class son extends lol {

    public son(int age){
        this.age = age;
    }
    @Override
    void carrer(String name) {
        System.out.println("I Choose " + name);
    }

    @Override
    void partner(String name) {
        System.out.println("My partner name is " + name + " and age is " + age);
    }
}
