import java.util.Arrays;

public class Main {

  public static void print2dArray(double[][] a) {
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
      for (int c = 0; c < nRow; c++) {
        System.out.print(orig[c][r]);
        System.out.print(" ");
      }
      System.out.println();
    }
  }

  public static double[][] withWeightedAverage(double[][] nums, double[] weights) {
    int nRows = nums.length;
    int nCols = nums[0].length;
    double[][] result = new double[nums.length+1][nums[0].length+1];
    for (int r = 0; r < nums.length; r++) {
      for (int c = 0; c < nums[0].length; c++) {
        result[r][c] = nums[r][c];
      }
    }
    double[][] weightedNums = new double[nums.length][nums[0].length];
    for (int r = 0; r < nums[0].length; r++) {
      for (int c = 0; c < nums.length; c++) {
        weightedNums[c][r] = nums[c][r] * weights[r];
      }
    }
    double rowTotal = 0;
    for (int r = 0; r < weightedNums.length; r++) {
      rowTotal = 0;
      for (int c = 0; c < weightedNums[r].length; c++) {
        rowTotal = rowTotal + weightedNums[r][c];
      }
      result[r][nCols] =  rowTotal;
    }
    for (int r = 0; r < result[0].length; r++) {
      rowTotal = 0;
      for (int c = 0; c < result.length; c++) {
        rowTotal = rowTotal + result[c][r];
      }
      result[nRows][r] = rowTotal / nums.length;
    }
    double lastColTotal = 0;
    for (int r = 0; r < result.length; r++) {
      lastColTotal = lastColTotal + result[r][result[r].length-1];
    }
    result[result.length-1][result[0].length-1] = lastColTotal / nums.length;
    return result;
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
    double[] weights = { 0.25, 0.25, 0.50 };
    
    print2dArray(withWeightedAverage(ss, weights));
    }
  }