//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try {
            Lista<Integer> l = new Lista<Integer>();

            System.out.println(l.isEmpty());

            l.append(5);
            l.append(8);
            l.append(2);
            l.append(13);
            l.append(7);
            l.insert(4, 2);
            l.insert(10, 0);

            System.out.println(l.size());
            System.out.println(l);

            l.remove(10);
            l.remove(8);
            System.out.println(l);

            System.out.println(l.delete(0));
            System.out.println(l.delete(3));
            System.out.println(l);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
