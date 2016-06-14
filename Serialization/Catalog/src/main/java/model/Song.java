package model;

import java.io.Serializable;

/**
 * Created by Р on 12.06.2016.
 */
public class Song implements Serializable {
    private String songName;
    private int songLength;

    public Song(String newSongName, int newSongLength) {
        this.songName = newSongName;
        this.songLength = newSongLength;
    }

    public Song() {

    }

    public void setSongName(String newSongName) {
        this.songName = newSongName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongLength(int newSongLength) {
        this.songLength = newSongLength;
    }

    public int getSongLength() {
        return songLength;
    }

    private String getSongLengthMinuts() {
        return " " + songLength / 60 + ".";
    }

    private String getSongLengthSeconds() {
        return String.format("%2d", songLength % 60);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("Song: ").append(songName).append(getSongLengthMinuts()).append(getSongLengthSeconds());
        return stringBuilder.toString();
    }
}
