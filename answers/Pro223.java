public class Solution {
    public int computeArea(int A, int B, int C, int D,
     int E, int F, int G, int H) {
        int newXMin = Math.max(A, E);
        int newYMin = Math.max(B, F);
        int newXMax = Math.min(C, G);
        int newYMax = Math.min(D, H);
        int area1 = (D - B) * (C - A);
        int area2 = (H - F) * (G - E);
        if (newXMin < newXMax && newYMin < newYMax){
            int common = (newYMax - newYMin) * (newXMax - newXMin);
            return area1 + area2 - common;
        }
        else{
            return area1 + area2;
        }
    }
}