package executor;

import function.executor.Executor;
import function.executor.MyFunctionExecutor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.function.Function;

class MyFunctionExecutorTest {

    @Test
    void executeEmpty() {
        // given
        Executor executor = new MyFunctionExecutor();
        // when
        final Set<String> result = executor.execute();
        // then
        Assertions.assertEquals(0,result.size());
    }

    @Test
    void executeFunctions() {
        // given
        Executor executor = new MyFunctionExecutor();
        Function<String,String> testFn = (s) -> s.toLowerCase();
        Function<String,String> testFn2 = (s) -> String.format("Processed %s",s);
        executor.addData("Test1","Test2","Test3", "Alpha1","Beta2","Gamma3","Alpha11");
        executor.addFunctions(testFn, testFn2);
        // when
        final Set<String> result = executor.execute();
        // then
        Assertions.assertEquals(7,result.size());
        Assertions.assertTrue(result.containsAll(Set.of("Processed test1","Processed test2","Processed test3","Processed alpha1","Processed alpha11")));
    }
}