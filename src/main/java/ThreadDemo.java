public class ThreadDemo {
    public static void main(String[] args) {
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });

        // Autofix
//        Thread thread = new Thread(() -> {
//
//        });

//        Thread thread = new Thread(() -> {
//                runIt();
//            }
//        );

        Thread thread = new Thread(ThreadDemo::runIt);
    }

    public static void runIt() {

    }
}
