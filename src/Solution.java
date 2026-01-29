
import java.util.HashMap;
import java.util.Map;

public class Solution {

    int preOrderIndex;
    Map<Integer, Integer> inOrderindexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        /**
         * We have two arrays : one for preorder and the other one for in-order.
         * The preorder array tells us what is the root element at any given moement 
         * whereas the inorder array tells us when will be the left sub tree and 
         right subtree
         *  */
        /**
         * initializing global variables
         */
        preOrderIndex = 0;
        inOrderindexMap = new HashMap<>();
        /**
         * filling up the inOrderindexMap
         */
        for (int i = 0; i < inorder.length; i++) {
            inOrderindexMap.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, preorder.length - 1);

    }
    /**
     * 
     */
    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        /**
         * terminating condition
         */
        if (left > right) {
            return null;
        }
        /**
         * root value is whatever value of preOrder inde that we have right now
         */
        int rootValue = preorder[preOrderIndex];
        preOrderIndex++;
        /**
         * creating root node
         */
        TreeNode root = new TreeNode(rootValue);

        /**
         * We provide all values after root node as part of rigt subtree
         */
        root.left = arrayToTree(preorder, left, inOrderindexMap.get(rootValue) - 1);
        /**
         * We provide all values before root node as part of left subtree
         */
        root.right = arrayToTree(preorder, inOrderindexMap.get(rootValue) + 1, right);

        return root;
        
    }

}
