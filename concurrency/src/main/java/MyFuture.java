import java.time.LocalDateTime;
import java.util.concurrent.*;

public class MyFuture {
    public Callable<Integer> createWork(){
        return () -> {
            return Integer.valueOf(1);
        };
    }

    public static void main(String[] args) {
        MyFuture myFuture = new MyFuture();

//        new Thread(new MyLogger()).start();
//        new Thread(() -> System.out.println(Integer.valueOf(2))).start();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        final Callable<Integer> work = myFuture.createWork();
        final Future<Integer> submit = executorService.submit(work);
        try {
            System.out.println("" + submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();



    }



    private static class MyLogger implements Runnable {
        @Override
        public void run() {
            System.out.println(LocalDateTime.now());
        }
    }
}
