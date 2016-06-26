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
public class TraverseResult {
  
  private int point = 0;
  private int[] coordinate = new int[2];
  private boolean canGoThrough = false;
  private boolean endOfRoute = false;
  private boolean isTeleported = false;
  
  public TraverseResult(int point, int[] coordinate, boolean canGoThrough, boolean endOfRoute, boolean isTeleported){
    this.point = point;
    this.coordinate = coordinate;
    this.canGoThrough = canGoThrough;
    this.endOfRoute = endOfRoute;
    this.isTeleported = isTeleported;
  }

  public void setPoint(int point) {
    this.point = point;
  }

  public void setCoordinate(int[] coordinate) {
    this.coordinate = coordinate;
  }

  public void setCanGoThrough(boolean canGoThrough) {
    this.canGoThrough = canGoThrough;
  }

  public void setEndOfRoute(boolean endOfRoute) {
    this.endOfRoute = endOfRoute;
  }

  public void setIsTeleported(boolean isTeleported) {
    this.isTeleported = isTeleported;
  }

  public int getPoint() {
    return point;
  }

  public int[] getCoordinate() {
    return coordinate;
  }

  public boolean isCanGoThrough() {
    return canGoThrough;
  }

  public boolean isEndOfRoute() {
    return endOfRoute;
  }

  public boolean isIsTeleported() {
    return isTeleported;
  }
  
}
