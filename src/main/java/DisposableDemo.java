import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.ResourceObserver;

import java.util.concurrent.TimeUnit;

public class DisposableDemo {

    public static void main(String[] args) {
//        handleDisposable();
//        handleDisposableInObserver();
//        handleDisposableOutsideObserver();
        compositeDisposable();
    }

    private static void handleDisposable(){
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);
//        public final Disposable subscribe(Consumer<? super T> onNext)
        Disposable disposable = observable.subscribe(System.out::println);
        pause(3000);
        disposable.dispose();
        System.out.println("Disposed");
        pause(3000);
    }

    private static void handleDisposableInObserver(){
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);
        Observer<Integer> observer = new Observer<Integer>(){
            Disposable disposable;

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                disposable = d;
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                if(integer == 3){
                    disposable.dispose();
                }
                System.out.println(integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {
//                disposable.dispose();
            }

            @Override
            public void onComplete() {
//                disposable.dispose();
            }
        };

//        public final void subscribe(Observer<? super T> observer)
        observable.subscribe(observer);
    }

    private static void handleDisposableOutsideObserver(){
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);
        ResourceObserver<Integer> observer = new ResourceObserver<Integer>(){

//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//            }

            @Override
            public void onNext(@NonNull Integer integer) {
                System.out.println(integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

//        observable.subscribe(observer);

//        public final <E extends Observer<? super T>> E subscribeWith(E observer)
        Disposable disposable = observable.subscribeWith(observer);
//        disposable.dispose();
    }

    private static void compositeDisposable(){
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);
        Disposable disposable1 = observable.subscribe(item -> System.out.println("Observer 1 : " + item));
        Disposable disposable2 = observable.subscribe(item -> System.out.println("Observer 2 : " + item));
//        public boolean addAll(@NonNull Disposable... disposables)
        compositeDisposable.addAll(disposable1, disposable2);
        pause(3000);
//        disposable1.dispose();
//        disposable2.dispose();
        compositeDisposable.delete(disposable1);
        compositeDisposable.dispose();
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
