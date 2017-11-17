/**
 * Created by Larry Liu on 11/15/2017.
 */
public class Pure {
    int countPairs(int[] array, int len, int diff) {
        int i = 0, j = 1, pairs = 0;
        while (j < len) {
            if (array[j] == array[i] + diff) {
                pairs++;
                i++;
            } else if (array[j] > array[i] + diff) {
                i++;
            }
            j++;
        }
        return pairs;
    }
}
