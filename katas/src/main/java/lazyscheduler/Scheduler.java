package lazyscheduler;

public interface Scheduler<T> {
    void Add(Work work, T... args);
}
