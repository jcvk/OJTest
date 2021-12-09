package tencent;

import others.A;

import java.util.ArrayList;
import java.util.List;

public class Question17 {

    String[] letter_map = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    // 用来保存结果
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        // 当涉及到多层循环的时候，可以考虑使用递归去处理
        if (digits==null||digits.length()==0){
            return new ArrayList<>();
        }
        iterStr(digits,new StringBuilder(),0);
        return res;
    }

    void iterStr(String str,StringBuilder letter,int index){
        // 这是往下递归的终止条件
        if (index==str.length()){
            res.add(letter.toString());
            return;
        }

        char num = str.charAt(index);
        int pos = num - '0';
        String temp = letter_map[pos];
        for (int i=0;i<temp.length();i++){
            letter.append(temp.charAt(i));
            iterStr(str,letter,index+1);
            letter.deleteCharAt(letter.length()-1);
        }
    }

    public static void main(String[] args) {
        new Question17().letterCombinations1("2378");
    }

    public List<String> letterCombinations1(String digits) {
        // 当涉及到多层循环的时候，可以考虑使用递归去处理
        if (digits==null||digits.length()==0){
            return new ArrayList<>();
        }
        List<String> ress = new ArrayList<>();
        // 需要提前加入空
        ress.add("");
        for (int i=0;i<digits.length();i++){
            String letters = letter_map[digits.charAt(i)-'0'];
            // 获取当前队列的长度，主要是用于把之前的队列里面的所有元素，加上新的
            int size = ress.size();
            for (int j=0;j<size;j++){
                //
                String tem = ress.remove(0);
                for (int k=0;k<letters.length();k++){
                    ress.add(tem+letters.charAt(k));
                }
            }
        }
        return ress;
    }

}
