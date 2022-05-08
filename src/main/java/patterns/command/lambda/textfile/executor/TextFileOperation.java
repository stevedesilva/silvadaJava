package patterns.command.lambda.textfile.executor;

@FunctionalInterface
public interface TextFileOperation {
    String execute();
}
