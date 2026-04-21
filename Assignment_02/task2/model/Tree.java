package task2.model;

public class Tree {
    public int value;
    public Tree left;
    public Tree right;

    public Tree(int value) {
        this.value = value;
    }

    public Tree getLeftTree() {
        return left;
    }

    public void setLeftTree(Tree left) {
        this.left = left;
    }

    public Tree getRightTree() {
        return right;
    }

    public void setRightTree(Tree right) {
        this.right = right;
    }

    public String str() {
        String result = "";

        if (left != null) {
            result += left.str() + " ";
        }

        result += value;

        if (right != null) {
            result += " " + right.str();
        }

        return result;
    }

    public boolean contains(int value) {
        if (value == this.value) {
            return true;
        }

        if (value < this.value && left != null) {
            return left.contains(value);
        } else if (value > this.value && right != null) {
            return right.contains(value);
        }

        return false;
    }

    public void insertValue(int value) {
        if (value < this.value) {
            if (left == null) {
                left = new Tree(value);
            } else {
                left.insertValue(value);
            }
        } else if (value > this.value) {
            if (right == null) {
                right = new Tree(value);
            } else {
                right.insertValue(value);
            }
        }
    }

}
