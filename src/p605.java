/**
 * Created by Larry Liu on 11/13/2017.
 * 605. Can Place Flowers
 */
public class p605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if ((i == 0 || flowerbed[i-1] == 0) &&
                        (i == flowerbed.length-1 || flowerbed[i+1] == 0)) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
            if (n == 0) return true;
        }
        return false;
    }
}
