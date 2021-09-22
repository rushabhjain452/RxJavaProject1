package operators;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MergeOperators {

    public static void main(String[] args) {
//        exMerge();
//        exMergeArray();
//        exMergeIterable();
//        exMergeWith();
        exMergeInfinite();
    }

    private static void exMerge(){
        Observable<Integer> oneToFive = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.just(6, 7, 8, 9, 10);

        // Max 4 parameters can be passed to merge() method
//        Observable.merge(oneToFive, sixToTen).subscribe(System.out::println);
        Observable.merge(sixToTen, oneToFive).subscribe(System.out::println);
    }

    private static void exMergeArray(){
        Observable<Integer> oneToFive = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.just(6, 7, 8, 9, 10);
        Observable<Integer> elevenToFifteen = Observable.just(11, 12, 13, 14, 15);
        Observable<Integer> sixteenToTwenty = Observable.just(16, 17, 18, 19, 20);
        Observable<Integer> twentyOneToTwentyFive = Observable.just(21, 22, 23, 24, 25);

        Observable.mergeArray(oneToFive, sixToTen, elevenToFifteen, sixteenToTwenty, twentyOneToTwentyFive)
            .subscribe(System.out::println);
    }

    private static void exMergeIterable(){
        Observable<Integer> oneToFive = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.just(6, 7, 8, 9, 10);
        Observable<Integer> elevenToFifteen = Observable.just(11, 12, 13, 14, 15);
        Observable<Integer> sixteenToTwenty = Observable.just(16, 17, 18, 19, 20);
        Observable<Integer> twentyOneToTwentyFive = Observable.just(21, 22, 23, 24, 25);

        List<Observable<Integer>> observableList =
                Arrays.asList(oneToFive, sixToTen, elevenToFifteen, sixteenToTwenty, twentyOneToTwentyFive);

        Observable.merge(observableList).subscribe(System.out::println);
    }

    private static void exMergeWith(){
        Observable<Integer> oneToFive = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.just(6, 7, 8, 9, 10);

        oneToFive.mergeWith(sixToTen).subscribe(System.out::println);
    }

    private static void exMergeInfinite(){
        Observable<String> infinite1 = Observable.interval(1, TimeUnit.SECONDS)
                .map(item -> "From infinite-1: " + item);
        Observable<String> infinite2 = Observable.interval(2, TimeUnit.SECONDS)
                .map(item -> "From infinite-2: " + item);

        infinite1.mergeWith(infinite2).subscribe(System.out::println);
        pause(6000);
    }

    /** This method sleep the main thread for specified duration... */
    public static void pause(int duration){
        try{
            Thread.sleep(duration);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}
