package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Song blackout = new Song("Black Out", 5.04);
        Song bodyburn = new Song("Body Burn", 3.54);
        Song revolutiontime = new Song("Revolution Time", 5.20);
        ArrayList<Song> songArr = new ArrayList<Song>();
        songArr.add(blackout);
        songArr.add(bodyburn);
        songArr.add(revolutiontime);
        LinkedList<Album> albumsList = new LinkedList<Album>();

        Song oxyacetylene = new Song("Oxyacetylene", 4.01);
        Song humanDrum = new Song("Human Drum", 7.02);
        Song skeletal = new Song("Skeletal", 4.21);
        ArrayList<Song> cyberiaSongArr = new ArrayList<Song>();
        cyberiaSongArr.add(oxyacetylene);
        cyberiaSongArr.add(humanDrum);
        cyberiaSongArr.add(skeletal);

        Album antimatter = new Album(songArr,"Cubanate", "Antimatter");
        albumsList.add(antimatter);
        Album cyberia = new Album(cyberiaSongArr, "Cubanate", "Cyberia");
        albumsList.add(cyberia);

        Playlist playlist = new Playlist(albumsList);

        playlist.addSongToPlaylist("Vortech 1", 2.56, "Barbarossa", "Cubanate");
        playlist.removeSong("Human Drum", "Cyberia", "Cubanate");

        System.out.println("Menu\n" +
                "1 - quit\n"+
                "2 - skip forward to next song\n" +
                "3 - skip backwards to previous song\n" +
                "4 - replay current song\n" +
                "5 - list all songs on playlist\n");

        boolean run = true;
        while(run){
            System.out.println("Select Action from Menu:\n");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action){
                case 1:
                    run = false;
                    break;
                case 2:
                    playlist.nextSong();
                    break;
                case 3:
                    playlist.previousSong();
                    break;
                case 4:
                    playlist.replay();
                    break;
                case 5:
                    playlist.printAllSongs();
                    break;

            }
        }

    }


}
