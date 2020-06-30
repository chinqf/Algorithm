package leetcode.editor.cn;

/** Z字形变换
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 *
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 *
 * 示例 2:
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * Related Topics 字符串
 */
public class P6_ZigzagConversion{
  public static void main(String[] args) {
       Solution solution = new P6_ZigzagConversion().new Solution();
      System.out.println(solution.convert("LEETCODEISHIRING", 5));
  }
  
  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
      public String convert(String s, int numRows) {
          if (s.length() <= numRows || s==null || numRows <= 1) {
              return s;
          }
          StringBuffer res = new StringBuffer();
          int d1 = 2*numRows - 2;
          int d2 = 0;
          for(int i=0; i<numRows; i++) {
              int index = i;
              int flag = 0;
              res.append(s.charAt(index));
              while(index < s.length()) {
                  if (flag == 0) {
                      index += d1;
                      flag = 1;
                      if (d1 != 0 && index < s.length()) {
                          res.append(s.charAt(index));
                      }
                  } else {
                      index += d2;
                      flag = 0;
                      if (d2 != 0 && index < s.length()){
                          res.append(s.charAt(index));
                      }
                  }
              }
              d1 = d1 - 2;
              d2 = d2 + 2;
          }
          return res.toString();
      }
  }
  //leetcode submit region end(Prohibit modification and deletion)

}