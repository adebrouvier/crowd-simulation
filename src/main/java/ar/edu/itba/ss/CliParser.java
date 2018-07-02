package ar.edu.itba.ss;

import org.apache.commons.cli.*;

import static java.lang.System.exit;

public class CliParser {

    private double fps = 1000;
    private int pedestrians = 100;
    private double speed = 0.8; // m/s
    private String outputFile = "data.xyz";
    private String statsFile = "stats.txt";
    private double exitPosition = 30.0;

    private static Options createOptions(){
        Options options = new Options();
        options.addOption("h", "help", false, "Shows this screen.");
        options.addOption("p", "pedestrians", true, "Number of pedestrians.");
        options.addOption("s", "desiredSpeed", true, "Desired desiredSpeed of the pedestrians.");
        options.addOption("fps", "fps", true, "Time step for the animation.");
        options.addOption("of", "outputFile", true, "Output file for animations.");
        options.addOption("sf", "statFile", true, "Output file for stats.");
        options.addOption("ep", "exitPosition", true, "Exit position.");

        return options;
    }

    public Configuration parseOptions(String[] args){
        Options options = createOptions();
        CommandLineParser parser = new BasicParser();

        try{
            CommandLine cmd = parser.parse(options, args);

            if(cmd.hasOption("h")){
                help(options);
            }

            if (cmd.hasOption("fps")) {
                fps = Double.parseDouble(cmd.getOptionValue("fps"));
            }

            if (cmd.hasOption("p")) {
                pedestrians = Integer.parseInt(cmd.getOptionValue("p"));
            }

            if (cmd.hasOption("s")) {
                speed = Double.parseDouble(cmd.getOptionValue("s"));
            }

            if (cmd.hasOption("sf")) {
                statsFile = cmd.getOptionValue("sf");
            }

            if (cmd.hasOption("of")) {
                outputFile = cmd.getOptionValue("of");
            }

            if (cmd.hasOption("ep")) {
                exitPosition = Double.parseDouble(cmd.getOptionValue("ep"));
            }

        }catch (Exception e){
            System.out.println("Argument not recognized.");
            help(options);
        }

        return new Configuration(fps, pedestrians, speed, statsFile, outputFile, exitPosition);
    }

    private void help(Options options){
        HelpFormatter helpFormatter = new HelpFormatter();
        helpFormatter.printHelp("crowd-simulation", options);
        exit(0);
    }
}
