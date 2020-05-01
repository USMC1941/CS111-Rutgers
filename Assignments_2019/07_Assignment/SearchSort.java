public class SearchSort {

   public static int binarySearch(char[] chars, char target) {
      int left  = 0;
      int right = chars.length - 1;

      while (left <= right) {
         int middle = (left + right) / 2;
         if (chars[middle] == target) {
            return middle;
         }
         else if (target < chars[middle]) {
            right = middle - 1;
         }
         else {
            left = middle + 1;
         }
      }
      return -1;  // target not found
   }

   public static void selectionSort(char[] chars) {
      int n = chars.length;
      for (int i = 0; i < n; i++) {
         int min = i;
         for (int j = i + 1; j < n; j++) {
            if (chars[j] < chars[min]) {
               min = j;
            }
         }
         exchange(chars, i, min);
      }
   }

   public static void insertionSort(char[] chars) {
      int n = chars.length;
      for (int i = 1; i < n; i++) {
         for (int j = i; j > 0; j--) {
            if (chars[j - 1] > chars[j]) {
               exchange(chars, j - 1, j);
            }
            else {
               break;
            }
         }
      }
   }

   private static void exchange(char[] chars, int i, int j) {
      // exchange the value at index i with the value at index j
      char temp = chars[i];
      chars[i] = chars[j];
      chars[j] = temp;
   }

   public static void mergesort(char[] chars, int l, int r) {
      if (l >= r) {
         return;
      }
      int middle = (l + r) / 2;
      mergesort(chars, l, middle);
      mergesort(chars, middle + 1, r);
      merge(chars, l, middle, r);
   }

   public static void merge(char[] chars, int l, int m, int r) {
      //copy lower half of the array into b
      char[] b = new char[m - l + 1];
      for (int i = 0; i < m - 1; i++) {
         b[i] = chars[i + 1];
      }
      int i = 0, j = m + 1, k = l;
      while (i <= m - l && j <= r) {
         if (chars[j] < b[i]) {
            chars[k] = chars[j];
            k += 1;
            j += 1;
         }
         else {
            chars[k] = b[i];
            k += 1;
            i += 1;
         }
      }
      while (i <= m - l) {
         chars[k] = b[i];
         k += 1;
         i += 1;
      }
      while (j <= r) {
         chars[k] = chars[j];
         k += 1;
         j += 1;
      }
   }
}