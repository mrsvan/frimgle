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
    SmartTextBox logoUrl;
    @UiField
    SmartTextBox title;
    @UiField
    SmartTextBox description;
    @UiField
    SmartTextBox videoUrl;
    @UiField
    SmartTextBox skipText;
    @UiField
    SmartTextBox ctaText;
    @UiField
    SmartTextBox ctaBackgroundImgUrl;
    @UiField
    SmartTextBox ctaLogoUrl;
    @UiField
    SmartTextBox ctaBtnColor;
    @UiField
    SmartTextBox thnxTxt;
    @UiField
    SmartTextBox thnxBackgroundImgUrl;
    @UiField
    SmartTextBox thnxLogoUrl;
    @UiField
    SmartTextBox facebookThumbnailUrl;
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
