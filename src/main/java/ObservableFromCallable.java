import io.reactivex.Observable;

public class ObservableFromCallable {

    public static void main(String[] args) {
//        Observable<Integer> observable = Observable.just(getNumber());

//        public static <T> Observable<T> fromCallable(Callable<? extends T> supplier)
//        Observable<Integer> observable = Observable.fromCallable(() -> getNumber());
        Observable<Integer> observable = Observable.fromCallable(() -> {
            System.out.println("Calling Method");
            return getNumber();
        });

        observable.subscribe(System.out::println,
                error -> System.out.println("An Exception Occurred : " + error.getLocalizedMessage()));
    }

    private static int getNumber() {
        System.out.println("Generating Value");
//        return 3 * 5;
        return 1 / 0;
    }

}
