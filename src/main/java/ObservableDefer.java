import io.reactivex.Observable;
import io.reactivex.ObservableSource;

// Care for state changes
public class ObservableDefer {

    private static int start = 5, count = 2;

    public static void main(String[] args) {
        // it prints from start up to (start + count - 1)
//        public static <T> Observable<T> defer(Callable<? extends ObservableSource<? extends T>> supplier)
//        Observable<Integer> observable = Observable.defer(() -> Observable.range(start, count));
        Observable<Integer> observable = Observable.defer(() -> {
            System.out.println("New Observable is created with start = " + start + " and count = " + count);
            return Observable.range(start, count);
        });
        observable.subscribe(item -> System.out.println("Observer 1 : " + item));
        count = 3;
        observable.subscribe(item -> System.out.println("Observer 2 : " + item));
    }

}
