package github;

import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class Homework4 {


    @Test
    void tryingUseHoverOnGithub () {

        //На главной странице GitHub выберите меню Solutions ->
       open("https://github.com");
        // Enterprize с помощью команды hover для Solutions.
$$(".HeaderMenu-link").get(2).shouldHave(text("Solution")).hover();
//выше вызвал третий элемент с таким классом, обязательно исп.$$
        // Убедитесь что загрузилась нужная страница (например что заголовок - "Build like the best."
        $("a[href='https://github.com/enterprise']").click(); //по ссылке удалось открыть
        $("p.Primer_Brand__Hero-module__Hero-description___vG4iA").shouldHave(text("To build, scale, and deliver secure software.")).click();
    }

    @Test
    void tryingUseDragAndDrop (){
        // (опциональное) Запрограммируйте Drag&Drop с помощью Selenide.actions()
        // Откройте https://the-internet.herokuapp.com/drag_and_drop/
        open("https://the-internet.herokuapp.com/drag_and_drop");
        sleep(3000);
        // Перенесите прямоугольник А на место В
        $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));
        sleep(3000);
        // Проверьте, что прямоугольники действительно поменялись
        // В Selenide есть команда $(element).dragAndDrop($(to-element)), проверьте работает ли тест, если использовать её вместо actions()

    }
    @Test
    void tryingToUseActions(){
        // Открываем страницу с drag-and-drop
        open("https://the-internet.herokuapp.com/drag_and_drop");

        // Находим элементы для перетаскивания
        SelenideElement source = $("#column-a");
        SelenideElement target = $("#column-b");

        // Инициализируем Actions
        Actions actions = new Actions(WebDriverRunner.getWebDriver());

        // Выполняем перетаскивание
        actions.clickAndHold(source)    // Захватываем исходный элемент
                .moveToElement(target)   // Перемещаемся к целевому элементу
                .release()               // Отпускаем исходный элемент
                .build()                 // Собираем действия
                .perform();              // Выполняем действияd
        sleep(4000);
    }
}
