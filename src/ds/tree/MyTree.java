package ds.tree;

public class MyTree<T extends Number> {

    private T value;
    private MyTree<T> leftChild;
    private MyTree<T> rightChild;
    static int loop;

    public MyTree(T value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    public void add(T data) {
        if (data.doubleValue() <= value.doubleValue()) {
            if (leftChild == null) {
                leftChild = new MyTree<>(data);
            } else {
                leftChild.add(data);
            }
        } else {
            if (rightChild == null) {
                rightChild = new MyTree<>(data);
            } else {
                rightChild.add(data);
            }


        }

    }

    public boolean having(T data) {
        if (data.equals(value)) return true;
        else if (data.doubleValue() < value.doubleValue()) {
            if (leftChild == null) return false;
            else leftChild.having(data);
        } else {
            if (rightChild == null) return false;
            else rightChild.having(data);
        }

        return false;
    }

    static char right = '/';

    public void printTree() {

        //   System.out.print("-");
        loop++;
        if (rightChild != null) {
            right = '/';
            rightChild.printTree();
            right = 'b';
        }
        loop--;

        for (int i = 0; i < loop; i++) {
            System.out.print("  ");
        }
        if (loop != 0) System.out.print(right);
        else System.out.print("-");
     System.out.println(value);
        // System.out.print("-");

        loop++;
        if (leftChild != null) {
            right = '\\';
            leftChild.printTree();


        }
        loop--;

    }

}
