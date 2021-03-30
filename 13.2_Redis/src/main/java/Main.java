import java.text.SimpleDateFormat;
import java.util.Random;

public class Main {

    private static User user;

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

        redisStorage.listKeys();

        redisStorage.shutdown();

//        for (User client : storage.getUserStorage().values()) {
//            int clientId = getRandomTenthUser(storage.getUserStorage().size());
//            if(clientId == 0) {
//            } else {
//                System.out.println("> Пользователь " + storage.getUserStorage().get(clientId).getId()
//                        + " оплатил услугу");
//                System.out.println("- На главной странице показываем пользователя "
//                        + storage.getUserStorage().get(clientId).getId());
//                Thread.sleep(SLEEP);
//            }
//            System.out.println("- На главной странице показываем пользователя " + client.getId());
//        }
    }

    public static int getRandomTenthUser(int countUsers) {
        random = new Random();
        int everyTenthClient = (random.nextInt(100) < 10) ? 1 : 0;
        int randClient = 0;
        if (everyTenthClient == 1) {
            randClient = getRandomUserIdFromUsersCount(countUsers);
        }
        return randClient;
    }

    public static int getRandomUserIdFromUsersCount(int usersCount) {
        random = new Random();
        return random.nextInt(usersCount - 1) + 1;
    }
}
