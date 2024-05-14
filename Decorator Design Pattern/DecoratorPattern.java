package DesignPatterns;

public interface  Animal{
    void makeSound();
}

class Meow implements Animal {

    private Animal animal;

    public Meow(Animal animal) {
        this.animal = animal;
    }

    public void makeSound() {
        animal.makeSound();
        System.out.print("meow .....");
    }
}

class Bark implements Animal {
    private Animal animal;

    public Bark(Animal animal) {
        this.animal = animal;
    }

    @Override
    public void makeSound() {

        animal.makeSound();
        System.out.print("Bark....");

    }
}

    class Dog implements Animal{


        @Override
        public void makeSound() {

            System.out.print("Uuuuuu...");
        }

}
package DesignPatterns;


public class DecoratorDesign {

    public static void main(String[] args){
         Dog dog=new Dog();
        Animal animal=new Bark(dog);

          animal.makeSound();

    }


}





