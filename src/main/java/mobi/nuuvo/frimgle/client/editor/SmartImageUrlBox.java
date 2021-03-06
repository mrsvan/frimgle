package mobi.nuuvo.frimgle.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

import java.util.List;

/**
 * Created by svd on 17/05/14.
 */
public class SmartImageUrlBox extends SmartBaseUrlBox implements HasEditorErrors<String> {

    private static Binder uiBinder = GWT.create(Binder.class);

    @UiField
    @Ignore
    SmartTextBox smartTextBox;
    @UiField
    @Path("")
    ImageUrlEditor imageUrlEditor;

    public SmartImageUrlBox() {
        initWidget(uiBinder.createAndBindUi(this));
        attachUpdateHandlers(imageUrlEditor);
    }

    @Override
    @Ignore
    protected SmartTextBox getTextBox() {
        return smartTextBox;
    }

    @Override
    public void showErrors(List<EditorError> errors) {
        smartTextBox.showErrors(errors);
    }

    interface Binder extends UiBinder<Widget, SmartImageUrlBox> {
    }
}