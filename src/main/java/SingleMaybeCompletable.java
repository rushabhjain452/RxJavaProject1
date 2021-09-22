import io.reactivex.*;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class SingleMaybeCompletable {

    public static void main(String[] args) {
//        createSingle();
//        createMaybe();
        createCompletable();
    }

    public static void createSingle(){
//        public static <T> Single<T> just(final T item)
        Single.just("Hello World").subscribe(System.out::println);
    }

    public static void createMaybe(){
//        public static <T> Maybe<T> just(T item)
//        Maybe.just();
        Maybe.empty().subscribe(new MaybeObserver<Object>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull Object o) {
                System.out.println(o);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("Done");
            }
        });
    }

    public static void createCompletable(){
        Completable.fromSingle(Single.just("Hello World")).subscribe(() -> System.out.println("Done"));
    }

}
