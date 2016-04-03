for(int i = 1; i <= n; i++){
    int sum = 0;
    for(int j = i; j <= n; j++){
        sum += a[j];
        max = Max(max, sum);
    }
}