public class CharFrequency {
    public static void main(String[] args) {
        String s = "aabbccdd";
        int[] freq = new int[256];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i)] != 0) {
                System.out.println(s.charAt(i) + " : " + freq[s.charAt(i)]);
                freq[s.charAt(i)] = 0;
            }
        }
    }
}
