package github;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

    @Test
    void shouldFindSelenideRepositoryAtTheTop(){
        //открыть гл страницу
        open("https://github.com/");
        //ввести в поле поиска selenide
        $(".mr-2.color-fg-muted").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        $(".Box-sc-g0xbh4-0.kzrAHr span").click();
        //проверить заголовок: Selenide/selenide
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
        sleep(5000);

    }
}
