class Solution {
public:
    int singleNumber(int A[], int n) {
        int one,two,three;
        one=two=three=0;
        for(int i=0;i<n;i++)
        {
            // Already appeared twice
            three =  two & A[i];
            // Appeard twice add circumstances
            //  when appeared once and in A[i] there is another
            two = two | one & A[i];
            // Appeared once
            one = one | A[i];
            // When already appeared for the 3rd time,
            //  clear one and two
            one = one & ~three;
            two = two & ~three;
        }
         return one;
    }
};