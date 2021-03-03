package isp.lab5.exercise2;

interface Playable {
    void play();
}

class ColorVideo implements Playable {

    private String fileName;

    public ColorVideo(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void play() {
        System.out.println("Play " + fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading video..." + fileName);
    }
}

class ProxyVideo implements Playable {

    private ColorVideo video;
    private BlackAndWhiteVideo bvideo;
    private String fileName;
    private int mode;

    public ProxyVideo(String fileName, int mode) {
        this.fileName = fileName;
        this.mode = mode;
    }


    @Override
    public void play() {
        if (video == null && mode == 1) {
            video = new ColorVideo(fileName);
            video.play();
        } else {
            if (video == null && mode == 0) {
                bvideo = new BlackAndWhiteVideo(fileName);
                bvideo.play();
            }
        }

        //video.play();

    }
}

class BlackAndWhiteVideo implements Playable {

    private String fileName;

    public BlackAndWhiteVideo(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);

    }

    public void play() {
        System.out.println("Play black and white video " + "{" + fileName + "}");
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading video..." + fileName);
    }

}


public class Exercise2 {
    public static void main(String[] args) {

        Playable p = new ProxyVideo("Caminiada", 1);
        Playable p1 = new ProxyVideo("Vechi", 0);

        p.play();
        p1.play();
    }


}
