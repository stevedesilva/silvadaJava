package lazyscheduler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WorkTest {
    @Test
    public void shouldCreateWork() {
        Work work = new Work();
        Assertions.assertNotNull(work);
    }
}