package commonsense.queue;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;


class PrinterFuncTest {

    @Test
    void Test_printer_QueuePrintJob() {
        Printer<String> p = new Printer();
        p.queuePrintJob("task1");
        p.queuePrintJob("task2");
        p.queuePrintJob("task3");
        p.queuePrintJob("task4");
        MatcherAssert.assertThat(p.size(), Matchers.equalTo(4));
    }

    @Test
    void Test_printer_QueuePrintJobViaNew() {
        Printer<String> p = new Printer("task1","task2");
        p.queuePrintJob("task3");
        p.queuePrintJob("task4");
        MatcherAssert.assertThat(p.size(), Matchers.equalTo(4));
    }

    @Test
    void Test_printer_QueueRunJob() {
        Printer<String> p = new Printer("task1","task2");
        p.queuePrintJob("task3");
        p.queuePrintJob("task4");
        MatcherAssert.assertThat(p.size(), Matchers.equalTo(4));
        p.run();
        MatcherAssert.assertThat(p.size(), Matchers.equalTo(0));

    }
}