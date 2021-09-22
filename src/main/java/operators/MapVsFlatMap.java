package operators;

import io.reactivex.Observable;

// Map cannot increase or decrease the number of elements/emissions, while flatMap() can do that.

// FlatMap callback function must return an Observable
// FlatMap subscribes the observables automatically

public class MapVsFlatMap {

    public static void main(String[] args) {
//        exMap();
//        exFlatMap();
        exMapWithObservable();
    }

    private static void exMap(){
        Observable<String> observable = Observable.just("foo", "bars", "james");
//        observable
//                .map(item -> item.length())
//                .subscribe(System.out::println);
        observable
                .map(item -> item.toUpperCase())
                .subscribe(System.out::println);
    }

    private static void exFlatMap(){
        Observable<String> observable = Observable.just("foo", "bar", "jam");
        observable
                .flatMap(item -> Observable.fromArray(item.split("")))
                .subscribe(System.out::println);
    }

    private static void exMapWithObservable(){
        Observable<String> observable = Observable.just("foo", "bar", "jam");
//        observable
//                .map(item -> item.length())
//                .subscribe(System.out::println);
        observable
                .map(item -> Observable.fromArray(item.split("")))
                .subscribe(System.out::println);
    }

}
