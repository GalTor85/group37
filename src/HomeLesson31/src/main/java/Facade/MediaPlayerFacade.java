package Facade;

public class MediaPlayerFacade {
    private AudioDecoder audioDecoder;
    private VideoDecoder videoDecoder;
    private AudioPlayer audioPlayer;
    private VideoPlayer videoPlayer;
    private SubtitleSystem subtitleSystem;

    public MediaPlayerFacade() {
        this.audioDecoder = new AudioDecoder();
        this.videoDecoder = new VideoDecoder();
        this.audioPlayer = new AudioPlayer();
        this.videoPlayer = new VideoPlayer();
        this.subtitleSystem = new SubtitleSystem();
    }

    public void playMedia(String mediaFile, String subtitleFile) {
        System.out.println("=== Начинаю воспроизведение медиа ===");

        audioDecoder.decode(mediaFile);
        videoDecoder.decode(mediaFile);

        if (subtitleFile != null) {
            subtitleSystem.show(subtitleFile);
        }

        audioPlayer.play();
        videoPlayer.play();

        System.out.println("=== Воспроизведение завершено ===");
    }
}