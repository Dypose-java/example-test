package org.example.test;

public class Main {
    LastMain getNumMain(){
        System.out.println("52");
        return new LastMain();
    }
}
class LastMain{
    void getNAmeLast(){
        System.out.println("53");
    }
}
class run{
    public static void main(String[] args) {
        new Main().getNumMain().getNAmeLast();
    }
}