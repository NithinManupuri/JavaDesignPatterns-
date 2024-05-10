package DesignPatterns;

public class Balls {
    private Integer  diamter;
    private String color;//intrinsic property
    private String shape;//intrinsic

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }public Integer getDiamter() {
        return diamter;
    }

    public Balls(String color,String shape) {
        this.diamter = diamter;
        this.shape=shape;
    }

    public void setDiamter(Integer diamter) {
        this.diamter = diamter;
    }



}
package DesignPatterns;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FlyWeightDesign {

    private static final String s[]={"green","red","orange"};
    private static final Map<String,String> map=Map.ofEntries(
            new AbstractMap.SimpleEntry<String,String>("green","circle"),
            new AbstractMap.SimpleEntry<String,String>("red","triangle"),
            new AbstractMap.SimpleEntry<String,String>("orange","rectangle")
    );
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            String c = getColor();
            String shape = map.get(c);
            Balls ball=(Balls)BallFactory.getBall(c,shape);
            Scanner sc=new Scanner(System.in);
            int diam=sc.nextInt();
            ball.setDiamter(diam);


        }
    }

        public static String getColor() {
            int randomIndex = (int) (Math.random() * s.length);
            return s[randomIndex];
        }




}
class BallFactory{
    public static final Map map=new HashMap<>();

    public  static Balls getBall(String color,String shape){
        StringBuilder str=new StringBuilder();
        str.append(color);
        str.append(shape);
        String cache =str.toString();
            Balls ball=(Balls)map.get(cache);
            if(ball==null){
                ball=new Balls(color,shape);
                map.put(cache,ball);
            }
            return ball;

    }

}