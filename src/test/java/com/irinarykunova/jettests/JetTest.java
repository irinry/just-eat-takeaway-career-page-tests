package com.irinarykunova.jettests;

import static com.codeborne.selenide.CollectionCondition.allMatch;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.match;
import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.partialText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.By.className;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

class JetTest {

    @BeforeEach
    public void setUp() {
        open("https://careers.justeattakeaway.com/global/en/home");
    }

    @Test
    void when_filterByCountry_than_resultsContainCountrySpecificResults() {
        $(By.id("keywordSearch")).sendKeys("Test");
        $(By.id("ph-search-backdrop")).click();
        $(By.id("CountryAccordion")).click();
        var jobResultsUniqueLocationsCount = $$(className("job-location"))
                .asFixedIterable()
                .stream()
                .map(SelenideElement::getText)
                .distinct()
                .count();
        assertTrue(jobResultsUniqueLocationsCount > 1);

        $$("#CountryBody li > label")
                .find(partialText("Netherlands"))
                .shouldBe(exist)
                .click();
        $$(className("job-location"))
                .shouldHave(allMatch(
                        "Check that every job result is from Netherlands",
                        element -> element.getText().contains("Netherlands")
                ));
    }

    @Test
    void when_filterBySales_than_seeResultsWithSales() {
        $(By.id("keywordSearch")).click();
        $("a[data-ph-at-data-text='Sales']").click();
        $$("h2")
                .find(text("Refine your search"))
                .scrollIntoView(true);
        $(className("facet-tag")).shouldBe(matchText("Sales"));
        verifyResultCountMatchesNumberOfResultsInSideBar("Sales");
        $(By.id("CountryAccordion")).click();
        $$("#CountryBody li > label")
                .find(partialText("Germany"))
                .click();
        verifyResultCountMatchesNumberOfResultsInSideBar("Germany");
        $$(".au-target .category")
                .shouldHave(allMatch(
                        "Check that every job result has category Sales",
                        element -> element.getText().contains("Sales")
                ));
    }

    private void verifyResultCountMatchesNumberOfResultsInSideBar(String sidebarItem) {
        $$(className("result-text"))
                .find(text(sidebarItem))
                .parent()
                .shouldBe(match(
                        "Check the result count matches value in sidebar",
                        element -> element.getText().contains($(className("result-count")).getText())
                ));
    }
}