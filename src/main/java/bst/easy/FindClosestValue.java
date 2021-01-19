package bst.easy;

public class FindClosestValue {
    public static int findClosestValueInBst(BST tree, int target) {
        return closestValueHelper(tree, target, tree.value);
    }

    private static int closestValueHelper(BST tree, int target, int closest) {
        int currentDiff = Math.abs(target - tree.value);//12-10=2, 12-15=3, 12-13=1
        int currentClosest = Math.abs(target - closest);//12-10=2, 12-10=2, 12-10=2

        if (currentClosest > currentDiff) {
            closest = tree.value;//13
        }
        if (target < tree.value && tree.left != null) {
            return closestValueHelper(tree.left, target, closest);
        }
        if (target > tree.value && tree.right != null) {
            return closestValueHelper(tree.right, target, closest);
        }

        return closest;
    }

    public static int findClosestValueInBstIterative(BST tree, int target) {
        return closestValueHelperIterative(tree, target, tree.value);
    }

    private static int closestValueHelperIterative(BST tree, int target, int closest) {
        BST currentNode = tree;//10,15,13
        while (currentNode != null) {
            int currentDiff = Math.abs(target - currentNode.value);//12-10=2,12-15=3,12-13=1
            int currentClosest = Math.abs(target - closest);//12-10=2,12-10=2,12-10=2
            if (currentClosest > currentDiff) {
                closest = currentNode.value;//13
            }
            if (target < currentNode.value) {
                currentNode = currentNode.left;
            } else if (target > currentNode.value) {
                currentNode = currentNode.right;
            } else {
                break;
            }
        }
        return closest;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
