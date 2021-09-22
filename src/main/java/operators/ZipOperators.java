package operators;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class ZipOperators {

    public static void main(String[] args) {
//        exZip();
//        exZipWith();
        exZipIterable();
    }

    private static void exZip(){
        Observable<Integer> oneToFive = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.range(6, 10);
        Observable<Integer> elevenToFifteen = Observable.fromIterable(Arrays.asList(11, 12, 13, 14, 15));

        // Max 7 parameters can be passed to zip() method
//        Observable.zip(oneToFive, sixToTen, elevenToFifteen, (a,b,c) -> a * b * c)
//            .subscribe(System.out::println);
        Observable.zip(oneToFive, sixToTen, elevenToFifteen, (a,b,c) -> a + b + c)
                .subscribe(System.out::println);
    }

    private static void exZipWith(){
        Observable<Integer> oneToFive = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.fromIterable(Arrays.asList(6, 7, 8, 9, 10));

//        oneToFive.zipWith(sixToTen, (a,b) -> a + b);
        oneToFive.zipWith(sixToTen, Integer::sum)
            .subscribe(System.out::println);
    }

    private static void exZipIterable(){
        Observable<Integer> oneToFive = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.just(6, 7, 8, 9, 10);
//        Observable<Integer> elevenToFifteen = Observable.just(11, 12, 13, 14, 15);
//        Observable<Integer> elevenToFifteen = Observable.just(11, 12, 13, 14);
        Observable<Integer> elevenToFifteen = Observable.empty();

        List<Observable<Integer>> observables = Arrays.asList(oneToFive, sixToTen, elevenToFifteen);

//        Observable.zipIterable(observables, zippedArray -> Arrays.toString(zippedArray), true, 1);
        Observable.zipIterable(observables, Arrays::toString, true, 1)
            .subscribe(System.out::println);
    }

}
