package mobi.nuuvo.frimgle.client.editor;

import com.google.gwt.editor.client.LeafValueEditor;
import org.gwtbootstrap3.client.ui.Image;

/**
 * Created by svd on 20/05/14.
 */
public class ImageUrlEditor extends Image implements LeafValueEditor<String> {
    @Override
    public String getValue() {
        return getUrl();
    }

    @Override
    public void setValue(String value) {
        setUrl(value);
    }
}
