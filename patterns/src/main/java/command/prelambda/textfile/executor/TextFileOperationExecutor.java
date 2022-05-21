package command.prelambda.textfile.executor;

import command.prelambda.textfile.operation.TextFileOperation;

import java.util.ArrayList;
import java.util.List;

public class TextFileOperationExecutor {
    final List<TextFileOperation> textFileOperations = new ArrayList<>();

    public String executeOperation(TextFileOperation textFileOperation) {
        textFileOperations.add(textFileOperation);
        return textFileOperation.execute();
    }

}