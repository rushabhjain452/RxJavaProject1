package operators;

import io.reactivex.Observable;

public class MapAndFilterDemo {

    public static void main(String[] args) {
//        mapOperator();
//        mapOperatorReturnsDifferentData();
//        filterOperator();
        combineMapAndFilter();
    }

    public static void mapOperator(){
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);
        observable
                .map(item -> item)
                .subscribe(System.out::println);
    }

    public static void mapOperatorReturnsDifferentData(){
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);
//        observable
//                .map(item -> item * 2)
//                .subscribe(System.out::println);

        observable
                .map(item -> "Hello World !!")
                .subscribe(System.out::println);
    }

    public static void filterOperator(){
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);
//        observable
//                .filter(item -> false)
//                .subscribe(System.out::println);
        observable
                .filter(item -> item % 2 == 0)
                .subscribe(System.out::println);
    }

    public static void combineMapAndFilter(){
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);

        observable
                .filter(item -> item % 2 == 0)
                .map(item -> item * 2)
                .subscribe(System.out::println);
    }

}
