class MaxGroups {
    public int maximumGroups(int[] grades) {
        int left = 0, right = grades.length;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (mid * (mid + 1) / 2 <= grades.length)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return right;
    }
}
