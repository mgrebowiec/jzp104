package pl.sda.mg.jav104.jzp.zad32;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class HumanService {
    private static String FILE_NAME = "human";

    public static void main(String[] args) {
        Human michal = new Human("Michal", 39);

        persistHuman(michal, "michal.dat");
        persistHuman(new Human("Janek", 30), "janek.dat");

        Human loadedHuman = loadHuman("michal.dat");
        System.out.println("name: " + loadedHuman.getName() + "; age: " + loadedHuman.getAge());

        List<Human> humans = Arrays.asList(
                new Human("darek", 20),
                new Human("Ala", 21)
        );

        persistHumans(humans, "humans.dat");

        List<Human> loadedHumans = loadHumans("humans.dat");
        System.out.println("Loaded humans: " + loadedHumans);

    }

    private static void persistHumans(List<Human> humans, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(humans);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Human> loadHumans(String fileName) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Human>) in.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void persistHuman(Human human, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(human);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Human loadHuman(String fileName) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Human) in.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
