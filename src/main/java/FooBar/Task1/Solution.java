//https://foobar.withgoogle.com/
package FooBar.Task1;

public class Solution {
    public static String solution(int i) {
        String id = "";
        int prime = 2, index = -1;
        String primeStr = String.valueOf(prime);

        while(index != i-1){
            if (i > index + primeStr.length()) {
                index += primeStr.length();
                prime = nextPrime(prime);
                primeStr = String.valueOf(prime);
            } else {
                while(index != i-1){
                    primeStr = primeStr.substring(1);
                    index++;
                }
                break;
            }
        }
        for(int j=0; j<5; j++){
            id += primeStr.charAt(0);
            primeStr = primeStr.substring(1);
            if(primeStr.length() == 0){
                prime = nextPrime(prime);
                primeStr = String.valueOf(prime);
            }
        }
        return id;
    }

    private static int nextPrime(int n) {
        if(n==2) return n+1;
        else{
            n = n+2;
            boolean found = isPrime(n);
            while(found != true){
                n = n+2;
                found = isPrime(n);
            }
            return n;
        }
    }

    static boolean isPrime(int n)
    {
        // Corner cases
        if (n <= 1) return false;
        if (n <= 3) return true;

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(10000));
    }
}
