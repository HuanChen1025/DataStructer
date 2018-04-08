## leetcode-china 
本部分为 leetcode  china 的 中级树和图部分

## 目录
<!-- MarkdownTOC -->

- [17. 电话号码的字母组合](#17-%E7%94%B5%E8%AF%9D%E5%8F%B7%E7%A0%81%E7%9A%84%E5%AD%97%E6%AF%8D%E7%BB%84%E5%90%88)

<!-- /MarkdownTOC -->



<a id="17-%E7%94%B5%E8%AF%9D%E5%8F%B7%E7%A0%81%E7%9A%84%E5%AD%97%E6%AF%8D%E7%BB%84%E5%90%88"></a>
## 17. 电话号码的字母组合

### 题目
>给定一个数字字符串，返回数字所有可能表示的字母组合。
>
>下面给出数字到字母的映射（和电话号码一样）。
>
>![17Image](https://github.com/HuanChen1025/DataStructer/blob/master/img/17Image.png?raw=true)
>
>输入：数字字符串 "23"
>
>输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
>
>说明:
>尽管上面的答案是按字典序排列的，但是你的答案可以是任何顺序。

### 思路
>本题思路比较复杂，算法的时间复杂也比较高，需要三重 for 循环才能解决这个问题。
>
>首先：第一重 for 循环是输入字符的长度
>
>其次：第二重 for 循环是存储到 queue 中上一次循环结束后的字符个数
>
>最后：将当前拿出的数字在哈希表中转化为字符串str，并逐个添加到 queue 中，此循环结束后，哈希表的长度变为字符串 str.length() 倍

### 代码(java)
```java
class Solution {
    public List<String> letterCombinations(String digits) {
         //校验输入
        if (digits == null || digits.length() == 0)
            return new ArrayList<>();

        int length = digits.length();

        //如果数字不在 2—9 这个范围内，返回为空
        for (int i=0;i<length;i++){
            if (digits.charAt(i)<='1' || digits.charAt(i)>'9')
                return new ArrayList<>();
        }

        HashMap<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        //此处这个队列采用 LinkedList 是最优的
        LinkedList<String> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();
        queue.add("");

        for (int i=0;i<length;i++){

            int size = queue.size();

            //获取数字对应的字母
            String str = map.get(digits.charAt(i));

            //这里采用的是获取的 queue 的 size，而不是实时的 queue szie ，
            // 所以在循环中queue中元素的添加不会影响到这里条件判断
            for (;size>0;size--){
                String s = queue.pollFirst();//移除队列的头元素
                for (int j=0;j<str.length();j++){
                    String temp =s + str.charAt(j);
                    queue.offer(temp);
                }
            }
        }

        result.addAll(queue);

        return result; 
    }
}
```