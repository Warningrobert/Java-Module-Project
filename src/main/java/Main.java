import java.util.Scanner;
import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) {
Race race = new Race();
        race.inputParticipants();
        race.calculateWinners();
    }
}

class Car {

    int speed;
    String name;
    int distance;

    public Car (String name, int speed) {
        this.name = name;
        this.speed = speed;
        distance = 24 * speed;
    }

}

class Race {

    ArrayList<Car> participants = new ArrayList<Car>();
    ArrayList<Car> sorted = new ArrayList<Car>();


    public void inputParticipants() {
            Scanner scanner = new Scanner(System.in);
  String name;
            int speed;

for (int i = 1; i <= 3; i++) {

                System.out.println("Введите название учавствующего номер " + i + ":");
                name = scanner.next();
    do {

                System.out.println("Введите скорость учавствующего номер " + i + " (0-250):");

                if (scanner.hasNextInt()) {
                    speed = scanner.nextInt();
                    if (speed > 0 && speed <= 250) {
                        break;
                    } else {
                        System.out.println("Скорость должна быт между 0 и 250.");
                    }
                } else {
                    System.out.println("Скорость должна быть цифрой.");
                    scanner.next();
                }
            } while (true);

            Car car = new Car(name, speed);
            participants.add(car);
        }
    }

    public void calculateWinners(){

        Car leader = new Car("leader", -1);

        for (int i = 0; i < 3; i++){
            if (leader.distance < participants.get(i).distance) {
                leader = participants.get(i);
            }


        }

        System.out.println("Победил " + leader.name);
    }

        

    }
