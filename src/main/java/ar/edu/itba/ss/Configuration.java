package ar.edu.itba.ss;

public class Configuration {

    protected double fps;
    protected int pedestrians;
    protected double desiredSpeed;
    protected String statsFile;
    protected String outputFile;
    protected double exitPosition;

    public Configuration(double fps, int pedestrians, double desiredSpeed, String statsFile, String outputFile, Double exitPosition) {
        this.fps = fps;
        this.pedestrians = pedestrians;
        this.desiredSpeed = desiredSpeed;
        this.statsFile = statsFile;
        this.outputFile = outputFile;
        this.exitPosition = exitPosition;
    }

    public double getFps() {
        return fps;
    }

    public int getPedestrians() {
        return pedestrians;
    }

    public double getDesiredSpeed() {
        return desiredSpeed;
    }

    public String getStatsFile() {
        return statsFile;
    }

    public String getOutputFile() {
        return outputFile;
    }
}
