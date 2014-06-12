package mobi.nuuvo.frimgle.client.editor;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;

/**
 * The SmartColorBox is a SmartTextBox that changes its background color to the input value.
 * Created by svd on 6/12/14.
 */
public class SmartColorBox extends SmartTextBox {

    public SmartColorBox() {
        super();
        editor.addKeyUpHandler(new KeyUpHandler() {
            @Override
            public void onKeyUp(KeyUpEvent event) {
                setBackgroundToCurrentValue();
            }
        });
        editor.addValueChangeHandler(new ValueChangeHandler<String>() {
            @Override
            public void onValueChange(ValueChangeEvent<String> event) {
                setBackgroundToCurrentValue();
            }
        });
    }

    private void setBackgroundToCurrentValue() {
        final Style textBoxStyle = editor.getElement().getStyle();
        if (null == editor.getValue()) {
            textBoxStyle.clearBackgroundColor();
        } else {
            textBoxStyle.setBackgroundColor(SafeHtmlUtils.htmlEscape(editor.getValue().trim()));
        }
    }
}
