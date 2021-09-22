import io.reactivex.Observable;

public class EmptyAndNeverObservable {

    public static void main(String[] args) {
//        createObservableUsingEmpty();
        createObservableUsingNever();
    }

    private static void createObservableUsingEmpty(){
        Observable observable = Observable.empty();
        observable.subscribe(System.out::println, System.out::println, () -> System.out.println("Completed"));
    }

    private static void createObservableUsingNever(){
        Observable observable = Observable.never();
        observable.subscribe(System.out::println, System.out::println, () -> System.out.println("Completed"));
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
