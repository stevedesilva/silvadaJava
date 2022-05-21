package command.prelambda.textfile.operation;


import command.prelambda.textfile.base.TextFile;

public class OpenTextFileOperation implements TextFileOperation {

    private TextFile textFile;

    public OpenTextFileOperation(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public String execute() {
        return textFile.open();
    }
}
