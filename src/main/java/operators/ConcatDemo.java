package operators;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

// Concat - different then merge and flatMap
public class ConcatDemo {

    public static void main(String[] args) {
//        exConcat();
//        exConcatWith();
        exConcatMap();
    }

    private static void exConcat(){
        Observable<Integer> oneToFive = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.just(6, 7, 8, 9, 10);

        // Max 4 parameters can be passed to concat() method
        Observable.concat(oneToFive, sixToTen)
                .subscribe(System.out::println);
    }

    private static void exConcatWith(){
        // Generates numbers from 0 to infinity
//        Observable<Long> observable1 = Observable.interval(1, TimeUnit.SECONDS);
//        Observable<Long> observable1 = Observable.interval(1, TimeUnit.SECONDS)
//                .takeWhile(item -> item < 6);
        Observable<String> observable1 = Observable.interval(1, TimeUnit.SECONDS)
                .take(5)
                .map(item -> "Observable-1: " + item);
        Observable<String> observable2 = Observable.interval(308, TimeUnit.MILLISECONDS)
                .map(item -> "Observable-2: " + item);

        observable1
                .concatWith(observable2)
                .subscribe(System.out::println);

//        pause(5000);
        pause(10000);
    }

    private static void exConcatMap(){
        Observable.just("foo", "bar", "jam")
                .concatMap(item -> Observable.fromArray(item.split("")))
                .subscribe(System.out::println);
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
