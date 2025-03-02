
public class test {
    public static void main(String[] args) {
        Thread T1 = new Thread( new test_runnable(), "HW_thread");
    }
}

class test_runnable implements Runnable{


    @Override
    public void run(){
        System.out.printf("Thread : %s, class : %s --> ",Thread.currentThread().getName(),getClass());
        System.out.println("Hello world");
    }
}