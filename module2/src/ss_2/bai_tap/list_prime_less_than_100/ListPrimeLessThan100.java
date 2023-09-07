package ss_2.bai_tap.list_prime_less_than_100;

public class ListPrimeLessThan100 {
    public static void main(String[] args) {
        System.out.println("List 100 prime number less than 100 is: ");
        for (int n = 2; n < 100; n++) {
            if (checkPrime(n)) {
                System.out.println(n);
            }
        }
    }

    public static boolean checkPrime(int number) {
        boolean check = true;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                check = false;
                break;
            }
        }
        if (check) {
            return true;
        } else {
            return false;
        }
    }
}
