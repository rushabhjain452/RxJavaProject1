package operators;

import io.reactivex.Observable;

public class FlatMapDemo {

    public static void main(String[] args) {
//        exFlatMap();
        exFlatMapBiFunction();
    }

    public static void exFlatMap(){
        Observable<String> observable = Observable.just("foo", "bar", "jan");
//        observable
//                .flatMap((string) -> Observable.empty())
//                .subscribe(System.out::println);
        // Get data and return Observable
//        observable
//                .flatMap((string) -> Observable.just(string))
//                .subscribe(System.out::println);
        observable
                .flatMap((string) -> {
                    if(string.equals("bar")) return Observable.empty();
                    return Observable.fromArray(string.split(""));
                })
                .subscribe(System.out::println);
    }

    public static void exFlatMapBiFunction(){
        Observable<String> observable = Observable.just("foo", "bar", "jan");
        observable
                .flatMap(string -> Observable.fromArray(string.split("")),
                        (actual, second) -> actual + " " + second)
                .subscribe(System.out::println);
//        observable
//                .flatMap(string -> Observable.just("oof", "rab", "maj"),
//                        (actual, second) -> actual + " " + second)
//                .subscribe(System.out::println);
    }

}
