import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {



    }

    public static int getRandom1() {
        return (ThreadLocalRandom.current().nextInt(100) < 5) ? 1 : 0;
    }

}
