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

    public void setId(Integer id) {
        this.id = id;
    }

    public double getRegDate() {
        return regDate;
    }

    public void setRegDate(double regDate) {
        this.regDate = regDate;
    }
}
