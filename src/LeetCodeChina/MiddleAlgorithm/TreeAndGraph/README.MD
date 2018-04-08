## leetcode-china 
本部分为 leetcode  china 的 中级树和图部分

## 目录

<!-- MarkdownTOC -->

- [94. 中序遍历二叉树](#94-%E4%B8%AD%E5%BA%8F%E9%81%8D%E5%8E%86%E4%BA%8C%E5%8F%89%E6%A0%91)
- [103.二叉树的锯齿形层次遍历](#103%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E9%94%AF%E9%BD%BF%E5%BD%A2%E5%B1%82%E6%AC%A1%E9%81%8D%E5%8E%86)
- [116.每个节点的右向指针](#116%E6%AF%8F%E4%B8%AA%E8%8A%82%E7%82%B9%E7%9A%84%E5%8F%B3%E5%90%91%E6%8C%87%E9%92%88)
- [200. 岛屿的个数](#200-%E5%B2%9B%E5%B1%BF%E7%9A%84%E4%B8%AA%E6%95%B0)

<!-- /MarkdownTOC -->


<a id="94-%E4%B8%AD%E5%BA%8F%E9%81%8D%E5%8E%86%E4%BA%8C%E5%8F%89%E6%A0%91"></a>
## 94. 中序遍历二叉树

### 题目
>给定一个二叉树，返回其中序遍历。
>
>例如：
>给定二叉树 [1,null,2,3],
>
>![94image](https://github.com/HuanChen1025/DataStructer/blob/master/img/94Image.JPG?raw=true)
>
>返回 [1,3,2].
>
>说明: 递归算法很简单，你可以通过迭代算法完成吗？

<a id="%E6%80%9D%E8%B7%AF"></a>
### 思路

**方法一：最直观和简单的方法是采用递归求解**
>采用递归求解，简单，但是对于超长的链表，保存现场会花去很多内存.具体思路为：

>对左子结点调用递归函数，根节点访问值，右子节点再调用递归函数

**方法二：采用循环，利用栈保存中间结点**

>思路是从根节点开始，先将根节点压入栈，

>然后再将其所有左子结点压入栈，然后取出栈顶节点，保存节点值，

>再将当前指针移到其右子节点上，若存在右子节点，则在下次循环时又可将其所有左子结点压入栈中。

>这样就保证了访问顺序为左-根-右，


### 代码(java)

#### 递归法：
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    //返回结果集
    List<Integer> results = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        //如果为空，返回空的集合，此处不能返回 null
        if (root == null)
            return new ArrayList<>();

        //左子节点递归
        if (root.left != null){
            inorderTraversal(root.left);
        }

        //根节点添加值
        results.add(root.val);

        //右子节点调用值
        if (root.right != null){
            inorderTraversal(root.right);
        }

        return results;
    }
}
```

#### 循环法:
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
           //如果为空，返回空的集合，此处不能返回 null
        if (root == null)
            return new ArrayList<>();

        //返回结果集
        List<Integer> results = new ArrayList<>();

        //堆，用于保存结点
        Stack<TreeNode> stack = new Stack<>();

        //临时结点，代替 root，不能改变原树
        TreeNode p = root;

        while (p!=null || !stack.empty()){
            //把根节点的所有左结点压入到堆栈中
            while (p!=null){
                stack.push(p);
                p=p.left;
            }
            p = stack.peek();   //返回堆栈的顶，不弹出
            stack.pop();
            results.add(p.val);
            p=p.right;
        }
        return results;
    }
}

```

<a id="103%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E9%94%AF%E9%BD%BF%E5%BD%A2%E5%B1%82%E6%AC%A1%E9%81%8D%E5%8E%86"></a>
## 103.二叉树的锯齿形层次遍历
### 题目
>给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
>
>例如：
>给定二叉树 [3,9,20,null,null,15,7],
>
>![103image](https://github.com/HuanChen1025/DataStructer/blob/master/img/103Image1.JPG?raw=true)
>
>返回锯齿形层次遍历如下：
>
>![103image](https://github.com/HuanChen1025/DataStructer/blob/master/img/103Image2.JPG?raw=true)
>
>

### 思路
>在层次遍历法的基础上每一层输出结果间隔反转
>
>设置一个标志位 flag，将每一层的输出结果间隔反转，采用方法为：Collections.reverse(levelResult);
>

### 代码(java)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
           List<List<Integer>> result = new ArrayList<List<Integer>>();

        Queue<TreeNode> queue = new ArrayDeque<>(); //队列，用于保存结点
        //校验输入
        if (root == null)
            return result;

        boolean flag = false;
        int count = 1;
        int levelCount = 0;
        //将根节点添加到队列中
        queue.add(root);

        //只要队列不为空
        while (!queue.isEmpty()){
            List<Integer> levelResult = new ArrayList<>();
            while (count>0){
                TreeNode current = queue.poll();
                levelResult.add(current.val);
                if (current.left!= null){
                    queue.offer(current.left);//添加到队列
                    levelCount++;
                }
                if (current.right!=null){
                    queue.offer(current.right);
                    levelCount++;
                }
                count--;
            }
            if (flag == true){
                //反转集合
                Collections.reverse(levelResult);
                result.add(levelResult);
                flag = false;
            }else {
                result.add(levelResult);
                flag = true;
            }

            count = levelCount; //下一层的结点个数
            levelCount=0;   //记录下下一层的结点个数

        }
        return result;
    }
}

```

<a id="116%E6%AF%8F%E4%B8%AA%E8%8A%82%E7%82%B9%E7%9A%84%E5%8F%B3%E5%90%91%E6%8C%87%E9%92%88"></a>
## 116.每个节点的右向指针


### 题目
>给定一个二叉树
>
>![116Image1](https://github.com/HuanChen1025/DataStructer/blob/master/img/116Image1.JPG?raw=true)
>
>填充他的每个 next（下一个）指针，让这个指针指向其下一个右侧节点。如果找不到下一个右节点，则应该将 next（下一个）指针设置为 NULL。
>
>初始状态下，所有 next（下一个）指针 都被设置为 NULL。
>
>注意事项:
>
> - 您只能使用恒定的额外空间。
> - 你可以假设它是一棵完美二叉树（即所有叶子都在同一水平上，每个父节点有两个孩子）。
>
>例如，鉴于以下完美二叉树，
>
>![116Image2](https://github.com/HuanChen1025/DataStructer/blob/master/img/116Image2.JPG?raw=true)
>
>调用你的函数后，该树应该变成这样：
>
>![116Image3](https://github.com/HuanChen1025/DataStructer/blob/master/img/116Image3.JPG?raw=true)

### 思路
>本质是，采用层次遍历法，只是在层次遍历的时候注意区分该层的最后一个结点。
>
>时间复杂度为O(N),空间复杂度也为O(N),所以该算法不是最优的

### 代码(java)
```java
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;

        Queue<TreeLinkNode> queue = new ArrayDeque<>(); //队列，用于保存结点

        int count = 1;
        int levelCount = 0;
        //将根节点添加到队列中
        queue.add(root);
        root.next = null;//根节点的 next 结点为 null

        //只要队列不为空
        while (!queue.isEmpty()){
            TreeLinkNode currentNode = null;
            TreeLinkNode nextNode = null;
            while (count>0){
                 currentNode = queue.poll();
                 if (count == 1){
                     nextNode = null;   //如果是该层的最后一个结点，就会把它指向下一层的第一个结点
                 }else
                     nextNode = queue.peek();

                currentNode.next = nextNode;
                if (currentNode.left != null){
                    queue.offer(currentNode.left);//添加到队列
                    levelCount++;
                }
                if (currentNode.right!=null){
                    queue.offer(currentNode.right);
                    levelCount++;
                }
                count--;
            }


            count = levelCount; //这一层的结点
            levelCount=0;   //记录下一层的结点
        }
    }
}
```
<a id="200-%E5%B2%9B%E5%B1%BF%E7%9A%84%E4%B8%AA%E6%95%B0"></a>
## 200. 岛屿的个数

### 题目：
>给定 '1'（陆地）和 '0'（水）的二维网格图，计算岛屿的数量。一个岛被水包围，并且通过水平或垂直连接相邻的陆地而形成。你可>以假设网格的四个边均被水包围。
>
>示例 1:
>
>![200Image1](https://github.com/HuanChen1025/DataStructer/blob/master/img/200Image1.JPG?raw=true)
>
>答案: 1
>
>示例 2:
>
>![200Image2](https://github.com/HuanChen1025/DataStructer/blob/master/img/200Image2.JPG?raw=true)
>
>答案: 3

### 思路
>本题的思路是借鉴了别人的答案，来自[CSDN](https://blog.csdn.net/mine_song/article/details/69362110)
>
>采用**深度优先遍历**，把访问过的改为‘0’，继续遍历,递归求解

### 代码(java)

```java
class Solution {
    public int numIslands(char[][] grid) {
                //校验输入
        if (grid == null || grid.length==0 || grid[0].length ==0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int result = 0;
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (grid[i][j]=='1')
                    result++;
                    dfSearch(grid,i,j,rows,cols);
            }
        }
        return result;
    }
    
     //如果一个位置为 1 ，将其四周的 1 全部置为 0
    private void dfSearch(char[][] grid,int i,int j,int rows,int cols){
        if (i<0 || i>=rows || j<0 || j>=cols)
            return;
        //如果这个位置不为 1 ，返回
        if (grid[i][j] != '1')
            return;

        grid[i][j] = 0;
        //将 i j 位置的上下左右搜索一遍，如果为 1 ，置位 0
        dfSearch(grid,i-1,j,rows,cols);
        dfSearch(grid,i+1,j,rows,cols);
        dfSearch(grid,i,j-1,rows,cols);
        dfSearch(grid,i,j+1,rows,cols);
    }
}
```