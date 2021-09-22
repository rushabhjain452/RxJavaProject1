import io.reactivex.Observable;

public class ObservableErrorDemo {

    public static void main(String[] args) {
//        throwException();
        throwExceptionUsingCallable();
    }

    private static void throwException(){
//        public static <T> Observable<T> error(final Throwable exception)
        Observable observable = Observable.error(new Exception("An Exception"));
        // Same error instance (object) is passed to both observers
        observable.subscribe(System.out::println, error -> System.out.println("Error 1: " + error.hashCode()));
        observable.subscribe(System.out::println, error -> System.out.println("Error 2: " + error.hashCode()));
    }

    private static void throwExceptionUsingCallable(){
//        public static <T> Observable<T> error(Callable<? extends Throwable> errorSupplier)
//        Observable observable = Observable.error(() -> new Exception("An Exception"));
        Observable observable = Observable.error(() -> {
            System.out.println("New Exception Created");
            return new Exception("An Exception");
        });

        // Different error instance (object) is passed to both observers
        observable.subscribe(System.out::println, error -> System.out.println("Error 1: " + error.hashCode()));
        observable.subscribe(System.out::println, error -> System.out.println("Error 2: " + error.hashCode()));
    }

}
