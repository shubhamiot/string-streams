import java.util.Arrays;
import java.util.concurrent.*;

public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] arr = {23,2,45,22,14};
        Arrays.parallelSort(arr);
        System.out.println(Arrays.toString(arr
        ));

        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.completedFuture(2);
        Integer i = integerCompletableFuture.get();
        System.out.println(i);

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("shd");
        });
        CompletableFuture<Integer> integerCompletableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("hi");
            return 34;
        });
        System.out.println(integerCompletableFuture1.get());

        CompletableFuture<String> c1 = CompletableFuture.supplyAsync(() -> {
            return "shubham";
        });

        CompletableFuture<String> c2 = CompletableFuture.supplyAsync(() -> {
            return "kumar";
        });

        CompletableFuture<String> c3 = CompletableFuture.supplyAsync(() -> {
            return "gupta";
        });

        CompletableFuture<Void> join= CompletableFuture.allOf(c1, c2, c3);
        join.join();
        System.out.println(c1.get());
        System.out.println(c2.get());
        System.out.println(c3.get());

    }
}
