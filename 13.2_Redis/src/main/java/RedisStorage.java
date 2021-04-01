import org.redisson.Redisson;
import org.redisson.api.RKeys;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.Date;

public class RedisStorage {

    private RedissonClient redissonClient;

    private RKeys rKeys;

    private RScoredSortedSet<String> users;

    private final static String KEY = "USERS";

    public void init() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        redissonClient = Redisson.create(config);
        rKeys = redissonClient.getKeys();
        users = redissonClient.getScoredSortedSet(KEY);
        rKeys.delete(KEY);
    }

    public void shutdown() {
        redissonClient.shutdown();
    }

    public RScoredSortedSet<String> getSetValues() {
        RScoredSortedSet<String> valuesSet = redissonClient.getScoredSortedSet(KEY);
        return valuesSet;
    }

    public void addUser(User user) {
        users.add(user.getRegDate(), String.valueOf(user.getId()));
    }

    public void updateEnterTime(int userId) {
        users.add(new Date().getTime(), String.valueOf(userId));
    }
}
