package src.com.TWO;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

public class StackClose {

    public int loadTheArk(Collection<com.TWO.Boy> canditates) {
        SortedSet<com.TWO.Boy> boys;
        int numPairs = 0;
        com.TWO.Boy canditate = null;

        //boys被封闭在方法中，不要使它们逃逸
        boys = new TreeSet<com.TWO.Boy>();
        boys.addAll(canditates);
        for(com.TWO.Boy boy : boys){
            if(canditate == null) {
                canditate = boy;
            }else {
                ++numPairs;
            }
        }
        return numPairs;
    }
}
