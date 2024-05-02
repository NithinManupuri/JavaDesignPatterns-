package DesignPatterns;

public class PrototypeDesignPattern {
    public static void main(String[]  args) {
        Shape shape=new Shape();
        try {
            Shape clone = (Shape)shape.clone();
            System.out.println(clone.hashCode());
            System.out.println(clone.getName());
            Shape c=(Shape)shape.clone();
            System.out.println(c.getName());
            System.out.println(c.hashCode());
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
   }
}
class  Shape implements Cloneable {

    public String name;
    public String getName(){
        return "nithin";
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
     }
}