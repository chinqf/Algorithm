package 深度优先和广度优先;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** 最小基金变化
 * 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
 * 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
 * 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
 * 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
 * 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
 *
 * 注意:
 * 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
 * 所有的目标基因序列必须是合法的。
 * 假定起始基因序列与目标基因序列是不一样的。
 *
 * 示例 1:
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 * 返回值: 1
 *
 * 示例 2:
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 * 返回值: 2
 *
 * 示例 3:
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 * 返回值: 3
 */

public class MinimumGeneticMutation {
    public static void main(String[] args) {
        String start =  "AACCGGTT";
        String end = "AAACGGTA";
        String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        System.out.println(minMutation(start, end, bank));
    }

    static int minStepCount = Integer.MAX_VALUE;
    public static int minMutation(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<>();
        dfs(set, 0, start, end, bank);
        return minStepCount;
    }

    /**
     *
     * @param strs       已经遍历过的bank[]中的
     * @param stepCount  经过的步数
     * @param current    当前字符串
     * @param target     目标字符串
     * @param bank       基因库
     */
    public static void dfs(HashSet<String> strs, int stepCount, String current, String target, String[] bank) {
        // 1. 递归终止条件
        if (current.equals(target)) {
            minStepCount = Math.min(minStepCount, stepCount);
        }
        // 2. 找到跟当前字符串只差一个字母的，然后继续往下
        for(String str: bank) {
            int diff = 0;
            for(int i=0; i<str.length(); i++) {
                if(current.charAt(i)!=str.charAt(i))
                    if(++diff>1) break;
            }
            if(diff==1&&!strs.contains(str)) {
                strs.add(str);
                dfs(strs, stepCount+1, str, target, bank);
                strs.remove(str);
            }
            Map list = null;

        }
    }

}
