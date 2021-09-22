import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class ObservableTypesDemo {

    public static void main(String[] args) {
//        createColdObservable();
        createHotAndConnectableObservable();
    }

    public static void createColdObservable(){
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);

        observable.subscribe(item -> System.out.println("Observer 1 : " + item));

        pause(3000);

        observable.subscribe(item -> System.out.println("Observer 2 : " + item));
    }

    public static void createHotAndConnectableObservable(){
        ConnectableObservable<Integer> observable = Observable.just(1, 2, 3, 4, 5).publish();

        observable.subscribe(item -> System.out.println("Observer 1 : " + item));
        observable.connect();
        observable.subscribe(item -> System.out.println("Observer 2 : " + item));
    }

    public static void pause(int duration){
        try{
            Thread.sleep(duration);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}
