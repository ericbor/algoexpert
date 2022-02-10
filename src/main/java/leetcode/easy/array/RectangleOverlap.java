package leetcode.easy.array;

//https://leetcode.com/problems/rectangle-overlap
public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean noOverlap =
            rec1[0] >= rec2[2] ||
                rec2[0] >= rec1[2] ||
                rec1[1] >= rec2[3] ||
                rec2[1] >= rec1[3];

        return !noOverlap;
    }
}
