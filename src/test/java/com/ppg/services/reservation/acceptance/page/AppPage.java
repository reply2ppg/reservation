package com.ppg.services.reservation.acceptance.page;

import lombok.extern.slf4j.Slf4j;
import org.fluentlenium.core.FluentControl;
import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class AppPage extends FluentPage {

    @Override
    public void initFluent(FluentControl control) {
        super.initFluent(control);
    }

    public WebDriverWait waitForChromeDriver(int delaySeconds) {
        return new WebDriverWait(getDriver(), delaySeconds, 200);
    }
}