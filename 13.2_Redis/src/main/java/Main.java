import java.text.SimpleDateFormat;
import java.util.Random;

public class Main {

    private static Random random;

    private static final int COUNT_USERS = 20;

    private static final int SLEEP = 1000;

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public static void main(String[] args) throws InterruptedException {

        RedisStorage redisStorage = new RedisStorage();
        redisStorage.init();

        for (int i = 1; i <= COUNT_USERS; i++) {
            redisStorage.addUser(new User());
        }

        while (true) {
            for (String userId : redisStorage.getSetValues()) {
                showAtMainPage(userId);
                if (paidOrNot() != 0) {
                    String randId = String.valueOf(getRandomUserIdFromUsersCount(COUNT_USERS));
                    servicePaid(randId);
                    showAtMainPage(randId);
                    redisStorage.updateEnterTime(Integer.valueOf(randId));
                    Thread.sleep(SLEEP);
                }
            }
        }
    }

    public static void showAtMainPage(String userId) {
        System.out.println("— На главной странице показываем пользователя " + userId);
    }

    public static void servicePaid(String userId) {
        System.out.println("> Пользователь " + userId + " оплатил услугу ");
    }

    public static int paidOrNot() {
        random = new Random();
        return (random.nextInt(100) < 10) ? 1 : 0;
    }

    public static int getRandomUserIdFromUsersCount(int usersCount) {
        random = new Random();
        return random.nextInt(usersCount - 1) + 1;
    }
}
