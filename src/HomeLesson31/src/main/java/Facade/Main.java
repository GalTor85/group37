package Facade;

public class Main {
    public static void main(String[] args) {
        MediaPlayerFacade mediaPlayerFacade = new MediaPlayerFacade();
        mediaPlayerFacade.playMedia("movie.mp4", "subtitles.srt");
    }
}
