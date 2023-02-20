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

  
  public static void main(String[] args) {
    int[][] a = new int[][] {
      {1, 2, 3},
      {4, 5, 6}, 
      {7, 8, 9}};

    int[][] b = new int[][] {
      {1, 2, 3, 4},
      {5, 6, 7, 8}};

      print2dArray(copySquare(a));
    }
  }