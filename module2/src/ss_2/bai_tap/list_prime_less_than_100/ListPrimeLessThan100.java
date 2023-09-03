package ss_2.bai_tap.list_prime_less_than_100;

public class ListPrimeLessThan100 {
    public static void main(String[] args) {
        System.out.println("List 100 prime number less than 100 is: ");
        int n = 2;
        while (n < 100) {
            boolean check = checkPrime(n);
            if (check) {
                System.out.println(n);
            }
            n++;
        }
    }

    public static boolean checkPrime(int number) {
        boolean check = true;
        int i = 2;
        while (i <= number / 2) {
            if (number % i == 0) {
                check = false;
                break;
            }
            i++;
        }
        if (check) {
            return true;
        } else {
            return false;
        }
    }
}
