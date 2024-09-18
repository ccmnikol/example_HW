package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Homework3 {

@Test
        void selenideWikiSoftAssertionSearch() {

        //    - Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");
        //- Перейдите в раздел Wiki проекта
$("#wiki-tab").click();

        //- Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions ul.....
    // <a class="internal present" href="/selenide/selenide/wiki/SoftAssertions">Soft assertions</a>
    $("a.internal.present[href='/selenide/selenide/wiki/SoftAssertions']").click();

        //- Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
    $("div#wiki-body").shouldHave(text("3. Using JUnit5 extend test class:"));
    sleep(5000);
    }
}
