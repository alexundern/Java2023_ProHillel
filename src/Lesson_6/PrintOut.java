package Lesson_6;

import java.util.Scanner;

public class PrintOut {
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                Dog dogMessy = new Dog();
                System.out.print("Enter the ran distance for dog Messy: ");
                int dogMessyDistance = scanner.nextInt();
                dogMessy.run(dogMessyDistance);

                System.out.print("Enter the swim distance for dog Messy: ");
                int dogMessySwimDistance = scanner.nextInt();
                dogMessy.swim(dogMessySwimDistance);

                Dog dogBuch = new Dog();
                System.out.print("Enter the ran distance for dog Buch: ");
                int dogBuchDistance = scanner.nextInt();
                dogBuch.run(dogBuchDistance);

                System.out.print("Enter the swim distance for dog Buch: ");
                int dogBuchSwimDistance = scanner.nextInt();
                dogBuch.swim(dogBuchSwimDistance);

                Cat catMyrka = new Cat();
                System.out.print("Enter the ran distance for cat Myrka: ");
                int catMyrkaDistance = scanner.nextInt();
                catMyrka.run(catMyrkaDistance);

                System.out.print("Enter the swim distance for cat Myrka: ");
                int catMyrkaSwimDistance = scanner.nextInt();
                catMyrka.swim(catMyrkaSwimDistance);

                Cat catSimba = new Cat();
                System.out.print("Enter the ran distance for cat Simba: ");
                int catSimbaDistance = scanner.nextInt();
                catSimba.run(catSimbaDistance);

                System.out.print("Enter the swim distance for cat Simba: ");
                int catSimbaSwimDistance = scanner.nextInt();
                catSimba.swim(catSimbaSwimDistance);

                Cat catLeo = new Cat();
                System.out.print("Enter the ran distance for cat Leo: ");
                int catLeoDistance = scanner.nextInt();
                catLeo.run(catLeoDistance);

                System.out.print("Enter the swim distance for cat Leo: ");
                int catLeoSwimDistance = scanner.nextInt();
                catLeo.swim(catLeoSwimDistance);

                System.out.println("Created dogs: " + Dog.getDogCount());
                System.out.println("Created cats: " + Cat.getCatCount());
                System.out.println("Created animals: " + Animal.getAnimalCount());
        }
}
