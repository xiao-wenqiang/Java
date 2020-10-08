//静态代理
//好处：真实对象做自己，代理对象做所有
public class StaticProxy {
    public static void main(String[] args) {
        SB sb = new SB();
        WeddingCompany weddingCompany = new WeddingCompany(sb);
        weddingCompany.happyMarry();
    }
}

//结婚
interface Marry {
    void happyMarry();
}

//我要结婚
class SB implements Marry {
    @Override
    public void happyMarry() {
        System.out.println("新婚快乐！");
    }
}

//婚庆公司
class WeddingCompany implements Marry {
    private Marry sb;
    public WeddingCompany(SB sb){
        this.sb = sb;
    }
    @Override
    public void happyMarry() {
        before();
        this.sb.happyMarry();
        after();
    }
    public void before(){
        System.out.println("婚前。。。");
    }
    public void after(){
        System.out.println("婚后。。。");
    }
}