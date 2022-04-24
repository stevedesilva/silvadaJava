package lambda.predicate.executor;

import lambda.predicate.builtin.MyPredicateFilters;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;

public class MyExecutor<T> implements Executor<T>{
    private MyPredicateFilters<T> filters;
    private Set<T> jobs;
    private Set<Predicate<T>> predicates;

    public Set<Predicate<T>> getPredicates() {
        return predicates;
    }

    public Set<T> getJobs() {
        return jobs;
    }

    public MyExecutor() {
        this.filters = new MyPredicateFilters<>();
        this.jobs = ConcurrentHashMap.newKeySet();
        this.predicates = ConcurrentHashMap.newKeySet();
    }

    @Override
    public Set<T> execute() {
        Set<T> j = Set.copyOf(jobs);
        Set<Predicate<T>> p = Set.copyOf(predicates);
        jobs.clear();
        predicates.clear();

        final Optional<Set<T>> ts = filters.filterSet(j, p);
        return ts.orElseGet(() -> Set.of());
    }

    @Override
    public void addData(T ...t) {
        jobs.addAll(Arrays.asList(t));
    }

    @Override
    public void addPredicate(Predicate<T> ...t) {
        predicates.addAll(Arrays.asList(t));
    }


}
