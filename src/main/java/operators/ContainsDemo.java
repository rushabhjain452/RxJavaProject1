package operators;

import io.reactivex.Observable;
import io.reactivex.Single;

public class ContainsDemo {

    public static void main(String[] args) {
//        containsWithPrimitive();
        containsWithNonPrimitive();
    }

    public static void containsWithPrimitive(){
//        public final Single<Boolean> contains(final Object element)
        Observable.just(1, 2, 3, 4, 5)
                .contains(3)
                .subscribe(System.out::println);
    }

    public static void containsWithNonPrimitive(){
        User user = new User("mroydroid");
        Observable.just(user)
//                .contains(user)
                .contains(new User("mroydroid"))
                .subscribe(System.out::println);
    }

    static class User{
        String name;

        User(String name){
            this.name = name;
        }
    }

}
