package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TDFFileReader {
    File file;
    Scanner scanner;

    public TDFFileReader(String filename) throws FileNotFoundException {
        file = new File(filename);
        scanner = new Scanner(file);
    }
    public List<Cyclist> readFile() {
        List<Cyclist> cyclists = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(";");
            if (parts.length > 2) {

                try {
                    String name = parts[1];
                    String team = parts[2];
                    if (team != null && team.contains("TEAM")) {
                        Cyclist cyclist = new Cyclist(name, team);
                        cyclists.add(cyclist);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        }
        return cyclists;
    }
}
