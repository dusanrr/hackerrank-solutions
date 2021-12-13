import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



class Result {

    /*
     * Complete the 'drawingEdge' function below.
     *
     * The function is expected to return an LONG.
     * The function accepts LONG n as parameter.
     */
    private static long power(long x, long n ){
        
        long mod = (long)1e9 +7;
        long ans = 1, tmp =(long) x;
        
        while(n != 0){
            tmp %= mod;
            if(n%2 == 1){
                ans *= tmp;
                ans %= mod;
            }
            
            tmp*= tmp;
            n /=2;
        }
        
        long num = (long) (ans % mod);
        return num;
    }
    public static long drawingEdge(long n) {
        long num = n * (n - 1) /2;
        return power(2, num);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.drawingEdge(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
