

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


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

}
