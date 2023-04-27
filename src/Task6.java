import java.util.Scanner;

public class Task6 {

    public static void search_team(int n, Bag bag) {
        System.out.println("Итерация ");
        Scanner in = new Scanner(System.in);
        if (n <= 1){
            System.out.println(bag.remove());
            return ;
        }
        Bag bag_tmp = new Bag(n/2);

        for (int i = 0; i < n / 2; i++) {
            Object item1 = bag.remove();
            System.out.println(item1);
            Object item2 = bag.remove();
            System.out.println(item2);
            System.out.println("Введите 1, если выиграла первая команда");
            System.out.println("Введите 2, если выиграла вторая команда");
            int tmp = in.nextInt();
            if (tmp == 1) {
                bag_tmp.add(item1);
            }
            if (tmp == 2) {
                bag_tmp.add(item2);
            }
        }
        search_team(n / 2, bag_tmp);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите n которое является степенью двойки ");
        int n = in.nextInt();
        Bag bag = new Bag(n);
        for (int i = 0; i < n; i++) {
            String str = "Команда " + i;
            bag.add(str);
        }
        search_team(n, bag);
    }
}