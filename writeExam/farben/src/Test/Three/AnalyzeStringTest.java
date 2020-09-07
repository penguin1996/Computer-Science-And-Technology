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
    }
}
