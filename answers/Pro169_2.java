public int majorityElement(int[] num) {
    int ret = 0;
    for (int i = 0; i < 32; i++) {
        int ones = 0, zeros = 0;
        for (int j = 0; j < num.length; j++) {
            if ((num[j] & (1 << i)) != 0) {
                ++ones;
            }
            else
                ++zeros;
        }

        if (ones > zeros)
            ret |= (1 << i);
    }
    return ret;
}