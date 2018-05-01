package com.ppg.services.reservation.acceptance.page;

import lombok.Getter;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

@PageUrl("/moviereservation")
@Getter
public class MovieReservationPage extends AppPage {

    @FindBy(css = "#moive-name")
    private FluentWebElement movieName;

    @FindBy(css = "#theater-name")
    private FluentWebElement theaterName;

    @FindBy(css = "#city-name")
    private FluentWebElement cityName;

    @FindBy(css = "#search-button")
    private FluentWebElement searchButton;

    @FindBy(css = "#movie-details")
    private FluentWebElement movieDetails;
}