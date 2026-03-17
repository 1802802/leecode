package leecode.tree;

import java.util.ArrayList;
import java.util.List;

/*
① NLR：前序遍历(Preorder Traversal 亦称（先序遍历））
——访问根结点的操作发生在遍历其左右子树之前。
② LNR：中序遍历(Inorder Traversal)
——访问根结点的操作发生在遍历其左右子树之中（间）。
③ LRN：后序遍历(Postorder Traversal)
——访问根结点的操作发生在遍历其左右子树之后。
 */
public class inorderTraversal94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    /*
    其实可以发现，三种遍历方式本质是调整这里的三行语句的顺序
     */
    public void inorderTraversal(TreeNode node, List<Integer> result) {
        if (node != null) {
            inorderTraversal(node.left, result);
            result.add(node.val);
            inorderTraversal(node.right, result);
        }
    }
}
