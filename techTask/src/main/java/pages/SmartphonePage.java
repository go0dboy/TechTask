package pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import com.codeborne.selenide.Condition;

import java.io.FileWriter;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SmartphonePage extends BasePage {
    private By smartphonesTVAndElectronics = By.linkText("Смартфоны, ТВ и электроника");
    private By phones = By.linkText("Телефоны");
    private By smartphones = By.linkText("Смартфоны");
    private By downloadMore = By.className("g-i-more-link-text");
    private By smartphoneCard = By.xpath("//*[@id='catalog_goods_block']//div[1]//div[@class='g-i-tile-i-title clearfix']");

    public void clickSmartphonesTVAndElectronics() {
        $(smartphonesTVAndElectronics).shouldBe(Condition.exist).scrollTo().shouldBe(Condition.visible).click();
    }
    public void clickPhones() {
        $(phones).shouldBe(Condition.visible).shouldBe(Condition.exist).scrollTo().shouldBe(Condition.visible).click();
    }
    public void clickSmartphones(){
        $(smartphones).shouldBe(Condition.visible).shouldBe(Condition.exist).scrollTo().shouldBe(Condition.visible).click();
    }
    public void clickDownloadMore() {
        $(downloadMore).shouldBe(Condition.visible).shouldBe(Condition.exist).scrollTo().shouldBe(Condition.visible).click();
    }

    public void writeResultInTextFile() {

        ElementsCollection list = $$(smartphoneCard);
        try(FileWriter writer = new FileWriter("notes.txt", false))
        {
            for (int i = 0; i < list.size(); i++) {
                try {
                    writer.write(list.get(i).getText());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    writer.append('\n');
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
