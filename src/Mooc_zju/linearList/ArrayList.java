package Mooc_zju.linearList;

/**
 * 线性表的数组实现方式
 * @author chenhuan
 * @time 2018-3-16
 */
public class ArrayList<E> {
    Object [] data = null;   //用来保存内容的数组
    private int current;    //保存当前第几个元素
    private int capacity;   //保证数组大小的指标

    /**
     * 无参构造函数
     */
    public ArrayList(){
        this(10);//如果没有指定初始化大小，默认为10，调用有参构造函数
    }

    /**
     * 有参构造函数
     * @param intialSize
     */
    public ArrayList(int intialSize ){
        if (intialSize < 0){
            throw new  RuntimeException("数组大小错误: " + intialSize);
        }
        else {
            this.data = new Object[intialSize]; //初始化数组
            this.current = 0;   //当前值为0
            this.capacity = intialSize;     //数组大小为初始化大小
        }
    }

    /**
     * 保证数组的容量
     * @param cur
     */
    private void ensureCapacity(int cur){
        if (cur == capacity){    //如果当前传入的容量和最大容量相等，准备扩容
            this.capacity = capacity + 10;  //  每次扩容加10
            Object [] newData = new Object[capacity];
            for (int i=0;i<cur;i++){
                newData[i] = this.data[i];  //将当前数组转到新的扩容数组中
            }
            this.data = newData;
        }
    }

    /**
     * 插入元素
     * @param e
     * @return
     */
    public boolean add(E e){
        ensureCapacity(current);    //保证容量
        this.data[current] = e ;
        current++;
        return true;
    }

    /**
     * 根据指定的 index 获取元素
     * @param index
     * @return
     */
    public E get(int index){
        validateIndex(index);
        return (E)this.data[index];
    }

    /**
     * 验证元素的下标大小是否越界
     * @param i
     */
    private void  validateIndex(int i){
        if (i<0 || i> current){
            throw  new RuntimeException("获取元素位置错误: "+ i);
        }
    }

    /**
     * 在指定位置插入元素
     * @param index 指定的索引
     * @param element   插入的元素
     */
    public boolean insert(int index ,E element){
        validateIndex(index);   //验证下标是否合法
        Object[] temp = new Object[capacity];   //构建一个缓存数组
        for (int i = 0;i<=current;i++){
            if (i<index){
                temp[i] = this.data[i];
            }else if (i == index){
                temp[i] = element;
            }else if(i > index){
                temp[i] = this.data[i-1];
            }
        }
        this.data = temp;
        return true;
    }

    /**
     * 删除指定下标的元素
     * @param index
     * @return
     */
    private boolean delete(int index){
        validateIndex(index);
        for (int i = index ;i < current ;i++){
            this.data[i] = this.data[i+1];  //index 之后的元素全部向前移动一位
        }
        return false;
    }
    /**
     * 输出元素的长度
     * @return
     */
    public int length(){
        return current;
    }

    /**
     * 打印元素
     */
    public void printArray(){
        for (int i =0; i<current;i++){
            System.out.print(this.data[i]+" ");
        }
    }



}
