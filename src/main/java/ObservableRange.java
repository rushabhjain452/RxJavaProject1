import io.reactivex.Observable;

// The Reactive Loop
public class ObservableRange {

    public static void main(String[] args) {
//        public static Observable<Integer> range(final int start, final int count) {
//        Observable<Integer> observable = Observable.range(0, 10);
//        observable.subscribe(System.out::println);

        int start = 5, count = 2;
        // it prints from start up to (start + count - 1)
        Observable<Integer> observable = Observable.range(start, count);
        observable.subscribe(System.out::println);
    }

}
