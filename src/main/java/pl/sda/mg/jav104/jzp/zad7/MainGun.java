package pl.sda.mg.jav104.jzp.zad7;

public class MainGun {
    public static void main(String[] args) {
        Gun gun = new Gun(4);

        gun.loadBullet("pierwsza");
        gun.loadBullet("druga");
        gun.loadBullet("trzecia");
        gun.loadBullet("czwarta");

        System.out.println("Czy pistolet zaladowany: " + gun.isLoaded());
        gun.loadBullet("piaty");

        gun.shot();
        gun.shot();
        gun.shot();
        gun.shot();

        System.out.println("Czy pistolet zaladowany: " + gun.isLoaded());

        gun.shot();
    }
}
