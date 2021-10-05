package educative.bfs.easy;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://www.educative.io/courses/grokking-the-coding-interview/B8nj5RB1LJo
public class RightViewTree {
    public static List<TreeNode> traverse(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);


        while(!queue.isEmpty()){
            int levelSize = queue.size();

            for(int i = 0; i < levelSize; i++){
                TreeNode curr = queue.poll();

                //add last element (right) of each level
                if(i == levelSize - 1){
                    result.add(curr);
                }

                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
        }
        return result;
    }

    @Test
    public void verify() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(3);
        List<TreeNode> result = traverse(root);

        Assert.assertEquals(12, result.get(0).val);
        Assert.assertEquals(1, result.get(1).val);
        Assert.assertEquals(5, result.get(2).val);
        Assert.assertEquals(3, result.get(3).val);
    }
}
