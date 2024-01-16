package LMS;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTesting {

    // Helper method to simulate user input
    private InputStream provideInput(String data) {
        return new ByteArrayInputStream(data.getBytes());
    }

    // Helper method to capture system output
    private ByteArrayOutputStream captureOutput() {
        return new ByteArrayOutputStream();
    }

    @Test
    public void testUpdateBorrowerName() throws IOException {
        Borrower borrower = new Borrower(1, "John Doe", "123 Main St", 123456789);

        // Simulate user input
        String input = "y\nNewName\nn\n";
        System.setIn(provideInput(input));

        // Capture system output
        ByteArrayOutputStream output = captureOutput();
        System.setOut(new PrintStream(output));

        // Call the method to be tested
        borrower.updateBorrowerInfo();

        // Reset standard input and output
        System.setIn(System.in);
        System.setOut(System.out);

        // Adjust the expected output using regular expressions to ignore whitespace
        String expectedOutputPattern = "DoyouwanttoupdateJohnDoe'sName?(y/n)TypeNewName:Thenameissuccessfullyupdated.Doyouwanttoupdatenull'sAddress?(y/n)Doyouwanttoupdatenull'sPhoneNumber?(y/n)Borrowerissuccessfullyupdated.";

        assertEquals(expectedOutputPattern, output.toString().replaceAll("\\s", ""));
    }

    @Test
    public void testUpdateBorrowerAddress() throws IOException {
        Borrower borrower = new Borrower(1, "John Doe", "123 Main St", 123456789);

        // Simulate user input
        String input = "n\ny\nNew Address\nn\n";
        System.setIn(provideInput(input));

        // Capture system output
        ByteArrayOutputStream output = captureOutput();
        System.setOut(new PrintStream(output));

        // Call the method to be tested
        borrower.updateBorrowerInfo();

        // Reset standard input and output
        System.setIn(System.in);
        System.setOut(System.out);

        // Adjust the expected output using regular expressions to ignore whitespace
        String expectedOutputPattern = "DoyouwanttoupdateJohnDoe'sName?(y/n)DoyouwanttoupdateJohnDoe'sAddress?(y/n)TypeNewAddress:Theaddressissuccessfullyupdated.DoyouwanttoupdateJohnDoe'sPhoneNumber?(y/n)Borrowerissuccessfullyupdated.";

        assertEquals(expectedOutputPattern, output.toString().replaceAll("\\s", ""));
    }

    @Test
    public void testUpdateBorrowerPhoneNumber() throws IOException {
        Borrower borrower = new Borrower(1, "John Doe", "123 Main St", 123456789);

        // Simulate user input
        String input = "n\nn\ny\n987654321\n";
        System.setIn(provideInput(input));

        // Capture system output
        ByteArrayOutputStream output = captureOutput();
        System.setOut(new PrintStream(output));

        // Call the method to be tested
        borrower.updateBorrowerInfo();

        // Reset standard input and output
        System.setIn(System.in);
        System.setOut(System.out);

        // Adjust the expected output using regular expressions to ignore whitespace
        String expectedOutputPattern = "DoyouwanttoupdateJohnDoe'sName?(y/n)DoyouwanttoupdateJohnDoe'sAddress?(y/n)DoyouwanttoupdateJohnDoe'sPhoneNumber?(y/n)TypeNewPhoneNumber:Thephonenumberissuccessfullyupdated.Borrowerissuccessfullyupdated.";

        assertEquals(expectedOutputPattern, output.toString().replaceAll("\\s", ""));
    }

    // Add more test cases for different scenarios as needed
}
