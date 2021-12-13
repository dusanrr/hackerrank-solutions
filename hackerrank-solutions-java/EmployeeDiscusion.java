import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'processLogs' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY logs
     *  2. INTEGER threshold
     */

    public static List<String> processLogs(List<String> logs, int threshold) {
        // Write your code here
        if (logs == null || logs.size() == 0) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();
        Map<String, Integer> id2Tran = new HashMap<>();

        for (int i = 0; i < logs.size(); i++) {
            String log = logs.get(i);
            String[] logArr = log.split(" ");
            String id1 = logArr[0];
            String id2 = logArr[1];

            if (id1.equals(id2)) {
                id2Tran.put(id1, id2Tran.getOrDefault(id1, 0) + 1);
            } else {
                id2Tran.put(id1, id2Tran.getOrDefault(id1, 0) + 1);
                id2Tran.put(id2, id2Tran.getOrDefault(id2, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> e : id2Tran.entrySet()) {
            if (e.getValue() >= threshold) {
                result.add(e.getKey());
            }
        }

        result.sort(Comparator.comparingInt(Integer::valueOf));
        return result;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int logsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> logs = IntStream.range(0, logsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int threshold = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> result = Result.processLogs(logs, threshold);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}