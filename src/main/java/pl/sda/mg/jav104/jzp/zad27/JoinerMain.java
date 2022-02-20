package pl.sda.mg.jav104.jzp.zad27;

public class JoinerMain {
    public static void main(String[] args) {
        Joiner<Integer> joiner = new Joiner<>("=");
        String result = joiner.join(1,2,3,4,4);
        System.out.println(result);
    }
}
