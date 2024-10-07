package product;

public class Media {
    private String title;
    private String url;
    private int pointsRequired;

    public Media(String title, String url, int pointsRequired) {
        this.title = title;
        this.url = url;
        this.pointsRequired = pointsRequired;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public int getPointsRequired() {
        return pointsRequired;
    }

    @Override
    public String toString() {
        return title + " (" + pointsRequired + " points)";
    }
}
