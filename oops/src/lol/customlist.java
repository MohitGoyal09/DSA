package lol;

import java.util.ArrayList;

public class customlist <T> {

    private T[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0;

    public customlist(){
//        this.data = new T[DEFAULT_SIZE];
    }

    public void add(T num){
        if (isfull()) resize();
        data[size++] = num;
    }

    private boolean isfull() {
        return size == data.length;
    }

    private void resize(){
//        T[] temp = new T[data.length * 2];
//        for (int i = 0; i < data.length; i++) {
//            temp[i] = data[i];
//        }
//        data = temp;
    }

    private T remove(){
        T removed = data[--size];
        return removed;
    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
    }
}
