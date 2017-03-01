public int updateBits(int n, int m, int i, int j){

    int right = (1 << i) - 1;
    int left = ~0 << (j + 1);
    int mask = right | left;

    num = num & mask;
    m = m << i;

    return m | num;
}