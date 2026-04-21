package task2;

import task2.model.Tree;

public class Main {
    public static void main(String[] args) {

        Tree root1 = new Tree(10);
        System.out.println("Test 1: " + root1.str());
        System.out.println("Contains 5: " + root1.contains(10));
        System.out.println("Contains 10: " + root1.contains(0));
        root1.insertValue(1);
        root1.insertValue(0);
        System.out.println(root1.str());

        Tree root2 = new Tree(1);
        Tree rightChild = new Tree(2);
        rightChild.setRightTree(new Tree(3));
        root2.setRightTree(rightChild);
        System.out.println("Test 2: " + root2.str());
        System.out.println("Contains 5: " + root2.contains(1));
        System.out.println("Contains 10: " + root2.contains(5));
        root2.insertValue(4);
        System.out.println(root2.str());

        Tree root3 = new Tree(5);
        Tree node2 = new Tree(2);
        node2.setLeftTree(new Tree(-4));
        node2.setRightTree(new Tree(3));
        root3.setLeftTree(node2);
        root3.setRightTree(new Tree(18));
        System.out.println("Test 3: " + root3.str());
        System.out.println("Contains 5: " + root3.contains(5));
        System.out.println("Contains 10: " + root3.contains(10));
        root3.insertValue(6);
        System.out.println(root3.str());
    }

}
