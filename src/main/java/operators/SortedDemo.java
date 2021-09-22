package operators;

import io.reactivex.Observable;

import java.util.Comparator;

public class SortedDemo {

    public static void main(String[] args) {
//        useSorted();
//        useSortedWithOwnComparator();
        useSortedOnNonComparator();
    }

    private static void useSorted(){
        Observable.just(3, 5, 2, 4, 1)
                .sorted()
                .subscribe(System.out::println);
    }

    private static void useSortedWithOwnComparator(){
        Observable.just(3, 5, 2, 4, 1)
                .sorted(Comparator.reverseOrder())
                .subscribe(System.out::println);
    }

    private static void useSortedOnNonComparator(){
        Observable.just("foo", "john", "bar", "ab")
                .sorted((first, second) -> Integer.compare(first.length(), second.length()))
                .subscribe(System.out::println);
    }

}
