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
public class Main {

  /**
   * @param args the command line arguments
   * @throws java.io.IOException
   */
  public static void main(String[] args) throws IOException {
    
    // Get filepath argument
    String fileDir = (args.length > 0) ? args[0] :  "test/test.txt" ;

    Map map;

    // Attemp for read file, throw an exception if file doesn't exist
    try (
      BufferedReader br = new BufferedReader(new FileReader(fileDir))) {
      StringBuilder sb = new StringBuilder();
      String colsAndRows = br.readLine();
      
      // Findout cols and rows
      int rows = Integer.parseInt(colsAndRows.split(" ")[0]);
      int cols = Integer.parseInt(colsAndRows.split(" ")[1]);
      
      // Assign row and col to map object
      map = new Map(rows, cols);

      // Assign value for each point
      for (int i = 0; i < rows; i++) {
        String points = br.readLine();
        for (int j = 0; j < cols; j++) {
          int point = Integer.parseInt(points.split(" ")[j]);
          map.setPoint(i, j, point);
        }
      }
      
      // Run Snake
      Snake snake = new Snake(map);
      
      // Initialize Visited Point
      snake.initVisitedPoint();
      
      // Make snake object to Start traversing Map
      snake.startTraverseMap(new int[]{ map.getRows(), 0 });
      
      // Print the result
      System.out.println(snake.getDistanceTotal());
    }
  }
}
