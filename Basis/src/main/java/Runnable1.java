import java.util.concurrent.locks.ReentrantLock;

public class Runnable1 implements Runnable {
    private boolean flag = true;//中断标记
    private final ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (flag){
            System.out.println("runnable1");

        }
    }
    //中断方法
    public void stop(){
        this.flag = false;
    }
    //显示加锁
    public void m(){
        lock.lock();
        try{
            //保证线程安全的代码
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Runnable1 runnable1 = new Runnable1();
        Thread thread = new Thread(runnable1);
        thread.start();


    }
}
