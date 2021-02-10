import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Callable<String> task = () -> Thread.currentThread().getName();
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 6; i++) {
            Future result = service.submit(task);
            try {
                System.out.println(result.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        service.shutdown();
    }
}
