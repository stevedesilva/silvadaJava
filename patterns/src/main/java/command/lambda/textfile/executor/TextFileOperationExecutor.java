package command.lambda.textfile.executor;

import java.util.ArrayList;
import java.util.List;

public class TextFileOperationExecutor {
    final List<TextFileOperation> textFileOperations = new ArrayList<>();

    public String executeOperation(TextFileOperation textFileOperation) {
        textFileOperations.add(textFileOperation);
        return textFileOperation.execute();
    }

}