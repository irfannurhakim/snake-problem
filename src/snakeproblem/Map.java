/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeproblem;

/**
 *
 * @author irfannurhakim
 */
public class Map {

  private int[][] area;
  private int cols = 0;
  private int rows = 0;

  public Map(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
    this.area = new int[rows][cols];
  }

  public int getCols() {
    return cols - 1;
  }

  public int getRows() {
    return rows - 1;
  }

  public void setPoint(int row, int col, int point) {
    try {
      area[row][col] = point;
    } catch (Exception e) {
      System.out.println("Exception :" + e.toString());
    }
  }

  public int getPoint(int row, int col) {
    int point = 0;
    try {
      point = area[row][col];
    } catch (Exception e) {
      System.out.println("Exception :" + e.toString());
    }

    return point;
  }

  public int[] getCoordinate() {
    return null;
  }

  public String getPoints() {
    String points = rows + " " + cols + "\n";

    for (int i = 0; i < rows; i++) {
      String point = "";
      for (int j = 0; j < cols; j++) {
        point = point + " " + this.getPoint(i, j);
      }
      points = points + point + "\n";
    }

    return points;
  }
}
