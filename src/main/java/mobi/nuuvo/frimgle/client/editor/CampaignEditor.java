package mobi.nuuvo.frimgle.client.editor;

import org.gwtbootstrap3.client.ui.TextBox;

import mobi.nuuvo.frimgle.client.requestfactory.proxy.CampaignProxy;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class CampaignEditor extends Composite implements Editor<CampaignProxy> {

	interface Binder extends UiBinder<Widget, CampaignEditor> {
	}

	private static Binder uiBinder = GWT.create(Binder.class);

	@UiField
	TextBox name;

	@UiField
	TextBox logoUrl;

	@UiField
	TextBox title;

	@UiField
	TextBox description;

	@UiField
	TextBox videoUrl;

	@UiField
	TextBox skipText;

	@UiField
	TextBox ctaText;

	@UiField
	TextBox ctaBackgroundImgUrl;

	@UiField
	TextBox ctaLogoUrl;

	@UiField
	TextBox ctaBtnColor;

	@UiField
	TextBox thnxTxt;

	@UiField
	TextBox thnxBackgroundImgUrl;

	@UiField
	TextBox thnxLogoUrl;

	@UiField
	TextBox facebookThumbnailUrl;

	@UiField
	TextBox facebookTitle;

	@UiField
	TextBox facebookDescription;

	public CampaignEditor() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
