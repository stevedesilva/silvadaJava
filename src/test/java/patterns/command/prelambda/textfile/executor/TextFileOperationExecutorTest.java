package patterns.command.prelambda.textfile.executor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import patterns.command.prelambda.textfile.base.TextFile;
import patterns.command.prelambda.textfile.operation.*;

class TextFileOperationExecutorTest {

    @Test
    public void shouldExecuteFileOperations() {
        TextFileOperationExecutor executor = new TextFileOperationExecutor();
        Assertions.assertEquals("Opening file file1", executor.executeOperation(new OpenTextFileOperation(new TextFile("file1"))));
        Assertions.assertEquals("Saving file file2", executor.executeOperation(new SaveTextFileOperation(new TextFile("file2"))));
    }
}