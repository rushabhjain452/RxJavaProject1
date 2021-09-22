import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

import java.util.Arrays;
import java.util.List;

public class CreateObservableDemo {

    public static void main(String[] args) {
//        createObservableWithJust();
//        createObservableFromIterable();
        createObservableUsingCreate();
    }

    public static void createObservableWithJust(){
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);

        observable.subscribe(item -> System.out.println(item));
    }

    public static void createObservableFromIterable(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Observable<Integer> observable = Observable.fromIterable(list);

        observable.subscribe(item -> System.out.println(item));
    }

    public static void createObservableUsingCreate() {
//        public static <T> Observable<T> create(ObservableOnSubscribe<T> source)
        Observable<Integer> observable = Observable.create(emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onNext(4);
            emitter.onNext(5);
            emitter.onNext(null);

            emitter.onComplete();
        });

//        public final Disposable subscribe(Consumer<? super T> onNext, Consumer<? super Throwable> onError, Action onComplete)
        observable.subscribe(item -> System.out.println(item),
                error -> System.out.println("There was error : " + error.getLocalizedMessage()),
                () -> System.out.println("Completed"));
    }

}
