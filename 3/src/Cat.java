
public class Cat
{
    public static final int COUNT_EYES = 2; //Константа количеств глаз
    public static final double MIN_WEIGHT = 1000;
    public static final double MAX_WEIGHT = 9000;

    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;

    private double feedAmount;  //Переменная для подсчёта количества еды
    private double weightAfterFeed;  //Переменная для подсчёта веса после еды

    private static int count;    //Переменная количества кошек

    private Color color; //Переменная окраса кошки

    private String name; //Имя кошки

    public static boolean live; //Жива или нет

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        count++;
        live = true;

        feedAmount = 0; //Переменная для подсчёта количества еды
        weightAfterFeed = 0; //Переменная для подсчёта веса после еды
    }

    public Cat(double weight)
    {
        this();
        this.weight = weight;
    }

    public Cat copyCat()
    {
        Cat cat = new Cat(getWeight());
        cat.setColor(getColor());
        cat.setName(getName());

        return cat;
    }

    public void setOriginWeight(double originWeight)
    {
        this.originWeight = originWeight;
    }

    public double getOriginWeight()
    {
        return originWeight;
    }

    public void setColor (Color color) //Метод установки цвета кошки
    {
        this.color = color;
    }

    public Color getColor ()  //Метод получения цвета кошки
    {
        return color;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void isLive()
    {
/*
        if(weight > maxWeight || weight < minWeight) {
            live = false;
        }
*/
        if(weight > minWeight && weight < maxWeight) {
            live = true;
        }
        else {
            live = false;
            count--;
        }
    }

    public void meow()
    {
        isLive();
        if(live) {
            weight = weight - 1;
            System.out.println("Meow");
        }
        else {
            System.out.println("Cat is dead");
        }
    }

    public void feed(Double amount)
    {
        isLive();
        if(live) {
            weight = weight + amount;
            weightAfterFeed = weight;   //Переменная для подсчёта веса после еды
            System.out.println("Yam");
        }
        else {
            System.out.println("Cat is dead");
        }
    }


    public void drink(Double amount)
     {
         isLive();
         if (live) {
             weight = weight + amount;
         } else {
                System.out.println("Cat is dead");
         }
     }

    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < minWeight) {
            count--;
            return "Dead";
        }
        else if(weight > maxWeight) {
            count--;
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }

    }

    public Double feedAmount()    //Метод подсёта количества еды
    {
        feedAmount = weightAfterFeed - originWeight;
        return feedAmount;
    }

    public void pee()   //Метод сходить в туалет
    {
        weight = weight - 2;
        System.out.println("Pee");
    }

    public static int getCount()    //Метод подсчёта количества кошек
    {
        return count;
    }
}