package tencent;

import java.util.ArrayList;
import java.util.List;

public class Question22 {

    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) return res;
        dfs("", n, n);
        return res;
    }

    private void dfs(String curStr, int left, int right) {

        if (left == 0 && right == 0) {
            // 到达叶子节点了
            res.add(curStr);
            return;
        }

        // 进行剪枝
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(curStr + "(", left - 1, right);
        }

        if (right > 0) {
            dfs(curStr + ")", left, right - 1);
        }

    }
}
