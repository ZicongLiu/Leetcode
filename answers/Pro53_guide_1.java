for(int i = 1; i <= n; i++){
    for(int j = i; j <= n; j++){
        int sum = 0;
        for(int k = i; k <= j; k++)
            sum += a[k];
        max = Max(max, sum);
    }
}