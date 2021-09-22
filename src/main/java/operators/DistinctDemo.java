package operators;

import io.reactivex.Observable;

public class DistinctDemo {

    public static void main(String[] args) {
//        distinctOperator();
//        distinctWithKeySelector();
//        distinctUntilChangedOperator();
        distinctUntilChangedWithKeySelector();
    }

    private static void distinctOperator(){
        Observable.just(1, 1, 2, 2, 3, 3, 4, 5, 1, 2)
                .distinct()
                .subscribe(System.out::println);
    }

    private static void distinctWithKeySelector(){
//        Observable.just("foo", "fool", "super", "foss", "foil")
//                .distinct(item -> item.length())
//                .subscribe(System.out::println);
        Observable.just("foo", "fool", "super", "foss", "foil")
                .distinct(String::length)
                .subscribe(System.out::println);
    }

    private static void distinctUntilChangedOperator(){
        // will remove consecutive duplicates
        // If same as previous, then skip
        Observable.just(1, 1, 2, 2, 3, 3, 4, 5, 1, 2)
                .distinctUntilChanged()
                .subscribe(System.out::println);
    }

    private static void distinctUntilChangedWithKeySelector(){
        Observable.just("foo", "fool", "super", "foss", "foil")
                .distinctUntilChanged(String::length)
                .subscribe(System.out::println);
    }

}
