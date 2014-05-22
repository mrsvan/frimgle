package mobi.nuuvo.frimgle.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.ui.client.ValueBoxEditorDecorator;
import com.google.gwt.editor.ui.client.adapters.ValueBoxEditor;
import com.google.gwt.event.dom.client.HasKeyUpHandlers;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import org.gwtbootstrap3.client.ui.FormGroup;
import org.gwtbootstrap3.client.ui.FormLabel;
import org.gwtbootstrap3.client.ui.HasPlaceholder;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.client.ui.constants.ValidationState;

import java.util.List;
import java.util.Objects;

/**
 * Created by svd on 17/05/14.
 */
public class SmartTextBox extends Composite implements HasEditorErrors<String>, HasPlaceholder, IsEditor<ValueBoxEditor<String>>, HasLabel, HasValue<String>, HasKeyUpHandlers {
    private static SmartTextBoxUiBinder ourUiBinder = GWT.create(SmartTextBoxUiBinder.class);
    @UiField
    @Ignore
    FormGroup group;
    @UiField
    @Ignore
    FormLabel formLabel;
    @UiField
    @Ignore
    ValueBoxEditorDecorator<String> decorator;
    @UiField
    @Ignore
    TextBox editor;

    public SmartTextBox() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @Override
    public String getValue() {
        return editor.getValue();
    }

    @Override
    public void setValue(String value) {
        editor.setValue(value);
    }

    @Override
    public void setValue(String value, boolean fireEvents) {
        editor.setValue(value, fireEvents);
    }

    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<String> handler) {
        return editor.addValueChangeHandler(handler);
    }

    @Override
    public ValueBoxEditor<String> asEditor() {
        return decorator.asEditor();
    }

    @Override
    public void showErrors(List<EditorError> errors) {
        boolean hasErrors = false;
        for (EditorError error : errors) {
            hasErrors |= (null != error && Objects.equals(error.getEditor(), asEditor()));
        }
        group.setValidationState(hasErrors ? ValidationState.ERROR : ValidationState.NONE);
        decorator.showErrors(errors);
    }

    @Override
    public String getPlaceholder() {
        return editor.getPlaceholder();
    }

    @Override
    public void setPlaceholder(String placeholder) {
        editor.setPlaceholder(placeholder);
    }

    @Override
    public String getLabel() {
        return formLabel.getText();
    }

    @Override
    public void setLabel(final String label) {
        formLabel.setText(label);
    }

    @Override
    public HandlerRegistration addKeyUpHandler(KeyUpHandler handler) {
        return editor.addKeyUpHandler(handler);
    }

    interface SmartTextBoxUiBinder extends UiBinder<FormGroup, SmartTextBox> {
    }

}