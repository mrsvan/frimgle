package mobi.nuuvo.frimgle.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created by svd on 17/05/14.
 */
public class SmartImageUrlBox extends SmartBaseUrlBox {
    private static SmartImageUrlBoxBinder ourUiBinder = GWT.create(SmartImageUrlBoxBinder.class);

    @UiField
    @Path("")
    ImageUrlEditor image;

    public SmartImageUrlBox() {
        initWidget(ourUiBinder.createAndBindUi(this));
        attachUpdateHandlers(image);
    }

    interface SmartImageUrlBoxBinder extends UiBinder<Widget, SmartImageUrlBox> {
    }

}