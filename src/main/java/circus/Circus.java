package circus;

import circus.animal.*;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;

import java.util.ArrayList;
import java.util.Arrays;

import static circus.animal.Animal.AnimalNameComparator;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly"),
            new Tiger("Tai Lung")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("Number of animals in array: " + animals.length);
        //animals[3] = new Elephant("Ellie");       //this doesn't work
        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));

        printAllAnimals(animalArrayList);

        Elephant ellie = new Elephant("Ellie");
        animalArrayList.add(ellie);

        Duck ducky = new Duck("Ducky");
        animalArrayList.add(ducky);

        printAllAnimals(animalArrayList);
        System.out.println("Size of animal array list: " + animalArrayList.size());

        System.out.println("Ellie is in position: " + (animalArrayList.indexOf(ellie)+1));

        animalArrayList.sort(AnimalNameComparator);

        System.out.println("After sorting:");
        printAllAnimals(animalArrayList);

        /*makeAnimalsTalk();
        System.out.println("Total value of animals " + calculateAssetValue(animals));
        System.out.println("Total value of equipments " + calculateAssetValue(equipments));*/
    }

    private static void printAllAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal animal : animalArrayList) {
            System.out.println(animal);
        }
    }
}
