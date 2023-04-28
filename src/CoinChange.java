import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoinChange {
    private List<Integer> intermediateResults = new ArrayList<>();
    private List<List<Integer>> coinLists = new ArrayList<>();

    public List<Integer> getIntermediateResults() {
        return intermediateResults;
    }

    public List<List<Integer>> getCoinLists() {
        return coinLists;
    }

    public void add(int value, List<Integer> coins) {
        intermediateResults.add(value);
        coinLists.add(coins);
    }

    public static void main(String[] args) {
        DList dList = new DList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите сумму: ");
            int sum = scanner.nextInt();

            // набор монет для выдачи
            List<Integer> coins = new ArrayList<>();
            coins.add(1);
            coins.add(2);
            coins.add(5);
            coins.add(10);
            //coins.add(5);


            int[] minCoins = new int[sum + 1];
            List<List<Integer>> combinations = new ArrayList<>();
            for (int i = 0; i <= sum; i++) {
                minCoins[i] = Integer.MAX_VALUE;
                combinations.add(new ArrayList<>());
            }
            minCoins[0] = 0;

            for (int i = 1; i <= sum; i++) {
                for (int j = 0; j < coins.size(); j++) {
                    int coin = coins.get(j);
                    if (coin <= i && minCoins[i - coin] != Integer.MAX_VALUE && minCoins[i - coin] + 1 < minCoins[i]) {
                        minCoins[i] = minCoins[i - coin] + 1;
                        List<Integer> newCombination = new ArrayList<>(combinations.get(i - coin));
                        newCombination.add(coin);
                        combinations.set(i, newCombination);
                    }
                }
            }

            dList.add(sum, combinations.get(sum));
            System.out.println("Минимальное количество монет для выдачи суммы " + sum + ": " + minCoins[sum]);
            System.out.println("Возможные комбинации монет: " + combinations.get(sum));

            System.out.println("Введите 1, чтобы продолжить, или любую другую цифру, чтобы завершить программу");
            int choice = scanner.nextInt();
            if (choice != 1) {
                break;
            }
        }
    }
}