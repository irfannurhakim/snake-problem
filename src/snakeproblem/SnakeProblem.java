/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeproblem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author irfannurhakim
 */
public class SnakeProblem {

  /**
   * @param args the command line arguments
   * @throws java.io.IOException
   */
  public static void main(String[] args) throws IOException {
    // TODO code application logic here
    
    String fileDir = (args.length > 0) ? args[0] :  "test/test.txt" ;

    Map map = null;

    // Readfile
    try (
      BufferedReader br = new BufferedReader(new FileReader(fileDir))) {
      StringBuilder sb = new StringBuilder();
      String colsAndRows = br.readLine();
      
      // Findout cols and rows
      int rows = Integer.parseInt(colsAndRows.split(" ")[0]);
      int cols = Integer.parseInt(colsAndRows.split(" ")[1]);
      
      map = new Map(rows, cols);

      //Loop for init value
      for (int i = 0; i < rows; i++) {
        String points = br.readLine();
        for (int j = 0; j < cols; j++) {
          int point = Integer.parseInt(points.split(" ")[j]);
          map.setPoint(i, j, point);
        }
      }
      
      // Run Snake
      Snake snake = new Snake(map);
      snake.initVisitedPoint();
      
      //System.out.println(map.getPoints());
      snake.startTraverseMap(new int[]{ map.getRows(), 0 });
      System.out.println(snake.getDistanceTotal());
    }
  }
}
