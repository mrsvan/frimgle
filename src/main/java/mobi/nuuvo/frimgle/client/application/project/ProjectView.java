package mobi.nuuvo.frimgle.client.application.project;

import mobi.nuuvo.frimgle.client.requestfactory.proxy.ProjectProxy;

import org.gwtbootstrap3.client.ui.CellTable;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.client.ui.Well;

import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.HasData;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class ProjectView extends ViewWithUiHandlers<ProjectUiHandlers>
		implements ProjectPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, ProjectView> {
	}

	@UiField(provided = true)
	CellTable<ProjectProxy> table = new CellTable<ProjectProxy>();

	@UiField
	TextBox nameTextBox;

	@UiField
	org.gwtbootstrap3.client.ui.Column campaignList;

	private Column<ProjectProxy, String> nameColumn;

	@Inject
	public ProjectView(final Binder binder) {
		widget = binder.createAndBindUi(this);

		nameColumn = new Column<ProjectProxy, String>(new EditTextCell()) {
			@Override
			public String getValue(ProjectProxy project) {
				return project.getName();
			}
		};
		nameColumn
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LOCALE_START);
		table.addColumn(nameColumn);
		table.setEmptyTableWidget(new Well("No projects available"));
	}

	@Override
	public Widget asWidget() {
		return widget;
	}

	@Override
	public HasData<ProjectProxy> getTable() {
		return table;
	}

	@Override
	public Column<ProjectProxy, String> getTitleColumn() {
		return nameColumn;
	}

	@UiHandler("saveButton")
	void onSaveButtonClicked(ClickEvent event) {
		createProjectAndClear();
	}

	@UiHandler("nameTextBox")
	void onNameTextBoxKeyPress(KeyPressEvent event) {
		if (KeyCodes.KEY_ENTER == event.getNativeEvent().getKeyCode()) {
			createProjectAndClear();
		}
	}

	/**
	 * Calls the uiHandler to create a new project and clears the name textbox.
	 */
	private void createProjectAndClear() {
		if (getUiHandlers() != null) {
			final String projectName = nameTextBox.getText();
			if (null != projectName && !projectName.trim().isEmpty()) {
				getUiHandlers().createProject(projectName.trim());
			}
			nameTextBox.clear();
		}
	}

	@Override
	public void setInSlot(Object slot, IsWidget content) {
		if (slot == ProjectPresenter.SLOT_CampaignListPresenter) {
			campaignList.clear();
			campaignList.add(content);
		} else {
			super.setInSlot(slot, content);
		}
	}

}
