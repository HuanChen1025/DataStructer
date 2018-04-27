## leetcode-china 
本部分为 leetcode  china 的 中级排序和搜索部分

##目录

<!-- MarkdownTOC -->

- [75. 分类颜色](#75-%E5%88%86%E7%B1%BB%E9%A2%9C%E8%89%B2)
- [347. Top K Frequent Elements](#347-top-k-frequent-elements)
- [215. 数组中的第K个最大元素](#215-%E6%95%B0%E7%BB%84%E4%B8%AD%E7%9A%84%E7%AC%ACk%E4%B8%AA%E6%9C%80%E5%A4%A7%E5%85%83%E7%B4%A0)
- [162.寻找峰值](#162%E5%AF%BB%E6%89%BE%E5%B3%B0%E5%80%BC)
- [34.搜索范围](#34%E6%90%9C%E7%B4%A2%E8%8C%83%E5%9B%B4)

<!-- /MarkdownTOC -->


<a id="75-%E5%88%86%E7%B1%BB%E9%A2%9C%E8%89%B2"></a>
## 75. 分类颜色
### 题目
>给定一个包含红色、白色和蓝色，且含有 n 个元素的数组，对它们进行排序，使得相同颜色的元素相邻，颜色顺序为红色、白色、蓝色。
>
>此题中，我们使用整数 0, 1 和 2 分别表示红色，白色和蓝色。
>
>注意:
>不能使用代码库中的排序函数来解决这道题。
>
>点击显示进阶问题.
>
>进阶：
>一个相当直观的解决方案是使用计数排序的 two-pass 算法。
>
>首先，迭代计算出0，1 和 2 元素的个数，然后重写当前数组。
>
>你能想出一个仅使用恒定空间的 one-pass 算法吗？

### 思路
本题的解题思路很 low，采用的是最直观的方式，先统计出各种颜色的个数，再重写颜色数组。

### 代码(java)

```java
class Solution {
    public void sortColors(int[] nums) {
                if (nums.length == 0 || nums == null)
            return;

        int length = nums.length;
        int redCount =0;
        int whiteCount =0;
        int blueCount =0;

        for (int i=0;i<length;i++){
            if (nums[i]==0)
                redCount++;
            else  if (nums[i]==1)
                whiteCount++;
            else if (nums[i] == 2)
                blueCount++;
        }

        for (int i=0;i<redCount;i++)
             nums[i]=0;

        for (int i=redCount;i<whiteCount+redCount;i++)
            nums[i]=1;

        for (int i=redCount+whiteCount;i<length;i++)
            nums[i]=2;
    }
}

```
<a id="347-top-k-frequent-elements"></a>
## 347. Top K Frequent Elements

### 题目
>给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
>
>例如，
>
>给定数组 [1,1,1,2,2,3] , 和 k = 2，返回 [1,2]。
>
>注意：
>
>你可以假设给定的 k 总是合理的，1 ≤ k ≤ 数组中不相同的元素的个数。
>你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。

### 思路
> 参考了某国外大佬的答案，不太能看懂:http://zpjiang.me/2017/11/13/top-k-elementes-system-design/
>
> 采用的是hashmap + maxheap
> 
> 时间复杂度为O(n)
> 

### 代码(java)

```java
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
               List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0 )
            return res;
        Map<Integer,Integer> map = new HashMap<>();

        //遍历元素，添加到 hashmap，语句非常精简
        for (int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }

        //优先队列，实现最大堆，这里看不懂？？？？
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((a,b) -> (b.getValue() - a.getValue()));

        //map.entrySet() 返回此映射所包含的映射关系的 Set 视图。
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            maxHeap.add(entry);
        }

        while(res.size()<k){
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }
}

```

<a id="215-%E6%95%B0%E7%BB%84%E4%B8%AD%E7%9A%84%E7%AC%ACk%E4%B8%AA%E6%9C%80%E5%A4%A7%E5%85%83%E7%B4%A0"></a>
## 215. 数组中的第K个最大元素
### 题目
> 在未排序的数组中找到第 k 个最大的元素。请注意，它是数组有序排列后的第 k 个最大元素，而不是第 k 个不同元素。
>
> 例如，
> 给出 [3,2,1,5,6,4] 和 k = 2，返回 5。
>
>注意事项:
>
> 你可以假设 k 总是有效的，1 ≤ k ≤ 数组的长度。
> 

### 思路
> 采用了 API 自带的排序算法

### 代码(java)

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
                //检验输入
        if (nums == null || nums.length == 0 || k<=0 || k>nums.length)
            return -1;

        List<Integer> list = new ArrayList<>();

        for (int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }

        Collections.sort(list);

        Collections.reverse(list);

        return list.get(k-1);
    }
}
```

<a id="162%E5%AF%BB%E6%89%BE%E5%B3%B0%E5%80%BC"></a>
## 162.寻找峰值
### 题目
> 峰值元素是指其值大于左右相邻值的元素。
>
>给定一个输入数组，其中 num[i] ≠ num[i+1]，找到峰值元素并返回其索引。
>
>数组可能包含多个峰值，在这种情况下，返回到任何一个峰值所在位置都可以。
>
>你可以想象得到  num[-1] = num[n] = -∞。
>
>例如，在数组 [1, 2, 3, 1]中 3 是峰值元素您的函数应该返回索引号2。
>
>注意:
>
>你的解决方案应该是对数复杂度的。

###思路
>有更优的实现解，本方法不是最优.
>
> 这道题其实很简单，主要是对索引进行判断。我的方法不是最优的，只是能 AC 罢了
> 

### 代码
```java
class Solution {
    public int findPeakElement(int[] nums) {
                if (nums.length == 0 || nums == null)
            return -1;
        for (int i=0;i<nums.length;i++){
            int currentValue =nums[i];
            int preIndex = i-1;
            int preValue =0;
            int nextIndex =i+1;
            int nextValue =0;

            if (preIndex<0)
                preValue=Integer.MIN_VALUE;
            else
                preValue = nums[preIndex];

            if (nextIndex>=nums.length)
                nextValue = Integer.MIN_VALUE;
            else
                nextValue = nums[nextIndex];

            if (currentValue>preValue && currentValue>nextValue)
                return i;
        }
        return 0;
    }
}
```
<a id="34%E6%90%9C%E7%B4%A2%E8%8C%83%E5%9B%B4"></a>
## 34.搜索范围

###题目
> 给定一个已经升序排序的整形数组，找出给定目标值的开始位置和结束位置。
>
>你的算法时间复杂度必须是 O(log n) 级别。
>
>如果在数组中找不到目标，返回 [-1, -1]。
>
>例如:
>给出 [5, 7, 7, 8, 8, 10] 和目标值 8，
>返回 [3, 4]。

### 思路

> 二分查找
> 
> 凡是见到这种排好序的，首先想到的必然是二分查找
> 既然要求O(log n)那必然又是binary search变种。
> 要找到target在数组中的左右边界，必然先得要在数组中找到一个target。
> 一种条件反射的思路是binary search找到target，即A[mid] = target，然后从mid开始向左右扫描来发现左右边界。
> 但显然这种算法不是O(log n)的，比如当所有元素都一样，并且等于target时，算法退化为O(n)。
>
> 所以这里当A[mid] = target时，我们必须继续用二分法来查找左右边界。
> 
> 来源：http://bangbingsyb.blogspot.jp/2014/11/leetcode-search-for-range.html

### 代码(java)
```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
            int [] result = {-1,-1};
        //校验输入
        if (nums.length == 0 || nums == null)
            return result;

        result[0] = leftSearch(nums,target);
        result[1] = rightSearch(nums,target);

        return result;
    }
    
     /**
     * 向左搜索
     * @param nums
     * @param target
     * @return
     */
    private int leftSearch(int[] nums,int target){
        int start = 0;
        int end = nums.length-1;
        int middle = (start+end)/2;

        while (start<=end){
            if (nums[middle] == target){
                end = middle-1;
            }
            else if (nums[middle]>target){
                end = middle-1;
            }
            else if (nums[middle]<target){
                start = middle+1;
            }
            middle = (start+end)/2;
        }

        if (start>=0 && start<nums.length && nums[start]==target)
            return start;
        return -1;
    }
    
     /**
     * 右边搜索边境
     * @param nums
     * @param target
     * @return
     */
    private int rightSearch(int[] nums,int target){
        int start = 0;
        int end = nums.length-1;
        int middle = (start+end)/2;

        while (start<=end){
            if (nums[middle] == target){
                start = middle+1;
            }
            else if (nums[middle]>target){
                end = middle-1;
            }
            else if (nums[middle]<target){
                start = middle+1;
            }
            middle = (start+end)/2;
        }

        if (end>=0 && end<nums.length && nums[end]==target)
            return end;
        return -1;
    }

}
```