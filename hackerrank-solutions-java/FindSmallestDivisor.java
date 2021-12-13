import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



class Result {

    /*
     * Complete the 'findSmallestDivisor' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     */

    public static int findSmallestDivisor(String s, String t) {
        if(s.length() % t.length() > 0)
            return -1;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i*t.length() < s.length(); i++) {
            sb.append(t);
        }
        if(!sb.toString().equals(s))
            return -1;
            
        int divisible = 1;
        
        for(int i=1;i<=t.length();i++) {
            
            if(t.length() % divisible++ != 0) {
                continue;
            }
            
            sb = new StringBuilder();
            String subStr = t.substring(0, i);
            while(sb.length() < t.length()) {
                sb.append(subStr);
            }
            if(sb.toString().equals(t))
                return i;
        }
        return -1;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String t = bufferedReader.readLine();

        int result = Result.findSmallestDivisor(s, t);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
