package operators;

import io.reactivex.Observable;

public class DefaultIfEmptyAndSwitchIfEmpty {

    public static void main(String[] args) {
//        useDefaultIfEmpty();
        useSwitchIfEmpty();
    }

    private static void useDefaultIfEmpty(){
        Observable.just(1,2,3,4,5)
                .filter(item -> item > 10)
                .defaultIfEmpty(100)
                .subscribe(System.out::println);
    }

    private static void useSwitchIfEmpty(){
//        Observable.just(1,2,3,4,5)
//                .filter(item -> item > 10)
//                .switchIfEmpty(Observable.just(6,7,8,9,10))
//                .subscribe(System.out::println);
        Observable.just(1,2,3,4,5,11)
                .filter(item -> item > 10)
                .switchIfEmpty(Observable.just(6,7,8,9,10))
                .subscribe(System.out::println);
    }

}
