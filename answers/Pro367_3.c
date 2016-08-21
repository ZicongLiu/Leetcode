class Solution {
public:
    bool isPerfectSquare(int n) {
        float diff;
        float x, x_prev = n;
        do{
            x = x_prev - (x_prev*x_prev - n)/(2*x_prev);
            diff = x_prev - x;
            x_prev = x;
        } 
        while(diff>=1);
        // if n is a perfect square, its square root must be the floor of x
        x = (int) x;
        if (x*x == n)
            return true;
        else 
            return false;
        
    }
};