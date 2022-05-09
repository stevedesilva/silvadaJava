package patterns.command.lambda.generic.executor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class OperationExecutorTest {
    @Test
    public void shouldExecuteFileOperationsLambda() {
        OperationExecutor executor = new OperationExecutor();
        Assertions.assertEquals("Opening file file1", executor.executeOperation(() -> "Opening file file1"));
        Assertions.assertEquals("Saving file file1", executor.executeOperation(() -> "Saving file file1"));
        Assertions.assertEquals(1, executor.executeOperation(() -> 1));
        Assertions.assertEquals(19.0, executor.executeOperation(() -> 19.0));
        Assertions.assertEquals(true, executor.executeOperation(() -> 11 == 11));

        final List<GenericOperation> operations = executor.operations;
        Assertions.assertEquals(5, operations.size());
        operations.forEach(o -> System.out.println(o.execute()));

    }
}