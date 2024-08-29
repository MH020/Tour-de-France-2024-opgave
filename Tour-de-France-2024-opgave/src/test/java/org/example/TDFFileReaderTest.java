package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TDFFileReaderTest {

    @BeforeEach
    void setUp() {
    }
    @Test void testReadFile() {
        try {
            TDFFileReader reader = new TDFFileReader("src/main/resources/tdffinishers2024.csv");
            List<Cyclist> cyclists = reader.readFile();
            //for (Cyclist c : cyclists) {
                System.out.println(cyclists.get(0));
            //}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @AfterEach
    void tearDown() {
    }
}