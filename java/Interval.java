import java.util.*;

class Interval {

    public int start;
    public int end;

    public Interval(int start,
                    int end) {

        this.start = start;
        this.end = end;
    }
}

class Solution {

    public List<Interval> employeeFreeTime(
            List<List<Interval>> schedule) {

        List<Interval> all =
                new ArrayList<>();

        for (List<Interval> emp :
                schedule) {

            all.addAll(emp);
        }

        all.sort(
                (a, b) -> a.start - b.start
        );

        List<Interval> result =
                new ArrayList<>();

        Interval prev = all.get(0);

        for (int i = 1;
             i < all.size();
             i++) {

            Interval curr = all.get(i);

            if (curr.start > prev.end) {

                result.add(
                        new Interval(
                                prev.end,
                                curr.start
                        )
                );

                prev = curr;

            } else {

                prev.end =
                        Math.max(
                                prev.end,
                                curr.end
                        );
            }
        }

        return result;
    }
}
