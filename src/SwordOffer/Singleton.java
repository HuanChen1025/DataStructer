package SwordOffer;

public class Singleton {
    public static void main(String[] args) {
        System.out.println(StaticSingleton.getInstance());
    }
}

class NormalSingleton{
    public static int x =5;
    //私有构造函数
    private NormalSingleton(){
        System.out.println("Singleton is create!");
    }
    //私有单例实例
    private static NormalSingleton instance = new NormalSingleton();
    public static NormalSingleton getInstance(){
        return instance;   //返回单例对象
    }
}

class LazySingleton{
    private LazySingleton(){
        System.out.println("LazySingleton is create!");
    }

    private  static LazySingleton instance ;

    //加入同步锁，防止在多线程环境下混乱。但是加锁会导致性能降低
    public static synchronized LazySingleton getInstance(){
        if (instance == null){
            new LazySingleton();
        }
        return instance;
    }
}

class StaticSingleton{
    public static int x =5;
    private StaticSingleton(){
        System.out.println("StaticSingleton is create!");

    }
    //静态内部类
    private static class SingletonHolder{
        private static StaticSingleton instance = new StaticSingleton();
    }
    public static StaticSingleton getInstance(){
        return SingletonHolder.instance;
    }
}
