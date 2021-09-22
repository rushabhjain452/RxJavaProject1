package operators;

import io.reactivex.Observable;

public class DoActionOperators {

    public static void main(String[] args) {
//        exDoOnSubscribe();
        exDoOnNext();
        exDoOnComplete();
    }

    private static void exDoOnSubscribe(){
        Observable.just(1, 2, 3, 4, 5)
                .doOnSubscribe(disposable -> System.out.println("doOnSubscribe: Subscribed"))
                .subscribe(System.out::println);
    }

    private static void exDoOnNext(){
//        Observable.just(1, 2, 3, 4, 5)
//                .doOnNext(item -> System.out.println("doOnNext: " + item))
//                .subscribe(System.out::println);
        // Try to modify
//        Observable.just(1, 2, 3, 4, 5)
//                .doOnNext(item -> System.out.println("doOnNext: " + ++item))
//                .subscribe(System.out::println);
    }

    private static void exDoOnComplete(){
        Observable.just(1, 2, 3, 4, 5)
                .doOnComplete(() -> System.out.println("doOnComplete: Completed"))
                .subscribe(System.out::println, System.out::println, () -> System.out.println("Completed"));
    }

}
