package DesignPatterns;

public class SingleDesignPattern {
    private static SingleDesignPattern pattern;

    private SingleDesignPattern(){
    }

    public static SingleDesignPattern getInstance(){
        if(pattern==null){
            pattern=new SingleDesignPattern();
        }
        return pattern;
    }
}
