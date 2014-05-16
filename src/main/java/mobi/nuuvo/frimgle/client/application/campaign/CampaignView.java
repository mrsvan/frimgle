package mobi.nuuvo.frimgle.client.application.campaign;

import mobi.nuuvo.frimgle.client.editor.CampaignEditor;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class CampaignView extends ViewWithUiHandlers<CampaignUiHandlers>
		implements CampaignPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, CampaignView> {
	}

	@UiField
	CampaignEditor campaignEditor;

	@Inject
	public CampaignView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}

	@UiHandler("saveBtn")
	void onSaveButtonClicked(ClickEvent event) {
		getUiHandlers().save();
	}

	@UiHandler("cancelBtn")
	void onCancelButtonClicked(ClickEvent event) {
		getUiHandlers().cancel();
	}

	@Override
	public CampaignEditor asEditor() {
		return campaignEditor;
	}
}
