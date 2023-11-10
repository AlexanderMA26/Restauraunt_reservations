import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Collections;
import java.util.Random;



public class Main {
    static ArrayList<Reservation> Resarray = new ArrayList<>();
    static ArrayList<Reservation> resWaitList = new ArrayList<>();

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

        if (Resarray.size() < 10){
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
        } else{

            System.out.println("Because of the amount of current reservations, you will be put on the wait list. You will be number " + resWaitList.size() + "on the wait list.");
            Scanner scanner = new Scanner(System.in);

            System.out.println("Input your party size");
            int resSize = Integer.parseInt(scanner.nextLine());

            System.out.println("Input the time of your reservation (24-hour time)");
            int parTime = Integer.parseInt(scanner.nextLine());

            System.out.println("Give a name for your reservation");
            String parName = scanner.nextLine();

            int ResKey = Randint();


            resWaitList.add(new Reservation(resSize, parTime, parName, ResKey));

            System.out.println("We have recieved your reservation!");

            System.out.println("Your reservation key is " + ResKey + ". Don't forget your key!");
        }


        sortList();

        Input();
    }

    static void viewReservation() {
        sortList();
        System.out.println("Current Reservations");
        for (Reservation obj : Resarray) {
            System.out.println();
            System.out.println("Reservation Name: " + obj.partyName);
            System.out.println("Reservation Time: " + obj.partyTime);
            System.out.println("Reservation Size: " + obj.partySize);
        }
        if (!resWaitList.isEmpty()){
            System.out.println("\nCurrent Wait List");
            for (Reservation obj : resWaitList){
                System.out.println();
                System.out.println("Reservation Name: " + obj.partyName);
                System.out.println("Reservation Time: " + obj.partyTime);
                System.out.println("Reservation Size: " + obj.partySize);
        }

        }
        Input();
    }

    static void Input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter 'R' for existing reservations" +
                "\nEnter 'N' to create a new reservation" +
                "\nEnter 'C' to cancel a reservation" +
                "\nEnter 'E' to change an existing reservation" +
                "\nEnter 'A' to escape the screen");

        String beginningQuestions = scanner.nextLine();

        switch (beginningQuestions.toLowerCase()){
            case "n":
                newReservation();
            case "r":
                viewReservation();
            case "c":
                cancel();
            case "e":
                changeRes();
            case "a":
                System.exit(0);
        }




    }

    static void cancel() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the key of the group you would like to cancel?\n");

        int groupToCancel = Integer.parseInt(scanner.nextLine());


        Resarray.removeIf(obj -> Objects.equals(obj.ResKey, groupToCancel));

        System.gc();


        viewReservation();



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
                if (Resarray.get(j) != null && Resarray.get(j + 1) != null && Resarray.get(j).partyTime > Resarray.get(j + 1).partyTime) {
                    Collections.swap(Resarray, j, j + 1);
                }
            }
        }
    }

    static void changeRes(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the key of the reservation you want to change");
        String ResChange = scanner.nextLine();


        int changing = Integer.parseInt(ResChange);

        for (int i = 0; i <= Resarray.size(); i++){
            if (changing == Resarray.get(i).ResKey){
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Do you want to change: The [T]ime, the [N]ame, or the [S]ize of the party?");
                String change = scanner1.nextLine();



                if (change.equalsIgnoreCase("t") || change.equalsIgnoreCase("time")){
                    Scanner time = new Scanner(System.in);
                    System.out.println("When would you like to change your reservation to?");
                    String timeChange = time.nextLine();
                    Resarray.get(i).partyTime = Integer.parseInt(timeChange);
                    System.out.println("Your reservation time has been changed to " + Resarray.get(i).partyTime);

                } else if (change.equalsIgnoreCase("n") || change.equalsIgnoreCase("name")){
                    Scanner name = new Scanner(System.in);
                    System.out.println("What is the new name of your party?");
                    String nameChange = name.nextLine();
                    Resarray.get(i).partyName = nameChange;
                    System.out.println("The name of your party has been changed to " + Resarray.get(i).partyName);
                    
                } else if ((change.equalsIgnoreCase("s") || change.equalsIgnoreCase("size"))) {
                    Scanner size = new Scanner(System.in);
                    System.out.println("How many people are now coming?");
                    String sizeChange = size.nextLine();
                    Resarray.get(i).partySize = Integer.parseInt(sizeChange);
                    System.out.println("Your party size is now" + Resarray.get(i).partySize);
                }else{
                    System.out.println("Invalid Input");
                    changeRes();
                }

                break;
            }
        }


    }
}


