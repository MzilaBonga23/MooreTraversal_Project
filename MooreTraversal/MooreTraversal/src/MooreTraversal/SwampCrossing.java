package MooreTraversal;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SwampCrossing {
    int initialRow;
    int row;
    int col;
    String [][] matrix;
    Scanner input  = new Scanner(System.in);

    public static void main(String[] args) throws IOException{
        SwampCrossing sc = new SwampCrossing();
        sc.readFile();

        System.out.println("Please select the algorithm of your choice from the ones given bellow. e.g 1");
        System.out.println("1.Breadth-First search \n2.Depth-First Search \n3.Best-First Search\n" +
                "4.A-Star search");
        System.out.print("Enter the number of search algorithm: ");
        int searchAlg = new  Scanner(System.in).nextInt();
        System.out.println();

        switch (searchAlg){
            case 1:
                BFS bfs = new BFS(sc.matrix, sc.initialRow);
                System.out.println("The path is: \n"+bfs.getPath());
                break;

            case 2:
                DFS dfs = new DFS(sc.matrix, sc.initialRow);
                System.out.println("The path is: \n"+dfs.getPath());
                break;

            case 3:
                BestFirst bestFirst = new BestFirst(sc.matrix, sc.initialRow);
                System.out.println("The path is: \n"+bestFirst.getPath());
                break;

            case 4:
                AStar aStar = new AStar(sc.matrix, sc.initialRow);
                System.out.println("The path is: \n"+aStar.getPath());
                break;
            default:
                System.out.println("incorrect input!");
        }

    }
    public SwampCrossing(){
        System.out.print("Please enter the starting left-end row if the swamp: ");
        initialRow = input.nextInt();
        System.out.println();
        initialRow = initialRow-1;
    }
    public void readFile() throws IOException {
        System.out.print("Please enter the file path, without the txt extension: ");
        String fileName = input.next();
        System.out.println();
        File file  = new File( fileName+".txt");
        Scanner read = new Scanner(file);
        int i = 0;
        row = read.nextInt();
        col = read.nextInt();
        matrix = new String[row][col];
        read.nextLine();
        while(read.hasNext()){
            String line = read.nextLine();
            line = line.replaceAll("\\s","");
            char[] ch = line.toCharArray();
            for(int j = 0;j<ch.length; j++){
                matrix[i][j] = String.valueOf(ch[j]);
            }
            i++;
        }
        read.close();


    }

}
