class MedianArrays {
    public double findMedianSortedArrays(int[] A, int[] B) {
        if (A.length > B.length)
            return findMedianSortedArrays(B, A);

        int m = A.length;
        int n = B.length;

        int left = 0;
        int right = m;

        while (left <= right) {
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;

            int Aleft = (i == 0) ? Integer.MIN_VALUE : A[i - 1];
            int Aright = (i == m) ? Integer.MAX_VALUE : A[i];

            int Bleft = (j == 0) ? Integer.MIN_VALUE : B[j - 1];
            int Bright = (j == n) ? Integer.MAX_VALUE : B[j];

            if (Aleft <= Bright && Bleft <= Aright) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(Aleft, Bleft) +
                           Math.min(Aright, Bright)) / 2.0;
                }

                return Math.max(Aleft, Bleft);
            }

            if (Aleft > Bright)
                right = i - 1;
            else
                left = i + 1;
        }

        return 0;
    }
}
