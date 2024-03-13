import java.util.Arrays;
import java.util.Comparator;


/**
 * A simple way to sort arrays using merge sort.
 *
 * @author Maya Flynn
 * @author Marina Ananias
 * @author Samuel A. Rebelsky
 */
public class MergeSorter {

  // +------------------+--------------------------------------------
  // | Exported methods |
  // +------------------+

  /**
   * Sort an array using the merge sort algorithm.
   */
  public static <T> void sort(T[] vals, Comparator<? super T> comparator) {
    merge(vals, 0, 2, 4, comparator);
  } // sort

  // +-----------------+---------------------------------------------
  // | Local utilities |
  // +-----------------+

  /**
   * Merge the values from positions [lo..mid) and [mid..hi) back into the same part of the array.
   *
   * Preconditions: Each subarray is sorted accorting to comparator.
   */
  static <T> void merge(T[] vals, int lo, int mid, int hi, Comparator<? super T> comparator) {
    int midnew = 0;
    T[] tempLow = Arrays.copyOfRange(vals, lo, mid);
    T[] tempHigh = Arrays.copyOfRange(vals, mid, hi + 1);
    for (int i = 0; i < hi + 1; i++) {
      if ((midnew > (hi - mid))) {
        vals[i] = tempLow[lo];
        lo++;
      } else if (lo > mid - 1) {
        vals[i] = tempHigh[midnew];
        midnew++;
      } else {
        if ((comparator.compare(tempLow[lo], tempHigh[midnew])) == -1) {
          vals[i] = tempLow[lo];
          lo++;
        } else {
          vals[i] = tempHigh[midnew];
          midnew++;
        } // sorts elements
      } // if else (if one of tempLow/tempHigh has all of is elements used) or doesn't
    } // for all the elements
  } // merge

} // class MergeSorter
