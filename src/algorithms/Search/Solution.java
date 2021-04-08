package algorithms.Search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Solution {
ArrayList<AState> solutionPath=new ArrayList<>();


    /**
     * @return arrayList that contian the path of states of the solution that founds from the search algorithm
     */
 public ArrayList<AState> getSolutionPath()
 {
    ArrayList<AState> temp=new ArrayList<>();
     for (int i = solutionPath.size()-1; i >= 0; i--) {
         temp.add(solutionPath.get(i));
     }
     return temp;
 }

}
