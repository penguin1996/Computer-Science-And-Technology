package Test.Three;

import com.Three.AnalyzeString;

public class AnalyzeStringTest {

    public static void main(String[] args) {

        String s = "a21b3dc";
        AnalyzeString analyzeString = new AnalyzeString();
        analyzeString.charAndNum(s);
        analyzeString.charAndNum2(s);
        analyzeString.ignoreCase(s);
        analyzeString.numOfCharAndNum(s);
        //analyzeString.numOfCharAndNum2(s);

        System.out.println(s.substring(2));//区间属于[index,后面所有数据)
        System.out.println(s.substring(2, 3)); //前闭后开区间
    }
}
