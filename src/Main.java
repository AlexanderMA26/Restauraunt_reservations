import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    static ArrayList<Reservation> Resarray = new ArrayList<>();

    public static void main(String[] args) {
        Initialization();
        Input();

    }

    static void Initialization() {
        Resarray.add(new Reservation(14, 2, "Jim"));
        Resarray.add(new Reservation(6, 5, "Alexander"));
        Resarray.add(new Reservation(19, 6, "Robert"));

    }

    static void newReservation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input your party size");
        int resSize = Integer.parseInt(scanner.nextLine());

        System.out.println("Input the time of your reservation (24-hour time)");
        int parTime = Integer.parseInt(scanner.nextLine());

        System.out.println("Give a name for your reservation");
        String parName = scanner.nextLine();

        Resarray.add(new Reservation(resSize, parTime, parName));

        System.out.println("We have recieved your reservation!");

        Input();
    }

    static void viewReservation() {

        for (Reservation obj : Resarray) {
            System.out.println();
            System.out.println("Reservation Name: " + obj.partyName);
            System.out.println("Reservation Time: " + obj.resTime);
            System.out.println("Reservation Size: " + obj.partySize);
        }
        Input();
}

    static void Input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter 'R' for existing reservations\nEnter 'N' to create a new reservation\nEnter 'C' to cancel a reservation");

        String beginningQuestions = scanner.nextLine();

        if (beginningQuestions.equalsIgnoreCase("N")) {
            newReservation();
        } else if (beginningQuestions.equalsIgnoreCase("R")) {
            viewReservation();
        }else{
            cancel();
        }

        scanner.close();


    }

    static void cancel() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the name of the group you would like to cancel?\n");

        String groupToCancel = scanner.nextLine();


        Resarray.removeIf(obj -> Objects.equals(obj.partyName, groupToCancel));



        viewReservation();


        scanner.close();
    }


    static void sortList() {
        for (int i = 0; i <= Resarray.size(); i++) {
            for (int j = 0; j <= Resarray.size(); j++)
                if (Resarray.get(j).resTime > Resarray.get(j+1).resTime) {
                    Collections.swap(Resarray, j, j++);

                }
        }
        }
    }

