public class TreeExercise {

    /**
     * Repeatedly outputs a menu where the user can insert or delete values 
     * into or from a tree or output the tree until the user chooses to quit 
     * the program.
     */
    public static void main(String[] args) {
        int choice = 0;
        int value = 0;
        Tree tree = null;
        do {
            System.out.println("Waehlen Sie aus:");
            System.out.println("1: Wert einfuegen");
            System.out.println("2: Wert loeschen");
            System.out.println("3: Baum ausgeben");
            System.out.println("4: Element an Position x ausgeben");
            System.out.println("5: Minimum berechnen");
            System.out.println("6: Maximum berechnen");
            System.out.println("7: Median berechnen");
            System.out.println("8: Arithmetisches Mittel berechnen");
            System.out.println("0: Beenden");
            System.out.print("Ihre Wahl: ");
            choice = Integer.parseInt(System.console().readLine());
            switch (choice) {
                case 0:
                    System.out.println("Das Programm wird beendet.");
                    break;
                case 1:
                    System.out.print("Geben Sie den Wert ein: ");
                    value = Integer.parseInt(System.console().readLine());
                    if (tree == null) {
                        tree = new Tree(value);
                    } else {
                        tree.sortedInsert(value);
                    }
                    break;
                case 2:
                    System.out.print("Geben Sie den Wert ein: ");
                    value = Integer.parseInt(System.console().readLine());
                    tree = Tree.sortedDelete(tree, value);
                    break;
                case 3:
                    System.out.println(
                        tree == null ? "Empty tree" : tree.toString()
                    );
                    break;
                case 4:
                    System.out.print("Geben Sie die Position (beginnend bei 0) ein: ");
                    int pos = Integer.parseInt(System.console().readLine());
                    System.out.println(
                        tree == null ? "Empty tree" : tree.getElement(pos)
                    );
                    break;
                case 5:
                    System.out.println(
                        tree == null ? "Empty tree" : tree.getMin()
                    );
                    break;
                case 6:
                    System.out.println(
                        tree == null ? "Empty tree" : tree.getMax()
                    );
                    break;
                case 7:
                    System.out.println(
                        tree == null ? "Empty tree" : tree.getMedian()
                    );
                    break;
                case 8:
                    System.out.println(
                        tree == null ? "Empty tree" : tree.getMean()
                    );
                    break;
                default:
                    System.out.println("Unbekannte Eingabe!");
            }
        } while (choice != 0);
    }
    
}
