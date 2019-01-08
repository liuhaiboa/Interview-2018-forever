# 如何实现二叉排序树
二叉排序树又称二叉查找树，也就是如果左子树不为空，那么左子树上所有的节点值均小于他的根节点的值。如果右子树不为空，那么右子树的值均大于根节点的值。
## 实现二叉排序树
````$xslt
public class tree {
    class Node{
        public int data;
        public Node left;
        public Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public class BinaryTree {
        private Node root;

        public BinaryTree() {
            root = null;
        }

        //将data插入到排序二叉树种
        public void insert(int data) {
            Node newNode = new Node(data);
            if (root == null) {
                root=newNode;
            }else {
                Node current=root;
                Node parent;
                while (true){//寻找插入位置
                    parent=current;
                    if(data<current.data){
                        current=current.left;
                        if(current==null){
                            parent.left=newNode;
                            return;
                        }
                    }else {
                        current=current.right;
                        if(current==null){
                            parent.right=newNode;
                            return;
                        }
                    }
                }
            }
        }

        //中序遍历 递归实现 中序和后序就是更改三行代码的顺序
        public void inOrder(Node localRoot){
            if (localRoot != null) {
                inOrder(localRoot.left);
                System.out.println(localRoot.data);
                inOrder(localRoot.right);
            }
        }

    }
}

````
## 遍历二叉树
````$xslt
    //前序遍历递归的方式
    public void preOrder(BinaryTreeNode root){
        if(null!=root){
            System.out.print(root.getData()+"\t");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }
    
    //前序遍历非递归的方式
    public void preOrderNonRecursive(BinaryTreeNode root){
        Stack<BinaryTreeNode> stack=new Stack<BinaryTreeNode>();
        while(true){
            while(root!=null){
                System.out.print(root.getData()+"\t");
                stack.push(root);
                root=root.getLeft();
            }
            if(stack.isEmpty()) break;
            root=stack.pop();
            root=root.getRight();
        }
    }
    
    //中序遍历采用递归的方式
    public void inOrder(BinaryTreeNode root){
        if(null!=root){
            inOrder(root.getLeft());
            System.out.print(root.getData()+"\t");
            inOrder(root.getRight());
        }
    }
    
    //中序遍历采用非递归的方式
    public void inOrderNonRecursive(BinaryTreeNode root){
        Stack<BinaryTreeNode> stack=new Stack<BinaryTreeNode>();
        while(true){
            while(root!=null){
                stack.push(root);
                root=root.getLeft();
            }
            if(stack.isEmpty())break;
            root=stack.pop();
            System.out.print(root.getData()+"\t");
            root=root.getRight();
        }
    }
    
    //后序遍历采用递归的方式
    public void postOrder(BinaryTreeNode root){
        if(root!=null){
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.print(root.getData()+"\t");
        }
    }
    
    //后序遍历采用非递归的方式
    public void postOrderNonRecursive(BinaryTreeNode root){
        Stack<BinaryTreeNode> stack=new Stack<BinaryTreeNode>();
        while(true){
            if(root!=null){
                stack.push(root);
                root=root.getLeft();
            }else{
                if(stack.isEmpty()) return;
                
                if(null==stack.lastElement().getRight()){
                    root=stack.pop();
                    System.out.print(root.getData()+"\t");
                    while(root==stack.lastElement().getRight()){
                        System.out.print(stack.lastElement().getData()+"\t");
                        root=stack.pop();
                        if(stack.isEmpty()){
                            break;
                        }
                    }
                }
                
                if(!stack.isEmpty())
                    root=stack.lastElement().getRight();
                else
                    root=null;
            }
        }
    }

    //层序遍历
    public void levelOrder(BinaryTreeNode root){
        BinaryTreeNode temp;
        Queue<BinaryTreeNode> queue=new LinkedList<BinaryTreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            temp=queue.poll();
            System.out.print(temp.getData()+"\t");
            if(null!=temp.getLeft()) 
                queue.offer(temp.getLeft());
            if(null!=temp.getRight()){
                queue.offer(temp.getRight());
            }
        }
    }
    
````
## 层次遍历二叉树
使用队列可以层次遍历二叉树，思路：先将根节点放入队列，然后每次从队列取出一个节点打印该节点的值，若有子节点就将子节点放入队列尾，直到队列为空。
````$xslt
public void layerTranverse(){
            if (this.root == null) {
                return;
            }
            Queue<Node> q=new LinkedList<Node>();
            q.add(this.root);
            while (!q.isEmpty()){
                Node n=q.poll();
                System.out.println(n.data);
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
            }
        }
````
## 如何求二叉树中结点的最大距离
结点的距离就是两个结点之间边的个数。求二叉树中相距最远的两个结点之间的距离。  
思路就是：求左子树距离根节点的最大距离a，其次求右子树到根节点的最大距离b，最大距离就是a+b
````$xslt
public class tree {
    class Node{
        public int data;
        public Node left;
        public Node right;
        public int leftMaxDestance;
        public int rightMaxDestance;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public class BinaryTree1 {
        private int maxLen = 0;

        private int max(int a, int b) {
            return a > b ? a : b;
        }

        public void findMaxDistance(Node root) {
            if (root == null) {
                return;
            }
            if (root.left == null) {
                root.leftMaxDestance = 0;
            }
            if (root.right == null) {
                root.rightMaxDestance = 0;
            }
            if (root.left != null) {
                findMaxDistance(root.left);
            }
            if (root.right != null) {
                findMaxDistance(root.right);
            }
            if (root.left != null) {//计算左子树中距离跟结点的最大距离
                root.leftMaxDestance = max(root.left.leftMaxDestance, root.left.rightMaxDestance) + 1;
            }
            if (root.right != null) {
                root.rightMaxDestance = max(root.right.leftMaxDestance, root.right.rightMaxDestance) + 1;
            }
            if (root.leftMaxDestance + root.rightMaxDestance > maxLen) {
                maxLen = root.leftMaxDestance + root.rightMaxDestance;
            }
        }
     }
     
 }
````