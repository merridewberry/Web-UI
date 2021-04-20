package Lesson06;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import static Lesson06.Values.*;

@Feature("New contact")
@Severity(SeverityLevel.CRITICAL)
public class CreateNewContactTest extends DriverTest {

    @Test
    @Description("Positive new contact creation test")
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
