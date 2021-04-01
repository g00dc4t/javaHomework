import java.util.Date;

public class User {

    private Integer id;

    private double regDate;

    private static int userId = 1;

    public User() {
        this.id = userId;
        userId++;
        regDate = new Date().getTime();
    }

    public Integer getId() {
        return id;
    }

    public double getRegDate() {
        return regDate;
    }

}
