package 字符串;

/** 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 *
 * 说明
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * num1 * num2 位数最多 num1+num2
 * 假设结果为 num1+num2 位，则 num1[i]*num[j] 结果作用于结果位 i+j,i+j+1
 *
 *       1 2 3
 *       4 5 6
 * ————————————
 *         1 8
 *       1 2
 *     0 6
 * ------------
 *       1 5
 *     1 0
 *   0 5
 * ------------
 *     1 2
 *   0 8
 * 0 4
 * ------------
 * 0 1 2 3 4 5
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println((int)'1');

    }

    public static String solution(String str1, String str2) {
        int[] res = new int[str1.length() + str2.length()];
        if(str1.equals("0") || str2.equals("0"))
            return "0";
        for(int i=str1.length()-1; i>=0; i--) {
            int tmp1 = str1.charAt(i) - '0';
            for(int j=str2.length()-1; j>=0; j--) {
                int tmp2 = str2.charAt(j) - '0';
                int sum = tmp1*tmp2 + res[i+j+1];
                res[i+j+1] = sum % 10;
                res[i+j] += sum / 10;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0)
                continue;
            result.append(res[i]);
        }
        return result.toString();
    }


}


