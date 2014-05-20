package mobi.nuuvo.frimgle.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.ui.client.ValueBoxEditorDecorator;
import com.google.gwt.editor.ui.client.adapters.ValueBoxEditor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
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
public class SmartTextBox extends Composite implements HasEditorErrors<String>, HasPlaceholder, IsEditor<ValueBoxEditor<String>> {
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
    public ValueBoxEditor<String> asEditor() {
        return decorator.asEditor();
    }

    @Override
    public void showErrors(List<EditorError> errors) {
        boolean hasErrors = false;
        for (EditorError error : errors) {
            hasErrors |= Objects.equals(error.getEditor(), asEditor());
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

    public String getLabel() {
        return formLabel.getText();
    }

    public void setLabel(final String label) {
        formLabel.setText(label);
    }

    interface SmartTextBoxUiBinder extends UiBinder<FormGroup, SmartTextBox> {
    }
}