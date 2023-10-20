import java.util.ArrayList;

public class Main {
    static ArrayList<Reservation> Resarray = new ArrayList<Reservation>();
    public static void main(String[] args) {
        Initialization();




    }


    static void Initialization(){
        Reservation party1 = new Reservation();
        party1.resTime = 14;
        party1.partySize = 2;
        Resarray.add(party1);


        Reservation party2 = new Reservation();
        party2.resTime = 6;
        party2.partySize = 5;
        Resarray.add(party2);

        Reservation party3 = new Reservation();
        party3.resTime = 19;
        party3.partySize = 6;
        Resarray.add(party3);

    }

}
