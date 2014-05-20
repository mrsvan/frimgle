package mobi.nuuvo.frimgle.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created by svd on 17/05/14.
 */
public class SmartVideoUrlBox extends SmartBaseUrlBox {
    private static SmartVideoUrlBoxBinder ourUiBinder = GWT.create(SmartVideoUrlBoxBinder.class);

    @UiField
    @Path("")
    VideoUrlEditor video;

    public SmartVideoUrlBox() {
        initWidget(ourUiBinder.createAndBindUi(this));
        attachUpdateHandlers(video);
    }

    interface SmartVideoUrlBoxBinder extends UiBinder<Widget, SmartVideoUrlBox> {
    }

}