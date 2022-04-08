package MooreTraversal;

public class Print {
    public State copy1(String [][] m, int i,int j, State parent){
        String[][] newMatrix = new String[m.length][m[0].length];
        for(int k = 0; k< m.length; k++){
            for (int l = 0; l<m[0].length; l++){
                newMatrix[k][l] = m[k][l];
            }
        }

        State newState = new State(newMatrix,i,j,parent);
        return newState;
    }

    public State copyBest(String [][] m, int i,int j,int p){
        String[][] newMatrix = new String[m.length][m[0].length];
        for(int k = 0; k<m.length; k++){
            for(int l = 0; l<m[0].length; l++){
                newMatrix[k][l] = m[k][l];
            }
        }
        State newSatate = new State(newMatrix,i,j,p);
        return newSatate;
    }

    public State copyA(String [][] m, int i,int j,int p, int ip){
        String[][] newMatrix = new String[m.length][m[0].length];
        for(int k = 0; k<m.length; k++){
            for(int l = 0; l<m[0].length; l++){
                newMatrix[k][l] = m[k][l];
            }
        }
        State newSatate = new State(newMatrix,i,j,p,ip);
        return newSatate;
    }
}
