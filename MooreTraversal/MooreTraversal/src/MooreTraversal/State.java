package MooreTraversal;

public class State {
    public String [][] swamp;
    public int positionI;
    public int positionJ;
    int priority;
    int statePriority;
    boolean isVisited;
    State parent;

    public State(String[][] lake, int i, int j, State p){
        swamp = lake;
        positionI = i;
        positionJ = j;
        isVisited = false;
        parent = p;
    }
    public State(String[][] lake, int i, int j, int priority){
        swamp = lake;
        positionI = i;
        positionJ = j;
        this.priority = priority;

    }
    public State(String[][] lake, int i, int j, int priority,int sPriority){
        swamp = lake;
        positionI = i;
        positionJ = j;
        this.priority = priority;
        statePriority = sPriority;
    }

    public State(String[][] lake){
        this.swamp = lake;
    }

    public String[][] getSwamp(){
        return swamp;
    }
}
