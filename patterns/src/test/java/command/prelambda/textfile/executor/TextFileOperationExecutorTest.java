package command.prelambda.textfile.executor;

import command.prelambda.textfile.base.TextFile;
import command.prelambda.textfile.operation.OpenTextFileOperation;
import command.prelambda.textfile.operation.SaveTextFileOperation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TextFileOperationExecutorTest {

    @Test
    public void shouldExecuteFileOperations() {
        TextFileOperationExecutor executor = new TextFileOperationExecutor();
        Assertions.assertEquals("Opening file file1", executor.executeOperation(new OpenTextFileOperation(new TextFile("file1"))));
        Assertions.assertEquals("Saving file file2", executor.executeOperation(new SaveTextFileOperation(new TextFile("file2"))));
    }
}