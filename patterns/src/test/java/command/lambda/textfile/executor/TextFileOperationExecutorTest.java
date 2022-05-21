package command.lambda.textfile.executor;

import command.lambda.textfile.executor.base.TextFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


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