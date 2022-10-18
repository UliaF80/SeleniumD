

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


class CallbakTest {
    @Test
    void shouldSubmitRequest() {

        open("http://localhost:9999");
        // SelenideElement form = $("[data-test-id=callback-form]");
        $("[data-test-id='name'] input").setValue("Ким Олег");
        $("[data-test-id='phone'] input").setValue("+79001501515");
        $("[data-test-id='agreement']").click();
        $("[type='button']").click();
        $("[data-test-id='order-success']").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }

    @Test
    void shouldShowErrorFailName() {
        open("http://localhost:9999");
        $("[data-test-id='name'] input").setValue("Kim Oleg");
        $("[data-test-id='phone'] input").setValue("+79001501515");
        $("[data-test-id='agreement']").click();
        $("[type='button']").click();
        $("[data-test-id='name']").shouldHave(matchText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));

    }

    @Test
    void phoneStringValidation() {
        open("http://localhost:9999");
        $("[data-test-id='name'] input").setValue("Ким Олег");
        $("[data-test-id='phone'] input").setValue("+7900150151");
        $("[data-test-id='agreement']").click();
        $("[type='button']").click();
        $("[data-test-id='phone'].input_invalid .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    void checkboxNotChecked() {
        open("http://localhost:9999");
        $("[data-test-id='name'] input").setValue("Ким Олег");
        $("[data-test-id='phone'] input").setValue("+79001501515");
        $("[data-test-id='agreement");
        $("[type='button']").click();
        $("[data-test-id='agreement'].input_invalid .checkbox__text").shouldHave(exactText("Я соглашаюсь с условиями обработки и использования моих персональных данных и разрешаю сделать запрос в бюро кредитных историй"));
    }

    @Test
    void sendEmptyFailed() {
        open("http://localhost:9999");
        $("[data-test-id='name'] input");
        $("[data-test-id='phone'] input");
        $("[data-test-id='agreement");
        $("[type='button']").click();
        $("[data-test-id='name'].input_invalid .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }


}
