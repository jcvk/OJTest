package tencent;

import java.util.ArrayList;
import java.util.List;

public class Question6 {

    public String convert(String s, int numRows) {
        if (numRows<2) return s;
        List<StringBuffer> rows = new ArrayList<>();
        for (int i = 0;i<numRows;i++){
            rows.add(new StringBuffer());
        }
        int i=0,flag = -1;
        // 涉及到z字形的打印，都用flag来增加或者删除，然后确认flag转向的判断条件就行了
        for (char c:s.toCharArray()){
            rows.get(i).append(c);
            if (i==0||i==numRows-1) flag= -flag;
            i+=flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuffer row : rows) {
            res.append(row);
        }
        return res.toString();

    }
}
