package mobi.nuuvo.frimgle.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import org.gwtbootstrap3.client.ui.HasPlaceholder;

/**
 * Created by svd on 17/05/14.
 */
public class SmartImageUrlBox extends Composite implements HasPlaceholder, Editor<String>, HasLabel {
    private static SmartImageUrlBoxBinder ourUiBinder = GWT.create(SmartImageUrlBoxBinder.class);
    @UiField
    @Path("")
    SmartTextBox textBox;
    @UiField
    @Path("")
    ImageUrlEditor image;

    public SmartImageUrlBox() {
        initWidget(ourUiBinder.createAndBindUi(this));
        textBox.addValueChangeHandler(new ValueChangeHandler<String>() {
            @Override
            public void onValueChange(ValueChangeEvent<String> event) {
                image.setValue(event.getValue());
            }
        });
        textBox.addKeyUpHandler(new KeyUpHandler() {
            @Override
            public void onKeyUp(KeyUpEvent event) {
                image.setValue(textBox.getValue());
            }
        });
    }

    @Override
    public String getPlaceholder() {
        return textBox.getPlaceholder();
    }

    @Override
    public void setPlaceholder(String placeholder) {
        textBox.setPlaceholder(placeholder);
    }

    @Override
    public String getLabel() {
        return textBox.getLabel();
    }

    @Override
    public void setLabel(final String label) {
        textBox.setLabel(label);
    }

    interface SmartImageUrlBoxBinder extends UiBinder<Widget, SmartImageUrlBox> {
    }

}