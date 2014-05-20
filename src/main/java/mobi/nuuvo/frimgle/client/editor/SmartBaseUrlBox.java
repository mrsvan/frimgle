package mobi.nuuvo.frimgle.client.editor;

import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import org.gwtbootstrap3.client.ui.HasPlaceholder;

/**
 * Created by svd on 20/05/14.
 */
public class SmartBaseUrlBox extends Composite implements HasPlaceholder, Editor<String>, HasLabel {
    @UiField
    @Path("")
    SmartTextBox textBox;

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

    protected void attachUpdateHandlers(final LeafValueEditor<String> preview) {
        textBox.addValueChangeHandler(new ValueChangeHandler<String>() {
            @Override
            public void onValueChange(ValueChangeEvent<String> event) {
                preview.setValue(event.getValue());
            }
        });
        textBox.addKeyUpHandler(new KeyUpHandler() {
            @Override
            public void onKeyUp(KeyUpEvent event) {
                preview.setValue(textBox.getValue());
            }
        });
    }
}
