package patterns.command.lambda.textfile.executor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import patterns.command.lambda.textfile.executor.base.TextFile;


class TextFileOperationExecutorTest {
    @Test
    public void shouldExecuteFileOperationsLambda() {
        TextFileOperationExecutor executor = new TextFileOperationExecutor();
        Assertions.assertEquals("Opening file file1", executor.executeOperation(()-> "Opening file file1" ));
        Assertions.assertEquals("Saving file file1", executor.executeOperation(()-> "Saving file file1" ));
    }

    @Test
    public void shouldExecuteFileOperationsMethodRef() {
        final TextFile file1 = new TextFile("file1");
        TextFileOperationExecutor executor = new TextFileOperationExecutor();
        Assertions.assertEquals("Opening file file1", executor.executeOperation(file1::open));
        Assertions.assertEquals("Saving file file1", executor.executeOperation(file1::save ));
    }
}