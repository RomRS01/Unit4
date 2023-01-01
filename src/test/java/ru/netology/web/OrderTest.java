package ru.netology.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.text.SimpleDateFormat;
import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import java.time.LocalDate;
import java.util.Date;


class OrderTest {

    @Test
    void shouLdTest() {
        Date date = new Date();
        date.setDate(date.getDate() + 3);
        String strDateFormat = "dd-MM-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 8000;
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Волгоград");
        $("[data-test-id=date] input").sendKeys(Keys.CONTROL + "a");
        $("[data-test-id=date] input").sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").setValue(sdf.format(date).toString());

        $("[data-test-id=name] input").setValue("Пупкин Вася");
        $("[data-test-id=phone] input").setValue("+79991234567");
        $("[data-test-id=agreement]").click();
        $x("//span[contains(text(),'Забронировать')]").click();
        $x("//div[contains(text(),'Успешно')]").shouldBe(visible, Duration.ofSeconds(15));

    }

}