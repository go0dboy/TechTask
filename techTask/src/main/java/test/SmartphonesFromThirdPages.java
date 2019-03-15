package test;

import org.testng.annotations.Test;
import pages.SmartphonePage;

public class SmartphonesFromThirdPages extends BaseTest {
    @Test
    public void userChooseSmartphoneFromThirdPage() {
        SmartphonePage smartphonePage = new SmartphonePage();
        smartphonePage.clickSmartphonesTVAndElectronics();
        smartphonePage.clickPhones();
        smartphonePage.clickSmartphones();
        smartphonePage.clickDownloadMore();
        smartphonePage.clickDownloadMore();


        smartphonePage.writeResultInTextFile();
    }
}
