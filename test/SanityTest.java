import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class SanityTest {

    @Test
    void junitIsConfiguredCorrectly() {
        // This test always passes — it confirms JUnit is working
        assertEquals(4, 2 + 2);
    }

    @BeforeEach
    void setUp() { System.out.println("[Before] Setting up test"); }

    @AfterEach
    void tearDown() { System.out.println("[After] Cleaning up"); }

    @Test
    void firstTest()  { System.out.println("[Test] firstTest");  assertTrue(true); }

    @Test
    void secondTest() { System.out.println("[Test] secondTest"); assertEquals(10, 5 * 2); }

}

/* printed lines:
[Before] Setting up test
[After] Cleaning up
[Before] Setting up test
[Test] firstTest
[After] Cleaning up
[Before] Setting up test
[Test] secondTest
[After] Cleaning up

Explanation: @BeforeEach runs before every test method, while @AfterEach runs after every test method.
The output shows that setup happens first, then the test runs, and finally cleanup happens.
IntelliJ also triggered one additional setup and cleanup cycle during initialization, which is why an extra pair of
lines appeared before the actual tests.*/

/* Challenge Answers:
1. @BeforeEach runs before every test method.
In MediTrack, it can be used to create a new PatientAdmission object before each test.
@BeforeAll runs only once before all tests.
In MediTrack, it can be used to set up a database connection or load hospital data once.

2. The testing pyramid shows that a software project should have many unit tests, fewer integration tests, and very few
UI or system tests. Unit tests are at the bottom because they are fast and easy to run, while integration and UI tests
are slower and more complex.

        UI Tests
     ----------------
    Integration Tests
  --------------------
        Unit Tests
------------------------

This means unit tests are the most important because they are fast and easy to run.

3. MediTrack’s team lead requires 80% or higher test coverage to make sure most of the code is tested and bugs can be
detected early. High test coverage improves software quality and reliability, especially for hospital systems. However,
test coverage does not guarantee that the program is completely correct or bug-free because tests may still miss some
problems or contain weak test cases.
 */
