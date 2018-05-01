package com.ppg.services.reservation.acceptance;

import com.ppg.services.reservation.ReservationApplication;
import com.ppg.services.reservation.acceptance.page.MovieReservationPage;
import lombok.extern.slf4j.Slf4j;
import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.configuration.FluentConfiguration;
import org.fluentlenium.core.annotation.Page;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.event.KeyEvent;

import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.configuration.ConfigurationProperties.DriverLifecycle.CLASS;
import static org.fluentlenium.configuration.ConfigurationProperties.TriggerMode.AUTOMATIC_ON_FAIL;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_CLASS;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = ReservationApplication.class)
@DirtiesContext(classMode = AFTER_CLASS)
@FluentConfiguration(driverLifecycle = CLASS, screenshotMode = AUTOMATIC_ON_FAIL, screenshotPath = "screenshots")
@Slf4j

public class MovieReservationTest extends FluentTest{

    @Page
    MovieReservationPage movieReservationPage;

    @LocalServerPort
    protected int serverPort;


    @Before
    public void setUp() {
        String baseUrl = "http://localhost:"+serverPort;
        movieReservationPage.setBaseUrl(baseUrl);
    }

    @Test
    public void movieReservation_hasSearchButtonDisabled() throws Exception{
        goTo(movieReservationPage);
        assertThat(movieReservationPage.getSearchButton().enabled()).isFalse();
    }

    @Test
    public void movieReservation_searchButtonEnabled_withInput() throws Exception {
        goTo(movieReservationPage);
        movieReservationPage.getMovieName().write("movie name");
        assertThat(movieReservationPage.getSearchButton().enabled()).isTrue();
    }

    @Test
    public void movieReservation_getsMoviesWithPrices_withOnlyOneSearchCriteria() throws Exception {
        goTo(movieReservationPage);
        movieReservationPage.getMovieName().write("roja");
        movieReservationPage.getSearchButton().click();
        Thread.sleep(2000);
        String moviePriceResponse = movieReservationPage.getMovieDetails().text();
        assertThat(moviePriceResponse).containsIgnoringCase("roja");
        assertThat(getResponseArray(moviePriceResponse).length()).isEqualTo(1);

        movieReservationPage.getMovieName().write("");
        movieReservationPage.getCityName().write("Dayton");
        movieReservationPage.getSearchButton().click();
        Thread.sleep(2000);
        moviePriceResponse = movieReservationPage.getMovieDetails().text();
        assertThat(moviePriceResponse).containsIgnoringCase("dayton");
        assertThat(getResponseArray(moviePriceResponse).length()).isEqualTo(3);

        movieReservationPage.getCityName().write("");
        movieReservationPage.getTheaterName().write("AMC");
        movieReservationPage.getSearchButton().click();
        Thread.sleep(2000);
        moviePriceResponse = movieReservationPage.getMovieDetails().text();
        assertThat(moviePriceResponse).containsIgnoringCase("amc");
        assertThat(getResponseArray(moviePriceResponse).length()).isEqualTo(6);


    }


    @Test
    public void movieReservation_getsMoviesWithPrices_withMultipleSearchCriteria() throws Exception {
        goTo(movieReservationPage);
        movieReservationPage.getMovieName().write("roja");
        movieReservationPage.getTheaterName().write("AMC");
        movieReservationPage.getCityName().write("Cincinnati");
        movieReservationPage.getSearchButton().click();
        Thread.sleep(2000);
        assertThat(movieReservationPage.getMovieDetails().text()).contains("Roja");
        assertThat(movieReservationPage.getMovieDetails().text()).contains("AMC");
        assertThat(movieReservationPage.getMovieDetails().text()).contains("Cincinnati");
    }


    @Test
    public void testGoogleSearch() throws Exception{
        // Optional, if not specified, WebDriver will search your path for chromedriver.
//        driver.get("http://www.google.com/xhtml");
//        Thread.sleep(5000);  // Let the user actually see something!
//        WebElement searchBox = driver.findElement(By.name("q"));
//        searchBox.sendKeys("ChromeDriver");
//        searchBox.submit();
//        Thread.sleep(5000);  // Let the user actually see something!
//        driver.quit();
    }

    @Override
    public WebDriver newWebDriver() {
        try {
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
            System.setProperty("webdriver.chrome.driver", "C:/Softwares/chromedriver_win32/chromedriver.exe");
            return new ChromeDriver();
    } catch (Exception e) {
            return null;
        }
    }

    private JSONArray getResponseArray(String moviePriceResponse) throws JSONException {
        return new JSONArray(moviePriceResponse.replace("Ajax Response", ""));
    }

}
