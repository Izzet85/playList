package com.company;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();









    public static void main(String[] args) {
	// write your code here

        Album album = new Album("Storm","Deep Purple");
        album.addSong("Jackson",4.6);
        album.addSong("rihanna",4.22);
        album.addSong("dr dre",5.6);
        album.addSong("2pac",3.22);
        album.addSong("snoop dogg",2.33);
        album.addSong("mouse",2.63);
        album.addSong("muse",3.36);
        album.addSong("Stormbringer",5.56);
        album.addSong("Stormbringer",6.36);
        album.addSong("Stormbringer",3.33);
        albums.add(album);

        album = new Album("For those about to rock","AC/DC");
        album.addSong("For those about to rock",5.44);
        album.addSong("erzincan ",3.22);
        album.addSong("sevdim",3.33);
        album.addSong("sabuha",4.44);
        album.addSong("konya",6.44);
        album.addSong("kayseri",2.44);
        album.addSong("karaman",6.44);
        album.addSong("For rock",7.44);
        album.addSong("about to rock",8.44);
        albums.add(album);


        LinkedList<Song> playlist = new LinkedList<Song>();
        albums.get(0).addToPlayList("Jackson",playlist);
        albums.get(0).addToPlayList("asdfsadf",playlist);
        albums.get(0).addToPlayList("2pac",playlist);
        albums.get(0).addToPlayList(1,playlist);
        albums.get(1).addToPlayList("karaman",playlist);
        albums.get(1).addToPlayList("For rock",playlist);
        albums.get(1).addToPlayList(5,playlist);
        albums.get(1).addToPlayList(9,playlist);
        albums.get(1).addToPlayList(25,playlist);


        play(playlist);
    }

    private static void play(LinkedList<Song> playList){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        ListIterator listIterator = playList.listIterator();
        if (playList.size() == 0){
            System.out.println("no songs in playlist");
        }else{
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action){
                case 0:
                    System.out.println("playlist complete. ");
                    quit = true;
                    break;
                case 1:
                    if (!forward){
                        if (listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println("Now playing " + listIterator.next().toString());
                    }else{
                        System.out.println("We have reached the end of the list");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward= false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("Now playing "+ listIterator.previous().toString());
                    }else{
                        System.out.println("We are at the start of the playlist  ");
                    }
                    break;
                case 3:
                    if(forward){
                        if (listIterator.hasPrevious()){
                            System.out.println("Now replaying " + listIterator.previous());
                        }else{
                            System.out.println("We are at the start of the list");
                        }
                    }else{
                        if(listIterator.hasNext()){
                            System.out.println("Now replaying " + listIterator.next().toString() );
                            forward = true;
                        }else{
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;

            }




    }

}

    public static void printMenu(){
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previuos song\n " +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlis\n" +
                "5 - print available actions");
    }

    private static void printList(LinkedList<Song> playList){
        Iterator <Song>iterator = playList.iterator();
        System.out.println("========================");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("========================");

    }


    }
