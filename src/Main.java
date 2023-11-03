import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Collections;
import java.util.Random;


public class Main {
    static ArrayList<Reservation> Resarray = new ArrayList<>();

    public static void main(String[] args) {
        Initialization();
        Input();

    }

    static void Initialization() {
        Resarray.add(new Reservation(14, 2, "Jim", new Random(System.currentTimeMillis()).nextInt()));
        Resarray.add(new Reservation(6, 5, "Alexander", new Random(System.currentTimeMillis()).nextInt()));
        Resarray.add(new Reservation(19, 6, "Robert", new Random(System.currentTimeMillis()).nextInt()));
        sortList();

    }

    static void newReservation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input your party size");
        int resSize = Integer.parseInt(scanner.nextLine());

        System.out.println("Input the time of your reservation (24-hour time)");
        int parTime = Integer.parseInt(scanner.nextLine());

        System.out.println("Give a name for your reservation");
        String parName = scanner.nextLine();

        int ResKey = Randint();


        Resarray.add(new Reservation(resSize, parTime, parName, ResKey));

        System.out.println("We have recieved your reservation!");

        System.out.println("Your reservation key is " + ResKey + ". Don't forget your key!");

        sortList();

        Input();
    }

    static void viewReservation() {
        sortList();
        for (Reservation obj : Resarray) {
            System.out.println();
            System.out.println("Reservation Name: " + obj.partyName);
            System.out.println("Reservation Time: " + obj.resTime);
            System.out.println("Reservation Size: " + obj.partySize);
        }
        Input();
    }

    static void Input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter 'R' for existing reservations\nEnter 'N' to create a new reservation\nEnter 'C' to cancel a reservation");

        String beginningQuestions = scanner.nextLine();

        if (beginningQuestions.equalsIgnoreCase("N")) {
            newReservation();
        } else if (beginningQuestions.equalsIgnoreCase("R")) {
            viewReservation();
        } else {
            cancel();
        }

        scanner.close();


    }

    static void cancel() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the key of the group you would like to cancel?\n");

        int groupToCancel = Integer.parseInt(scanner.nextLine());


        Resarray.removeIf(obj -> Objects.equals(obj.ResKey, groupToCancel));


        viewReservation();


        scanner.close();
    }


    //Found on Stack Overflow
    static public int Randint() {
        Random r = new Random( System.currentTimeMillis() );
        return 10000 + r.nextInt(20000);
    }

    static void sortList() {
        int n = Resarray.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (Resarray.get(j) != null && Resarray.get(j + 1) != null && Resarray.get(j).resTime > Resarray.get(j + 1).resTime) {
                    Collections.swap(Resarray, j, j + 1);
                }
            }
        }
    }

    static void changeRes(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the key of the reservation you want to change");

        String ResChange = scanner.nextLine();

    }





}


