package commonsense.queue;

public interface PrinterFunc<T> {
    void run();
    int size();
    void queuePrintJob(T document);
}
