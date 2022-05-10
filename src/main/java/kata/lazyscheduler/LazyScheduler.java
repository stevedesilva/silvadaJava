package kata.lazyscheduler;

import java.util.ArrayList;
import java.util.List;

public class LazyScheduler<T> implements Scheduler<T> {
    List<T> list = new ArrayList<>();
    @Override
    public void Add(Work work, T... args) {
        System.out.println("Working...");
    }

}
