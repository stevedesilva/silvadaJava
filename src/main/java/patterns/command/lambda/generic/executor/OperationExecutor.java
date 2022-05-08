package patterns.command.lambda.generic.executor;

import java.util.ArrayList;
import java.util.List;

public class OperationExecutor {
    final List<GenericOperation> operations = new ArrayList<>();

    public <R> R executeOperation(GenericOperation<R> operation) {
        operations.add(operation);
        return operation.execute();
    }

}