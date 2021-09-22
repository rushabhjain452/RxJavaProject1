package operators.error_handling;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;

import java.io.IOException;

public class ErrorHandling1 {

    public static void main(String[] args) {
//        exDoOnError();
//        exOnErrorResumeNext();
//        exOnErrorReturn();
        exOnErrorReturnItem();
    }

    private static void exDoOnError(){
        // public final Observable<T> doOnError(Consumer<? super Throwable> onError)
        Observable.error(new Exception("This is an example error"))
                .doOnError(error -> System.out.println("Error: " + error.getMessage()))
                .subscribe(System.out::println,
                        error -> System.out.println("Subscribed Error: " + error.getMessage()),
                        () -> System.out.println("completed"));
    }

    private static void exOnErrorResumeNext(){
//        public final Observable<T> onErrorResumeNext(final ObservableSource<? extends T> next)
        Observable.error(new Exception("This is an example error"))
                .onErrorResumeNext(Observable.just(1, 2, 3, 4, 5))
                .subscribe(System.out::println,
                        error -> System.out.println("Subscribed Error: " + error.getMessage()),
                        () -> System.out.println("completed"));
    }

    private static void exOnErrorReturn(){
        Observable.error(new IOException("This is an example error"))
                .onErrorReturn(error -> {
                    if(error instanceof IOException) return 0;
//                    else return 1;
                    else throw new Exception("This is an exception");
                })
                .subscribe(System.out::println,
                        error -> System.out.println("Subscribed Error: " + error.getMessage()),
                        () -> System.out.println("completed"));
    }

    private static void exOnErrorReturnItem(){
        Observable.error(new Exception("This is an example error"))
                .onErrorReturnItem("Hello World")
                .subscribe(System.out::println,
                        error -> System.out.println("Subscribed Error: " + error.getMessage()),
                        () -> System.out.println("completed"));
    }

}
