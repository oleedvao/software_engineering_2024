package model;

public class Movie {

    public String title;
    public int runtimeInMinutes;

    public Movie() {

    }

    public Movie(String title, int runtimeInMinutes) {
        this.title = title;
        this.runtimeInMinutes = runtimeInMinutes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRuntimeInMinutes() {
        return runtimeInMinutes;
    }

    public void setRuntimeInMinutes(int runtimeInMinutes) {
        this.runtimeInMinutes = runtimeInMinutes;
    }
}
