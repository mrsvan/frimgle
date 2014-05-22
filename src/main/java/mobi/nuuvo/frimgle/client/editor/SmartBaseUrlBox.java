package mobi.nuuvo.frimgle.client.editor;

import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.ui.client.adapters.ValueBoxEditor;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Composite;
import org.gwtbootstrap3.client.ui.HasPlaceholder;

/**
 * Created by svd on 20/05/14.
 */
public abstract class SmartBaseUrlBox extends Composite implements HasPlaceholder, HasLabel, IsEditor<ValueBoxEditor<String>> {
    @Override
    public ValueBoxEditor<String> asEditor() {
        return getTextBox().asEditor();
    }

    @Editor.Ignore
    protected abstract SmartTextBox getTextBox();

    @Override
    public String getPlaceholder() {
        return getTextBox().getPlaceholder();
    }

    @Override
    public void setPlaceholder(String placeholder) {
        getTextBox().setPlaceholder(placeholder);
    }

    @Override
    public String getLabel() {
        return getTextBox().getLabel();
    }

    @Override
    public void setLabel(final String label) {
        getTextBox().setLabel(label);
    }

    protected void attachUpdateHandlers(final LeafValueEditor<String> preview) {
        getTextBox().addValueChangeHandler(new ValueChangeHandler<String>() {
            @Override
            public void onValueChange(ValueChangeEvent<String> event) {
                preview.setValue(event.getValue());
            }
        });
        getTextBox().addKeyUpHandler(new KeyUpHandler() {
            @Override
            public void onKeyUp(KeyUpEvent event) {
                preview.setValue(getTextBox().getValue());
            }
        });
    }
}
