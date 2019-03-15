package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PowderPage extends BasePage {
    private By householdProducts = By.linkText("Товары для дома");
    private By chemicals = By.linkText("Бытовая химия");
    private By powder = By.linkText("Порошок");
    private By downloadMore = By.className("g-i-more-link-text");
    private By title = By.xpath("//*[@id='catalog_goods_block']//div[1]//div[@class='g-i-tile-i-title clearfix']");
    private By price = By.xpath("//*[@id='catalog_goods_block']//div[1]//div[@class='g-price-uah']");
    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost:3306/powder?serverTimezone=UTC";
    final String USER = "root";
    final String PASS = "rootr00t";
    private ElementsCollection list = $$(title);
    private ElementsCollection list1 = $$(price);

    public void clickHouseholdProducts() {
        $(householdProducts).shouldBe(Condition.visible).click();
    }

    public void clickChemicals() {
        $(chemicals).shouldBe(Condition.visible).click();
    }

    public void clickPowder() {
        $(powder).shouldBe(Condition.visible).click();
    }

    public void clickDownloadMore() {
        $(downloadMore).shouldBe(Condition.exist).scrollTo().shouldBe(Condition.visible).click();
    }

    public void writeResultInDB() {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            for (int i = 0; i < list.size(); i++) {
                String price = list1.get(i).getText().replaceAll("\\D+", "");
                int priceInt = Integer.parseInt(price);
                if (priceInt >= 100 && priceInt <= 300) {
                    String name = list.get(i).getText().replaceAll("'", "");
                    String sql = "INSERT INTO powder " +
                            "VALUES ('" + name + "', '" + price + "');";
                    stmt.execute(sql);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}