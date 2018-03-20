package Mooc_zju.linearList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> arrayListImplement = new ArrayList(20);
        arrayListImplement.add(10);
        arrayListImplement.add(10);
        arrayListImplement.add(10);
        arrayListImplement.add(10);
        arrayListImplement.add(10);
        arrayListImplement.insert(2,4);
        System.out.println(arrayListImplement.get(5));
        arrayListImplement.printArray();


    }
}
