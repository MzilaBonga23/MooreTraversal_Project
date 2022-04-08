package MooreTraversal;

import java.util.Comparator;

public class AStarComparator implements Comparator<State> {
    @Override
    public int compare(State s1, State s2) {
        if(s1.priority < s2.priority) {
            return 1;
        }
        if(s1.priority > s2.priority) {
            return -1;
        }
        if(s1.priority == s2.priority) {
            if(s1.statePriority > s2.statePriority)
                return 1;
            if(s1.statePriority < s2.statePriority)
                return -1;
            return 0;
        }
        return 0;
    }
}
