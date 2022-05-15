package patterns.command.prelambda.textfile.operation;

import patterns.command.prelambda.textfile.base.TextFile;

public class SaveTextFileOperation implements TextFileOperation {

    private TextFile textFile;

    public SaveTextFileOperation(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public String execute() {
        return textFile.save();
    }
}