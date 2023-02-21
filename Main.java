import java.util.Arrays;

public class Main {

  public static void print2dArray(int[][] a) {
    for (int r=0; r < a.length; r++) {
      for (int c=0; c< a[r].length; c++) {
        System.out.print(a[r][c]);
        System.out.print(" ");
      }
      System.out.println();
    }
  }

  public static int[][] copySquare(int[][] orig) {
    int[][] result =  new int[orig.length][orig[0].length];
    for (int r = 0; r < orig.length; r++) {
      for (int c = 0; c < orig.length; c++) {
        result[r][c] = orig[r][c];
      }
    }
    return result;
  }

  public static int[][] copyRectangle(int[][] orig) {
    int[][] result =  new int[orig.length][orig[0].length];
    for (int r = 0; r < orig.length; r++) {
      for (int c = 0; c < orig[0].length; c++) {
        result[r][c] = orig[r][c];
      }
    }
    return result;
  } 

  public static int[][] copyRagged(int[][] orig) {
    int[] columnLengths = new int[orig.length];
    int columnCount = 0;
    for (int r = 0; r < orig.length; r++) {
      columnCount = 0;
      for (int c = 1; c <= orig[r].length; c++) {
        columnCount++;
      }
      columnLengths[r] = columnCount;
    }
    int[][] result = new int[orig.length][];
    for (int i = 0; i < orig.length; i++) {
      result[i] = new int[columnLengths[i]];
    }
    for (int r = 0; r < orig.length; r++) {
      for (int c = 0; c < orig[r].length; c++) {
        result[r][c] = orig[r][c];
      }
    }
    return result;
  }
  
  public static void printTranspose(double[][] orig) {
    int rowL = orig[0].length;
    int nRow = orig.length;
    for (int r = 0; r < rowL; r++) {
      for (int c = 0; c<nRow; c++) {
        System.out.print(orig[c][r]);
        System.out.print(" ");
      }
      System.out.println();
    }
  }
  
  public static void main(String[] args) {
    int[][] square = new int[][] {
      {1, 2, 3},
      {4, 5, 6}, 
      {7, 8, 9}};

    int[][] rectangle = new int[][] {
      {1, 2, 3, 4},
      {5, 6, 7, 8}};

    int[][] ragged = new int[][] {
      {1, 2, 3, 4},
      {5, 6, 7},
      {8},
      {9, 10, 11, 12, 13}};
    double[][] ss = new double[][] {
      {99, 85, 98},
      {98, 57, 79},
      {92, 77, 74},
      {94, 62, 81},
      {99, 94, 92},
      {80, 76.5, 67},
      {76, 58.5, 90.5},
      {92, 66, 91},
      {77, 70.5, 66.5},
      {89, 89.5, 81}
    };
    
    // printTranspose(ss);
    print2dArray(copyRagged(ragged));
    }
  }