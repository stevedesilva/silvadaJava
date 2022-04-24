package lambda.predicate.executor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.concurrent.*;

class MyExecutorTest {

    @Test
    void executeEmpty() {
        // given
        MyExecutor<String> executor = new MyExecutor<>();
        // when
        final Set<String> result = executor.execute();
        // then
        Assertions.assertEquals(0,result.size());
    }

    @Test
    void execute() {
        // given
        MyExecutor<String> executor = new MyExecutor<>();
        executor.addData("Test1","Test2","Test3", "Alpha1","Beta2","Gamma3","Alpha11");
        executor.addPredicate((t) -> t.startsWith("Test"), (t)-> t.endsWith("1"));
        // when
        final Set<String> result = executor.execute();
        // then
        Assertions.assertEquals(5,result.size());
        Assertions.assertTrue(result.containsAll(Set.of("Test1","Test2","Test3","Alpha1","Alpha11")));
    }

    @Disabled
    @Test
    void executeConcurrently() throws InterruptedException, ExecutionException {
        // given
        final MyExecutor<String> executor = new MyExecutor<>();

        Callable<Set<String>> job1 = () -> {
            executor.addData("Test1","Test2","Test3", "Alpha1","Beta2","Gamma3","Alpha11");
            executor.addPredicate((t) -> t.startsWith("Test"), (t)-> t.endsWith("1"));
            Thread.sleep(1000);
            // when
            final Set<String> result = executor.execute();
            return result;
        };


        Callable<Set<String>> job2 = () -> {
            executor.addData("Test21","Test22","Test23", "Alpha11","Beta2","Gamma3");
            executor.addPredicate((t) -> t.startsWith("Test"), (t)-> t.endsWith("1"));

            // when
            final Set<String> result = executor.execute();
            return result;
        };

        final ExecutorService executorService = Executors.newFixedThreadPool(2);
        final Future<Set<String>> job1Result = executorService.submit(job1);
        final Future<Set<String>> job2Result = executorService.submit(job2);

        final Set<String> r1 = job1Result.get();
        Assertions.assertEquals(5,r1.size());
        Assertions.assertTrue(r1.containsAll(Set.of("Test1","Test2","Test3","Alpha1","Alpha11")));

        final Set<String> r2 = job2Result.get();
        Assertions.assertEquals(4,r2.size());
        Assertions.assertTrue(r2.containsAll(Set.of("Alpha11","Beta2","Gamma3","Test23")));
    }

    @Test
    void executeMultipleExecution() {
        MyExecutor<String> executor = new MyExecutor<>();
        // given clean executor
        Assertions.assertEquals(0,executor.getJobs().size());
        Assertions.assertEquals(0,executor.getPredicates().size());


        executor.addData("Test1","Test2","Test3", "Alpha1","Beta2","Gamma3","Alpha11");
        executor.addPredicate((t) -> t.startsWith("Test"), (t)-> t.endsWith("1"));
        // when
        final Set<String> result = executor.execute();
        // then
        Assertions.assertEquals(5,result.size());
        Assertions.assertTrue(result.containsAll(Set.of("Test1","Test2","Test3","Alpha1","Alpha11")));

        // given clean executor
        Assertions.assertEquals(0,executor.getJobs().size());
        Assertions.assertEquals(0,executor.getPredicates().size());

        executor.addData("Test21","Test22","Test23", "Alpha11","Beta2","Gamma3");
        executor.addPredicate((t) -> !t.startsWith("Test"), (t)-> t.endsWith("3"));

        // when
        final Set<String> result2 = executor.execute();
        // then
        Assertions.assertEquals(4,result2.size());
        Assertions.assertTrue(result2.containsAll(Set.of("Alpha11","Beta2","Gamma3","Test23")));

    }



}