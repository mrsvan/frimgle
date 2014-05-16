package mobi.nuuvo.frimgle.client.application.widget.campaignlist;

import mobi.nuuvo.frimgle.client.requestfactory.proxy.CampaignProxy;

import org.gwtbootstrap3.client.ui.CellTable;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.client.ui.Well;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.HasData;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class CampaignListView extends
		ViewWithUiHandlers<CampaignListUiHandlers> implements
		CampaignListPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, CampaignListView> {
	}

	@UiField(provided = true)
	CellTable<CampaignProxy> table = new CellTable<CampaignProxy>();

	@UiField
	TextBox nameTextBox;

	private Column<CampaignProxy, String> nameColumn;

	@Inject
	public CampaignListView(final Binder binder) {
		widget = binder.createAndBindUi(this);

		nameColumn = new Column<CampaignProxy, String>(new TextCell()) {
			@Override
			public String getValue(CampaignProxy campaign) {
				return campaign.getName();
			}
		};
		nameColumn
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LOCALE_START);
		table.addColumn(nameColumn);
		table.setEmptyTableWidget(new Well("No campaigns available"));
	}

	@Override
	public Widget asWidget() {
		return widget;
	}

	@Override
	public HasData<CampaignProxy> getTable() {
		return table;
	}

	@UiHandler("saveButton")
	void onSaveButtonClicked(ClickEvent event) {
		createCampaignAndClear();
	}

	@UiHandler("nameTextBox")
	void onNameTextBoxKeyPress(KeyPressEvent event) {
		if (KeyCodes.KEY_ENTER == event.getNativeEvent().getKeyCode()) {
			createCampaignAndClear();
		}
	}

	/**
	 * Calls the uiHandler to create a new project and clears the name textbox.
	 */
	private void createCampaignAndClear() {
		if (getUiHandlers() != null) {
			final String projectName = nameTextBox.getText();
			if (null != projectName && !projectName.trim().isEmpty()) {
				getUiHandlers().createCampaign(projectName.trim());
			}
			nameTextBox.clear();
		}
	}

	@Override
	public boolean isEnabled() {
		return nameTextBox.isEnabled();
	}

	@Override
	public void setEnabled(boolean enabled) {
		nameTextBox.setEnabled(enabled);
	}
}
