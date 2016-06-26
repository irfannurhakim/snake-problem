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
public class Snake {

  private Map map;
  private int distanceTotal = 0;
  private boolean[][] visitedPoint = null;

  public Snake(Map map) {
    this.map = map;
    this.visitedPoint = new boolean[map.getRows() + 1][map.getCols() + 1];
  }

  public void initVisitedPoint() {
    for (int i = 0; i <= map.getRows(); i++) {
      for (int j = 0; j <= map.getCols(); j++) {
        this.visitedPoint[i][j] = false;
      }
    }
  }

  public int getDistanceTotal() {
    return this.distanceTotal;
  }

  public TraverseResult goUp(int row, int col) {
    TraverseResult traverseResult = new TraverseResult(-1, new int[]{0, 0}, false, false, false);
    int point;
    int nextY = map.getRows();

    if (row == 0) {
      traverseResult.setIsTeleported(true);
    } else {
      nextY = row - 1;
      traverseResult.setIsTeleported(false);
    }

    if (!visitedPoint[nextY][col]) {
      point = map.getPoint(nextY, col);

      if (col == map.getCols() && row == 0) {
        traverseResult.setEndOfRoute(true);
      } else {
        traverseResult.setEndOfRoute(false);
      }

      if (point == -1) {
        traverseResult.setCanGoThrough(false);
      } else {
        traverseResult.setCanGoThrough(true);
      }

      traverseResult.setPoint(point);
      traverseResult.setCoordinate(new int[]{nextY, col});
    }

    return traverseResult;
  }

  public TraverseResult goDown(int row, int col) {
    TraverseResult traverseResult = new TraverseResult(-1, new int[]{0, 0}, false, false, false);
    int point;
    int nextY = 0;

    if (row == map.getRows()) {
      traverseResult.setIsTeleported(true);
    } else {
      nextY = row + 1;
      traverseResult.setIsTeleported(false);
    }

    if (!visitedPoint[nextY][col] && col != map.getCols()) {
      point = map.getPoint(nextY, col);

      if (col == map.getCols() && row == 0) {
        traverseResult.setEndOfRoute(true);
      } else {
        traverseResult.setEndOfRoute(false);
      }

      if (point == -1) {
        traverseResult.setCanGoThrough(false);
      } else {
        traverseResult.setCanGoThrough(true);
      }

      traverseResult.setPoint(point);
      traverseResult.setCoordinate(new int[]{nextY, col});
    }

    return traverseResult;
  }

  public TraverseResult goRight(int row, int col) {
    TraverseResult traverseResult = new TraverseResult(-1, new int[]{0, 0}, false, false, false);

    if (col != map.getCols()) {

      if (!visitedPoint[row][col + 1]) {
        int point = map.getPoint(row, col + 1);

        if (point == -1) {
          traverseResult.setCanGoThrough(false);
        } else {
          traverseResult.setCanGoThrough(true);
        }

        traverseResult.setIsTeleported(false);
        traverseResult.setPoint(point);
        traverseResult.setCoordinate(new int[]{row, col + 1});
      }

    }

    return traverseResult;
  }

  public TraverseResult getNextCoordinate(int row, int col) {
    TraverseResult nextTop = new TraverseResult(-1, new int[]{0, 0}, false, false, false);

    if (row > 0) {
      nextTop = goUp(row, col);
    }

    TraverseResult nextRight = goRight(row, col);
    TraverseResult nextBottom = goDown(row, col);

    TraverseResult[] traverseResults = new TraverseResult[]{nextTop, nextRight, nextBottom};
    int maxPoint = 0;
    int maxIdx = 0;

    for (int i = 0; i < traverseResults.length; i++) {
      if (traverseResults[i].getPoint() > maxPoint) {
        maxPoint = traverseResults[i].getPoint();
        maxIdx = i;
      }
    }

    return traverseResults[maxIdx];
  }

  public void startTraverseMap(int[] startCoordinate) {
    TraverseResult traverseResult;

    distanceTotal = map.getPoint(startCoordinate[0], startCoordinate[1]);
    visitedPoint[startCoordinate[0]][startCoordinate[1]] = true;

    do {
      traverseResult = getNextCoordinate(startCoordinate[0], startCoordinate[1]);

      startCoordinate = traverseResult.getCoordinate();
      visitedPoint[startCoordinate[0]][startCoordinate[1]] = true;

      if (!traverseResult.isCanGoThrough()) {
        distanceTotal = -1;
        break;
      }

      if (traverseResult.isIsTeleported()) {
        distanceTotal = 0;
      }

      distanceTotal += traverseResult.getPoint();

      if (startCoordinate[0] == 0 && startCoordinate[1] == map.getCols()) {
        break;
      }
    } while (!traverseResult.isEndOfRoute());

  }

}
