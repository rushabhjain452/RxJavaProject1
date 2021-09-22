package operators;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class DoActionOperators2 {

    public static void main(String[] args) {
//        exDoFinally();
        exDoOnDispose();
    }

    private static void exDoFinally(){
        Observable.just(1, 2, 3, 4, 5)
                .doFinally(() -> System.out.println("doFinally: Completed"))
                .subscribe(System.out::println);
    }

    private static void exDoOnDispose(){
//        Disposable disposable = Observable.just(1, 2, 3, 4, 5)
//                .doOnDispose(() -> System.out.println("doOnDispose: Disposed"))
//                .subscribe(System.out::println);
//
//        disposable.dispose();

//        Observable.just(1, 2, 3, 4, 5)
//                .doOnDispose(() -> System.out.println("doOnDispose: Disposed"))
//                .doOnSubscribe(disposable -> disposable.dispose())
//                .subscribe(System.out::println);

        Observable.just(1, 2, 3, 4, 5)
                .doOnSubscribe(disposable -> disposable.dispose())
                .doOnDispose(() -> System.out.println("doOnDispose: Disposed"))
                .subscribe(System.out::println);
    }

}
