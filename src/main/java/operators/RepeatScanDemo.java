package operators;

import io.reactivex.Observable;

public class RepeatScanDemo {

    public static void main(String[] args) {
//        useRepeat();
//        useScan();
        useScanWithInitialValue();
    }

    private static void useRepeat(){
        Observable.just(1,2,3,4,5)
                .repeat(3)
                .subscribe(System.out::println);
    }

    private static void useScan(){
        Observable.just(1,2,3,4,5)
                .scan((accumulator, next) -> accumulator + next)
                .subscribe(System.out::println);
    }

    private static void useScanWithInitialValue(){
        Observable.just(1,2,3,4,5)
                .scan(10, (accumulator, next) -> accumulator + next)
                .subscribe(System.out::println);
    }

}
