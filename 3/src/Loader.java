import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;

public class Loader
{
    public static void main(String[] args)
    {
        //3.1
/*
        Cat cat1 = new Cat();

        for(cat1.getWeight(); cat1.getStatus() != "Dead"; cat1.meow())
        {
            System.out.println(cat1.getStatus());
        }
        System.out.println(cat1.getStatus());
*/
/*
        //3.2
        Cat cat1 = new Cat();
        System.out.println(cat1.getWeight());
        cat1.feed(150.0);
        System.out.println(cat1.getWeight());
        cat1.pee();
        cat1.pee();

        System.out.println(cat1.feedAmount());
*/

/*
    Cat cat1 = new Cat();
    Cat cat2 = new Cat();
    Cat cat3 = new Cat();

        System.out.println("Количетво кошек до = " + Cat.getCount());

        for(cat1.getWeight(); cat1.getStatus() != "Dead"; cat1.meow()) {
            System.out.println(cat1.getStatus());
        }

        while(cat1.getStatus() != "Dead") {
            System.out.println(cat1.getStatus());
            cat1.meow();
        }

        for(cat2.getWeight(); cat2.getStatus() != "Exploded"; cat2.feed(5.0)) {
            System.out.println(cat2.getStatus());
        }

        System.out.println("Количетво кошек после = " + Cat.getCount());
        System.out.println("Cat1 is "+cat1.getStatus() + ", weight = "+cat1.getWeight());
        System.out.println("Cat2 is "+cat2.getStatus() + ", weight = "+cat2.getWeight());
        cat1.meow();
        cat2.feed(5.0);
*/
    Cat cat1 = new Cat();
    cat1.setColor(Color.WHITE);
    cat1.setName("Vasya");
    System.out.println(cat1.getColor());
    System.out.println(cat1.getWeight());
    System.out.println(cat1.getOriginWeight());
    System.out.println(cat1.getName());

    Cat copyCat1 = cat1.copyCat();
    System.out.println(copyCat1.getColor());
    System.out.println(copyCat1.getWeight());
    System.out.println(copyCat1.getOriginWeight());
    System.out.println(copyCat1.getName());
    }
}