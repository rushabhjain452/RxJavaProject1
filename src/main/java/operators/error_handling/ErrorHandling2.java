package operators.error_handling;

import io.reactivex.Observable;
import io.reactivex.functions.BooleanSupplier;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class ErrorHandling2 {

    public static void main(String[] args) {
//        retryWithPredicate();
//        exRetry();
        exRetryUntil();
    }

    public static void retryWithPredicate(){
//        public final Observable<T> retry()
        Observable.error(new IOException("This is an example error"))
                .retry(error -> {
                    if(error instanceof IOException){
                        System.out.println("retrying");
                        return true;
                    }
                    else return false;
                })
                .subscribe(
                        System.out::println,
                        error -> System.out.println("Subscribed Error : " + error.getMessage()),
                        () -> System.out.println("Completed"));
    }

    public static void exRetry(){
        Observable.error(new IOException("This is an example error"))
                .retry(3)  // retry same task for 3 times
                .subscribe(
                        System.out::println,
                        error -> System.out.println("Subscribed Error : " + error.getMessage()),
                        () -> System.out.println("Completed"));
    }

    public static void exRetryUntil(){
        AtomicInteger atomicInteger = new AtomicInteger();
//        public final Observable<T> retryUntil(final BooleanSupplier stop)
        Observable.error(new IOException("This is an example error"))
                .doOnError(error -> {
                    System.out.println(atomicInteger.get());
                    atomicInteger.getAndIncrement();
                })
                .retryUntil(() -> {
                    System.out.println("Retrying");
                    return atomicInteger.get() >= 3;
                })
                .subscribe(
                        System.out::println,
                        error -> System.out.println("Subscribed Error : " + error.getMessage()),
                        () -> System.out.println("Completed"));
    }

}
