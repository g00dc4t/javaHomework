public class Main
{
    public static int sum;

    public static void main(String[] args)
    {
        Container container = new Container();
        container.count += 7843;

        System.out.println(sumDigits(111));
    }

    public static Integer sumDigits(Integer num)
    {
        for (int i = 0; i <= num.toString().length() - 1; i++) {
            Integer.parseInt(String.valueOf(num.toString().charAt(i)));
            sum = sum + Integer.parseInt(String.valueOf((num.toString().charAt(i))));
        }
        return sum;
    }
}
