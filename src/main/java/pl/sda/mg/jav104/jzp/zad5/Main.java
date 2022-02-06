package pl.sda.mg.jav104.jzp.zad5;

public class Main {

    public static void main(String[] args) {
        SdaHashSet myList = new SdaHashSet();
        myList.add("pierwszy");
        myList.add("piaty");
        myList.add("drugi");
        myList.add("czwarty");
        System.out.println(myList);
        System.out.println("--------------------------");
        myList.printMyElements();
    }
}
