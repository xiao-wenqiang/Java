public class BuyTickets implements Runnable {
    private static int tickets = 10;    //共享资源
    boolean flag = true;    //中断标记
    @Override
    public void run() { //买票
        while (flag) {
            if(tickets<=0){
                flag = false;
                return;
            }else {
                System.out.println(Thread.currentThread().getName()+"："+tickets--);
            }
        }
    }

    //线程同步：队列+锁synchronized
    //像private，synchronized控制访问对象
    //syn方法，用它的要拿它的对象锁
    //syn块，可以锁任意对象
    //synchronized方法锁的是this，synchronized块可以锁任意对象
    //锁的是一个对象。（要改数据的对象）
    //锁解决的就是：多线程访问同一对象
    public static void main(String[] args) {
        //静态代理（买票、人、车站）
        //谁要干嘛？Thread开线程帮ta干
        BuyTickets station = new BuyTickets();
        new Thread(station,"bendan").start();//用bendan名字买
        new Thread(station,"bendan1").start();//用bendan1名字买
        new Thread(station,"bendan2").start();//用bendan2名字买
        new Thread(()->{

        }).start();

        //lock锁



    }
}
