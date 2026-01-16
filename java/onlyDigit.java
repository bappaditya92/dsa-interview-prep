public class OnlyDigits {
    public static void main(String[] args) {
        String s = "12345";
        boolean isDigit = true;

        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                isDigit = false;
                break;
            }
        }
        System.out.println(isDigit);
    }
}
