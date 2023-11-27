package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import operator.Management;
import reports.AccountingProcedure;
import reports.EFTReport;
import terminals.ManagerTerminal;
import terminals.OperatorTerminal;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Objects;
import java.util.Scanner;

public class HamzaAdnanJUnitTests {
   
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }


    @Test
    public void testRunWeeklyProcedure() throws IOException {
        String input = "123\n456\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Management realManagement = new Management(); // Replace with actual creation of Management object

        // Run the method under test
        AccountingProcedure.runWeeklyProcedure(realManagement);

        String expectedOutput = "Running weekly accounting procedure...\n" +
                "Please enter the ID of the provider that you would like to generate a provider report for.\n" +
                "Please enter the ID of the member that you would like to generate a member report for.\n" +
                "Weekly procedure completed.\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    static boolean isMidnight(LocalDateTime dateTime) {
        return dateTime.getHour() == 0 && dateTime.getMinute() == 0;
    }

    @Test
    static boolean isFriday(LocalDateTime dateTime) {
        return dateTime.getDayOfWeek() == DayOfWeek.FRIDAY;
    }

    @Test
    public void testEFTReportConstructor() {
        new EFTReport(); // Call the constructor

        // Verify the output
        String expectedOutput = "EFT Report generated.\n";
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }


    // ... other methods ...
}

