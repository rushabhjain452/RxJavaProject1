import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

// Hot or Cold ? => Observable.interval is a cold observable
public class ObservableInterval {

    public static void main(String[] args) {
//        public static Observable<Long> interval(long initialDelay, long period, TimeUnit unit)
        Observable observable = Observable.interval(1, TimeUnit.SECONDS);

        observable.subscribe(item -> System.out.println("Observer 1 : " + item));

        pause(2000);

        observable.subscribe(item -> System.out.println("Observer 2 : " + item));

        pause(3000);
    }

    public static void pause(int duration){
        try{
            Thread.sleep(duration);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}
