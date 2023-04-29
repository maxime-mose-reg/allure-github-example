package allure;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubTest {

    @Test
    void searchForIssue() {
        Configuration.remote = "http://localhost:4444/wd/hub";
//        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $(".header-search-input").setValue("allure-examples").submit();
        $(byLinkText("allure-examples/allure-examples")).click();
        $("#issues-tab").click();
        $(withText("#38 opened")).shouldBe(visible);
    }
}
