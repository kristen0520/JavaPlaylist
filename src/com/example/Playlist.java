package com.example;

import java.util.*;

public class Playlist {
    LinkedList<Album> albums;
    int currentSongIndex;
    int currentAlbumIndex;

    public Playlist(LinkedList<Album> albums) {
        this.albums = albums;
        this.currentAlbumIndex = 0;
        this.currentSongIndex = 0;
    }

    private int albumExists(String title, String band){
        for(int i = 0; i<this.albums.size(); i++){
            if(this.albums.get(i).title == title && this.albums.get(i).band == band){
                return i;
            }
        }
        return -1;
    }

    public void addSongToPlaylist(String name, double duration, String albumTitle, String band){
        int albumIndex = this.albumExists(albumTitle, band);
        Song song = new Song(name, duration);
        ArrayList<Song> albumTracks;
        if (albumIndex >= 0){
            //get tracks using getTracks method on existing album
            albumTracks = this.albums.get(albumIndex).tracks;
            albumTracks.add(song);
        } else {
            albumTracks = new ArrayList<Song>();
            albumTracks.add(song);
            Album album = new Album(albumTracks, band, albumTitle);
            this.albums.add(album);
        }
    }

    public String nextSong(){
        System.out.println("RUNNING NEXT SONG METHOD");
        Album currentAlbum = this.albums.get(currentAlbumIndex);
        ArrayList currentAlbumTracks = currentAlbum.getTracks();
        int currentAlbumTracksLength = currentAlbumTracks.size();
        Song currentSong = currentAlbum.getTracks().get(currentSongIndex);
        if(currentSongIndex == currentAlbumTracksLength-1){
            if(currentAlbumIndex == albums.size()-1){
                System.out.println("this is the last song on the playlist");
                return "this is the last song on the playlist";
            } else {
                currentAlbumIndex++;
                currentSongIndex = 0;
                Song song = this.albums.get(currentAlbumIndex).getTracks().get(currentSongIndex);
                System.out.println(song.getTitle());
                return song.getTitle();
            }
        } else {
            currentSongIndex++;
            Song song = this.albums.get(currentAlbumIndex).getTracks().get(currentSongIndex);
            System.out.println(song.getTitle());
            return song.getTitle();
        }
    }

    public String previousSong(){
        System.out.println("RUNNING PREVIOUS SONG METHOD");
        Album currentAlbum = this.albums.get(currentAlbumIndex);
        ArrayList currentAlbumTracks = currentAlbum.getTracks();
        int currentAlbumTracksLength = currentAlbumTracks.size();
        Song currentSong = currentAlbum.getTracks().get(currentSongIndex);
        if(currentSongIndex == 0){
            if(currentAlbumIndex == 0){
                System.out.println("this is the first song on the playlist");
                return "this is the first song on the playlist";
            } else {
                currentAlbumIndex--;
                currentSongIndex = currentAlbumTracksLength-1;
                Song song = this.albums.get(currentAlbumIndex).getTracks().get(currentSongIndex);
                System.out.println(song.getTitle());
                return song.getTitle();
            }
        } else {
            currentSongIndex--;
            Song song = this.albums.get(currentAlbumIndex).getTracks().get(currentSongIndex);
            System.out.println(song.getTitle());
            return song.getTitle();
        }
    }


    public String replay(){
        System.out.println("RUNNING REPLAY METHOD");
        Album currentAlbum = this.albums.get(currentAlbumIndex);
        ArrayList currentAlbumTracks = currentAlbum.getTracks();
        int currentAlbumTracksLength = currentAlbumTracks.size();
        Song currentSong = currentAlbum.getTracks().get(currentSongIndex);
        Song song = this.albums.get(currentAlbumIndex).getTracks().get(currentSongIndex);
        System.out.println(song.getTitle());
        return song.getTitle();
 }

    public void printAllSongs(){
        System.out.println("RUNNING PRINT ALL SONGS METHOD");
        for(int i =0; i<this.albums.size(); i++){
            Album currentAlbum = this.albums.get(i);
            ArrayList currentAlbumTracks = currentAlbum.getTracks();
            for(int j=0; j<currentAlbumTracks.size(); j++){
                Song currentSong = currentAlbum.getTracks().get(j);
                String currentSongTitle = currentSong.getTitle();
                System.out.println(currentSongTitle);
            }
        }
    }

}

