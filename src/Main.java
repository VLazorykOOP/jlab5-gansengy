public
class Main {

    public static void main(String[] args) {
        System.out.println(" Java lab 7 ");
        ThreadStarter.main(args);
	// write your code here
    }
}

//public
  class ThreadStarter {
    public static void main(String[] args) {
        NamedRunnable nr = new NamedRunnable();
        Thread one = new Thread(nr);
        Thread two = new Thread(nr);
        Thread three = new Thread(nr);

        one.setName("Перший");
        two.setName("Другий");
        three.setName("Третій");

        one.start();
        two.start();
        three.start();
    }
}

class NamedRunnable implements Runnable {
    public void run() {
        System.out.println("Завантажений " + Thread.currentThread().getName());
        System.out.println("Закінченний  "+ Thread.currentThread().getName());
    }
}


