package github;

import org.junit.jupiter.api.Test;


import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class BestContributorToSelenide {
    @Test
    void solntsevShouldBeInTheTop() {
        //Открыть страницу репозитория Селенида
        Selenide.open("https://github.com/selenide/selenide");
        //Подвести мышку к первому аватару
        $(".BorderGrid").$(byText("Contributors")).ancestor(".BorderGrid-row")
                .$$("ul li").first().hover();
        //проверка в сплывающем окне: есть текст Андрей Солнцев
        $(".Popover-message--bottom-left").shouldHave(text("Andrei Solntsev"));
        sleep(5000);
        //

    }
}
