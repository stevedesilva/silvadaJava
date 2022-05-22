package function.executor;


import function.decorator.FunctionDecorator;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;

public class MyFunctionExecutor implements Executor {

    private Set jobs;
    private List functions;

    public MyFunctionExecutor() {
        this.jobs = ConcurrentHashMap.newKeySet();
        this.functions = new CopyOnWriteArrayList<>();
    }

    public <T> void addFunctions(Function<T, T>... fns) {
        functions.addAll(Arrays.asList(fns));
    }

    public <T> void addData(T... data) {
        jobs.addAll(Arrays.asList(data));
    }

    public<T> Set<T> execute() {
        Set<T> j = Set.copyOf(jobs);
        List<Function<T, T>> functions = List.copyOf(this.functions);
        jobs.clear();
        this.functions.clear();

        Optional<Set<T>> ts = FunctionDecorator.work(j, functions);

        return ts.orElseGet(() -> Set.of());
    }
}