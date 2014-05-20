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
    SmartTextBox title;
    @UiField
    SmartTextBox description;
    @UiField
    SmartVideoUrlBox videoUrl;
    @UiField
    SmartTextBox skipText;
    @UiField
    SmartTextBox ctaText;
    @UiField
    SmartImageUrlBox ctaBackgroundImgUrl;
    @UiField
    SmartImageUrlBox ctaLogoUrl;
    @UiField
    SmartTextBox ctaBtnColor;
    @UiField
    SmartTextBox thnxTxt;
    @UiField
    SmartImageUrlBox thnxBackgroundImgUrl;
    @UiField
    SmartImageUrlBox thnxLogoUrl;
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
