package edu.cnm.deepdive;

public class MergeSorter {

  public void sort(int[] data) {
    sort( data, 0, data.length );
  }


  public void sort(int[] data, int from, int to) {
    if (to - from <= 1) {
      return;
    }
    int midpoint = (from + to) / 2;
    sort( data, from, midpoint );
    sort( data, midpoint, to );
    merge( data, from, to, midpoint );
  }

  private void merge(int[] data, int from, int to, int midpoint) {
    int[] merged = new int[to - from];
    int leftIndex = from;
    int rightIndex = midpoint;
    int mergedIndex = 0;
    while (leftIndex < midpoint && rightIndex < to) {
      int leftValue = data[leftIndex];
      int rightValue = data[rightIndex];
      if (leftValue <= rightValue) {
        merged[mergedIndex] = leftValue;
        leftIndex++;
      } else {
        merged[mergedIndex] = rightValue;
        rightIndex++;
      }
      mergedIndex++;
    }
    if (leftIndex < midpoint) {
      System.arraycopy( data, leftIndex, merged, mergedIndex, midpoint - leftIndex );
    } else {
      System.arraycopy( data, rightIndex, merged, mergedIndex, to - rightIndex );
    }
    System.arraycopy( merged, 0, data, from, merged.length );
  }

}
