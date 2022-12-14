package NewPackage;

import Utils.ChromeRunner;
import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class New extends ChromeRunner {

    @Test
    public  void test(){

        $(byText("Create new account")).click();
        $(byName("firstname")).setValue("Helen");
        Assert.assertFalse($(byName("firstname")).is(Condition.empty),"name input");
        $(byName("lastname")).setValue("Danelia");
        Assert.assertEquals($(byName("lastname")).getValue(),"Danelia");
        $(byName("reg_email__")).setValue("Helendaneliaa@gmail.com");
        $(byName("birthday_year")).selectOption("1997");

        SoftAssert soft = new SoftAssert();
        soft.assertEquals($(byName("birthday_year")).getValue(),"1997", "birthday year");

        $(byText("Custom")).click();
        $(byName("preferred_pronoun")).shouldBe(Condition.visible, Duration.ofMillis(2000));
        $(byName("custom_gender")).shouldBe(Condition.visible, Duration.ofMillis(2000));
        $(byText("Female")).click();
        $(byName("preferred_pronoun")).shouldBe(Condition.disappear);

        soft.assertAll();

    }
}

