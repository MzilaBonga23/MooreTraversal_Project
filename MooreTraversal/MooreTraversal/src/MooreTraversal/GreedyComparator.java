package MooreTraversal;

import java.util.Comparator;

public class GreedyComparator implements Comparator<State> {

    @Override
    public int compare(State s1, State s2) {
        int sol =0;
        if(s1.priority < s2.priority) {
            sol = 1;
        }
        if(s1.priority > s2.priority) {
            sol = -1;
        }
        return sol;
    }

}
