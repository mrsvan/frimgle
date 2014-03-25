package mobi.nuuvo.frimgle.client.application.widget;

import mobi.nuuvo.frimgle.client.application.widget.header.HeaderModule;
import mobi.nuuvo.frimgle.client.application.widget.login.LoginModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class WidgetModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new HeaderModule());
        install(new LoginModule());
    }
}
