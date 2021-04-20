package Lesson06;

import org.junit.jupiter.api.Test;
import static Lesson06.Values.*;

public class CreateNewContactTest extends DriverTest {

    @Test
    public void newContactPositiveTest() {
        new Login(driver).signIn(LOGIN, PASSWORD);

        new Menu(driver, builder)
                .clickContacts()
                .createNewContact()
                .inputFirstName(CONT_NAME)
                .inputLastName(CONT_LAST_NAME)
                .chooseCompany(CONT_COMPANY_NAME)
                .inputJobTitle(CONT_JOB)
                .submitNewContact()
                .checkSuccess();
    }
}
