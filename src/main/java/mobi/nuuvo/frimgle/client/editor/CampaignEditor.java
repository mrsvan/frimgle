package mobi.nuuvo.frimgle.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import mobi.nuuvo.frimgle.client.requestfactory.proxy.CampaignProxy;

public class CampaignEditor extends Composite implements Editor<CampaignProxy> {

    private static Binder uiBinder = GWT.create(Binder.class);

    @UiField
    SmartTextBox name;
    @UiField
    SmartImageUrlBox logoUrl;
    @UiField
    SmartVideoUrlBox videoUrl;
    @UiField
    SmartImageUrlBox skipButtonImgUrl;
    @UiField
    SmartTextBox ctaRecipientEmail;
    @UiField
    SmartTextBox ctaPlaceholderText;
    @UiField
    SmartImageUrlBox ctaTitleImgUrl;
    @UiField
    SmartImageUrlBox ctaBackgroundImgUrl;
    @UiField
    SmartImageUrlBox ctaButtonImgUrl;
    @UiField
    SmartTextBox thnxTxt;
    @UiField
    SmartImageUrlBox facebookThumbnailUrl;
    @UiField
    SmartTextBox facebookTitle;
    @UiField
    SmartTextBox facebookDescription;

    public CampaignEditor() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    interface Binder extends UiBinder<Widget, CampaignEditor> {
    }

}
