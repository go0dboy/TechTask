package test;

import org.testng.annotations.Test;
import pages.PowderPage;

public class PowderFromFifthPages extends BaseTest {
    @Test
    public void userChoosePowderFromFifthPages() {
        PowderPage powderPage = new PowderPage();
        powderPage.clickHouseholdProducts();
        powderPage.clickChemicals();
        powderPage.clickPowder();
        powderPage.clickDownloadMore();
        powderPage.clickDownloadMore();
        powderPage.clickDownloadMore();
        powderPage.clickDownloadMore();

        powderPage.writeResultInDB();
    }
}
