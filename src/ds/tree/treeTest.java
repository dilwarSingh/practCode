package ds.tree;

import java.util.TreeSet;

public class treeTest {
    public static void main(String[] args) {

        int x[] = {1, 3, 6, 5, 8, 4, 7};

        MyTree<Integer> myTree = new MyTree<>(4);
        myTree.add(2);
        myTree.add(3);
        myTree.add(1);
        myTree.add(6);
        myTree.add(5);
        myTree.add(7);
    //    myTree.add(4);


        myTree.printTree();

    }

 /*   private static void visitTree(MyTree<Integer> myTree) {

        if (myTree == null) return;
        System.out.println(myTree.getValue());

        visitTree(myTree.getLeftChild());
        visitTree(myTree.getRightChild());

    }*/


}
