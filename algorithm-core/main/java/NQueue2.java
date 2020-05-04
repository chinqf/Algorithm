import java.util.*;

public class NQueue2 {

    public static void main(String[] args) {
        NQueue2 test = new NQueue2();
        List<List<String>> lists = test.solveNQueens(4);
        System.out.println(lists);
    }

    // 之前的皇后所能攻击的位置
    Set<Integer> cols = new HashSet<>();
    Set<Integer> pies = new HashSet<>();
    Set<Integer> nas = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return new ArrayList<>();


        }

        List<List<String>> result = new LinkedList<>();

        // init
        List<String> currentStatus = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            currentStatus.add(init(n));
        }

        process(0, result, n, currentStatus);
        return result;
    }

    /**
     *
     * @param row        当前层
     * @param result    最终的结果
     * @param n         总层数
     * @param currentStatus
     */
    private void process(int row, List<List<String>> result, int n, List<String> currentStatus) {
        // 1. recursion terminator
        if (row == n) {
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ans.add(currentStatus.get(i));
            }
            result.add(ans);
            return;
        }

        // 2. process logic in current level
        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || pies.contains(col + row) || nas.contains(col - row)) { // go die
                continue;
            }
            // update the flag
            cols.add(col);
            pies.add(col + row);
            nas.add(col - row);

            String newLine = updateLine(col, currentStatus.get(row));
            currentStatus.set(row, newLine);

            // 3. drill down （调用函数去做子问题）
            process(row + 1, result, n, currentStatus);

            // 4. revert the current level status if needed
            cols.remove(col);
            pies.remove(col + row);
            nas.remove(col - row);

        }
    }

    public String init(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(".");
        }
        return sb.toString();
    }

    public String updateLine(int col, String line) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            if (i == col) {
                sb.append("Q");
            } else {
                sb.append(".");
            }
        }
        return sb.toString();
    }
}
