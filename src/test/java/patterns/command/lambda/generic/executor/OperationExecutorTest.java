package patterns.command.lambda.generic.executor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class OperationExecutorTest {
    @Test
    public void shouldExecuteFileOperationsLambda() {
        OperationExecutor executor = new OperationExecutor();
        Assertions.assertEquals("Opening file file1", executor.executeOperation(()-> "Opening file file1" ));
        Assertions.assertEquals("Saving file file1", executor.executeOperation(()-> "Saving file file1" ));
        Assertions.assertEquals(1, executor.executeOperation(()-> 1 ));
    }

}