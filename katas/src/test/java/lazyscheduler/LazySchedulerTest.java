package lazyscheduler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LazySchedulerTest {
    @Test
    public void shouldCreateLazyScheduler(){
        Scheduler<Integer> scheduler = new LazyScheduler<>();
        Assertions.assertNotNull(scheduler);
    }
}