public class RemoveSpecial {
    public static void main(String[] args) {
        String s = "Ja@va#123!";
        System.out.println(s.replaceAll("[^a-zA-Z0-9]", ""));
    }
}
