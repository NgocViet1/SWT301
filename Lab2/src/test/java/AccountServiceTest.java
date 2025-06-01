import org.junit.jupiter.api.*;
import viet.AccountService;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class AccountServiceTest {

    AccountService service = new AccountService();
    List<String> testResults = new ArrayList<>();

    @Test
    public void testRegisterFromCSV() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\ASUS\\IdeaProjects\\Demo4\\src\\test\\resources\\Data.csv"));
        lines.remove(0); // bỏ header

        for (String line : lines) {
            String[] parts = line.split(",");
            String username = parts[0];
            String password = parts[1];
            String email = parts[2];
            boolean expected = Boolean.parseBoolean(parts[3]);

            boolean result = service.registerAccount(username, password, email);

            String status = (result == expected) ? "PASS" : "FAIL";
            testResults.add(line + "," + result + "," + status);

            Assertions.assertEquals(expected, result,
                    "Test failed for input: " + Arrays.toString(parts));
        }

        saveTestResults();
    }

    void saveTestResults() throws IOException {
        List<String> output = new ArrayList<>();
        output.add("username,password,email,expected,actual,result");
        output.addAll(testResults);
        Files.write(Paths.get("C:\\Users\\ASUS\\IdeaProjects\\Demo4\\src\\test\\resources\\UnitTest.txt"), output);
    }
}
