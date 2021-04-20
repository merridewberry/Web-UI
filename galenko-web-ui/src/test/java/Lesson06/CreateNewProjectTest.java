package Lesson06;

import org.junit.jupiter.api.Test;
import static Lesson06.Values.*;


public class CreateNewProjectTest extends DriverTest {

    @Test
    public void createNewProjectPositiveTest() {
        new Login(driver).signIn(LOGIN, PASSWORD);

        new Menu(driver, builder)
                .clickMyProjects()
                .createNewProject()
                .inputProjectName(PR_NAME)
                .chooseCompany(PR_COMPANY_NAME)
                .chooseContact(PR_CONTACT)
                .chooseBusinessUnit(BUSINES_UNIT)
                .chooseCurator(PR_VALUE)
                .chooseRP(PR_VALUE)
                .chooseAdministrator(PR_VALUE)
                .chooseManager(PR_VALUE)
                .submitNewProject()
                .checkSuccess();
    }


}
