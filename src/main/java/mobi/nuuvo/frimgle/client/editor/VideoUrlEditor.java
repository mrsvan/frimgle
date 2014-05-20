package mobi.nuuvo.frimgle.client.editor;

import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.media.client.Video;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created by svd on 20/05/14.
 */
public class VideoUrlEditor extends Widget implements LeafValueEditor<String> {

    private final Video video = Video.createIfSupported();

    public VideoUrlEditor() {
        super();
        if (null != video) {
            setElement(video.getElement());
            video.setControls(true);
            video.setAutoplay(true);
            video.setWidth("100%");
        }
    }

    @Override
    public String getValue() {
        return null == video ? null : video.getSrc();
    }

    @Override
    public void setValue(String value) {
        if (null != video) video.setSrc(value);
    }
}
