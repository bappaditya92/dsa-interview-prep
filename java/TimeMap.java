class TimeMap {

    Map<String, List<Pair>> map = new HashMap<>();

    class Pair {
        String value;
        int time;

        Pair(String v, int t) {
            value = v;
            time = t;
        }
    }

    public void set(String key, String value, int timestamp) {
        map
