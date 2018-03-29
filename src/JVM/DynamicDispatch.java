package JVM;

public class DynamicDispatch {
    static abstract class Human{
        protected abstract void sayHello();

    }

    static class Man extends Human{
        @Override
        protected void sayHello(){
            System.out.println("hello gentleMan");
        }

    }

    static class Woman extends Human{
        @Override
        protected void sayHello(){
            System.out.println("hello lady");
        }

    }



    public static void main(String[] args) {
        Man man = new Man();
        Human woman = new Woman();
        DynamicDispatch sr = new DynamicDispatch();
        man.sayHello();
        woman.sayHello();
    }

}
