package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TDFFileReader {
    private File file;
    private Scanner scanner;
    public TDFFileReader(String filename) throws FileNotFoundException {
    }
    public List<Cyclist> readFile() {
    List<Cyclist> cyclists = new ArrayList<>();
    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] parts = line.split(",");
        String name = parts[0];
        String team = parts[1];
        Cyclist cyclist = new Cyclist(name, team);
        cyclists.add(cyclist);
    }
    return cyclists;
    }
}
