package MooreTraversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFS {

    Stack<State> stack;
    Boolean isSolution = false;
    String path = "";
    int entrancePosition;

    public DFS(String[][] lake,int i){
        entrancePosition = i;
        if(lake != null){
            stack = new Stack<>();
            stack.push(new State(lake,entrancePosition, 0,null));
            path += "("+entrancePosition+",0) ";
            traverse();
        }
        else if(!isSolution){
            System.out.println("No solution found!");
        }
        else{
            System.out.println("Couldn't find the swamp to navigate through!");
        }
    }

    void traverse() {

        Stack<State> temp = new Stack<>();
        while (!isSolution) {
            State current = stack.peek();
            int i = current.positionI;
            int j = current.positionJ;
            int count = 0;

            if (j < current.getSwamp()[0].length) {
                State state2 = new Print().copy1(current.swamp, current.positionI, current.positionJ,
                        current.parent);
                state2.positionJ++;
                if (!state2.isVisited) {
                    temp.push(state2);
                    count++;
                }
            }
            if (i < current.getSwamp().length) {
                State state3 = new Print().copy1(current.swamp, current.positionI, current.positionJ,
                        current.parent);
                state3.positionI++;
                state3.positionJ++;
                if (!state3.isVisited){
                    temp.push(state3);
                    count++;
                }
            }

                if (i > 0) {
                    State state1 = new Print().copy1(current.swamp, current.positionI, current.positionJ,
                            current.parent);
                    state1.positionI--;
                    state1.positionJ++;
                    if (!state1.isVisited) {
                        temp.push(state1);
                        count++;
                    }
                }

                if(count == 0){
                    System.out.println("You've reached a dead end! \n no solution found!");
                    break;
                }
                while (!temp.isEmpty()) {
                    State s = temp.pop();
                    int row = s.positionI;
                    int col = s.positionJ;
                    if (s.getSwamp()[row][col].equals("D")) {
                        stack.push(s);
                        s.isVisited = true;
                        s.parent = current;
                        temp.clear();
                        path += "(" + Integer.toString(row) + "," + Integer.toString(col) + ") ";
                    }
                    else if (!s.getSwamp()[row][col].equals("D") && temp.isEmpty()) {
                        stack.push(current.parent);
                        s.isVisited = true;
                    }
                    if (col == s.getSwamp()[0].length - 1 && s.getSwamp()[row][col].equals("D")) {
                        isSolution = true;
                    }
                }

        }
    }

    public String getPath(){
        return path;
    }
}
