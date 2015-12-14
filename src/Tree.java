public class Tree {
    private int value;
    private Tree right;
    private Tree left;

    public Tree(int v) {
        this.value = v;
        this.right = null;
        this.left = null;
    }

    public int getValue() {
        return value;
    }

    public Tree getRight() {
        return right;
    }

    public Tree getLeft() {
        return left;
    }

    public void setValue(int v) {
        value = v;
    }

    public void setRight(Tree r) {
        this.right = r;
    }

    public void setLeft(Tree l) {
        this.left = l;
    }

    public String toString() {
        return stringHelper(this);
    }

    private String stringHelper(Tree t) {
        if (t == null) {
            return "";
        } else {
            return stringHelper(t.getLeft()) + ", " + t.getValue() + ", " + t.getRight();
        }
    }

    public Tree copy() {
        return new Tree(this.getValue());
    }


    public int getMin() {
        if (this.getLeft() == null) {
            return this.getValue();
        } else {
            this.getLeft().getMin();
        }
        return -1;
    }

    public int getMax() {
        if (this.getRight() == null) {
            return this.getValue();
        } else {
            this.getRight().getMin();
        }
        return -1;
    }

    boolean isSorted() {
        //keine Ahnung, was getMin und getMax bringen sollen
        if (this.getLeft() == null && this.getRight() == null) {
            return true;
        } else if (this.getLeft() == null) {
            return (this.getValue() < this.getRight().getValue()) && this.getRight().isSorted();
        } else if (this.getRight() == null) {
            return (this.getValue() < this.getLeft().getValue()) && this.getLeft().isSorted();
        } else {
            return (this.getValue() < this.getRight().getValue()) && (this.getValue() >= this.getLeft().getValue()) && this.getLeft().isSorted() && this.getRight().isSorted();
        }
    }


    public int getElement(int i) {
        int[] array = new int[treeSize(this)];
        fillArray(this, array, 0);
        return array[i];
    }

    private static int fillArray(Tree t, int[] array, int index) {
        if (t.getLeft() != null) {
            index = fillArray(t.getLeft(), array, index);
        }

        if (t.getRight() != null) {
            index = fillArray(t.getRight(), array, index);
        }

        array[index] = t.getValue();

        return index + 1;
    }

    public int treeSize(Tree t) {
        if ((t.getLeft() == null) && (t.getRight() == null)) {
            return 1;
        } else {
            return treeSize(t.getLeft()) + treeSize(t.getRight()); //addiert viele Einsen
        }
    }

    public double getMean() {
        int[] array = new int[treeSize(this)];
        fillArray(this, array, 0);
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }

    public int getMedian() {
        if (this.isSorted()) {
            int[] array = new int[treeSize(this)];
            fillArray(this, array, 0);
            if (array.length % 2 == 0) { //wenn Länge gerade
                return array[array.length/2-1];
            }
            if (array.length % 2 == 1) { //wenn ungerade
                return array[array.length/2 ];
            }
        }
        return 1;
    }

    void sortedInsert(int i) {
        if (this.getValue() == i) { //Duplikat
            return;
        }
        if (this.getValue() > i) { //veruschen, links einzufügen
            if (this.getLeft() == null) { //wenn leer
                this.setLeft(new Tree(i));
            } else { //wenn links belegt, von vorne
                this.getLeft().sortedInsert(i);
            }
        }
        if (this.getValue() < i) { //versuchen, rechts einzufügen
            if (this.getRight() == null) { //wenn leer
                this.setRight(new Tree(i));
            } else {//wenn rechts schon belegt, von vorne
                this.getRight().sortedInsert(i);
            }
        }
        //funktioniert nicht so wirklich, der tree hat viele nullen
    }

    static Tree sortedDelete(Tree t, int i) {
        //TODO
        return t;
    }
}
