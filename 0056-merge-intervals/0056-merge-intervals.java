class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);

        List<Integer[]> list = new ArrayList<>();
        list.add(new Integer[]{intervals[0][0], intervals[0][1]});

        for (int i = 1; i < n; i++) {
            Integer[] interval1 = list.get(list.size() - 1);
            int[] interval2 = intervals[i];
            if (interval2[0] > interval1[1]) {
                list.add(new Integer[]{interval2[0], interval2[1]});
            } else {
                interval1[1] = Math.max(interval1[1], interval2[1]);
            }
        }

        int[][] ans = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = new int[]{list.get(i)[0], list.get(i)[1]};
        }

        return ans;
    }
}