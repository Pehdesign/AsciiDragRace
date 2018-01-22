package com.company;

import javax.rmi.CORBA.Tie;
import java.io.Console;
import java.util.FormatFlagsConversionMismatchException;
import java.util.Scanner;

public class Main {

    private static final int TRACK_LENGTH = 25;
    private static final char[] PLAYER_CHAR = {'W','D'};
    private static Car HostPlayer, GuestPlayer;


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean isEnd;
        int win = 0,lose = 0,tie = 0;

        do {

            System.out.println("Welcome to AsciiDragRace \nHave Fun :) \n ");

            TrackBoundry();
            SetPlayerInStart();
            TrackBoundry();

            do {
                System.out.println("Press ENTER to Run");
                scan.nextLine();
                TrackBoundry();
                HostPlayer.Run();
                GuestPlayer.Run();
                TrackBoundry();
          //      System.out.println(HostPlayer.location + " | " + GuestPlayer.location);
            } while ((HostPlayer.location < TRACK_LENGTH));

            if (HostPlayer.location > GuestPlayer.location) {
                System.out.println("You WIN");
                win++;
            } else if (HostPlayer.location < GuestPlayer.location) {
                System.out.println("You Lose");
                lose++;
            } else if (HostPlayer.location == GuestPlayer.location) {
                System.out.println("Is Tie");
                tie++;
            }

            System.out.println("Stats: " + win + " Win, " + lose + " Lose, " + tie + " Tie");

        System.out.println("\nPress Enter to restart or type EXIT to exit game");
        String resume = scan.nextLine();
        if(resume.isEmpty()) {isEnd=false;}
        else {isEnd = true;}

        }while (isEnd == false);
    }

     public static void SetPlayerInStart() {
            HostPlayer = new Car();
            HostPlayer.SetCarChar(PLAYER_CHAR[0]);
            System.out.println(HostPlayer.carChar);

            GuestPlayer = new Car();
            GuestPlayer.SetCarChar(PLAYER_CHAR[1]);
            System.out.println(GuestPlayer.carChar);
     }

    public static void TrackBoundry()
    {
        for(int i = 0; i <= TRACK_LENGTH; i++){

            if (i == 0) System.out.print("$");
            else if (i == TRACK_LENGTH) System.out.print("#");
            else{
            System.out.print("-");}
        }

        System.out.println();
    }
}
