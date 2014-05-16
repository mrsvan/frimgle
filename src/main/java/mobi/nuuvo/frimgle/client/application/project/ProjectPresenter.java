package mobi.nuuvo.frimgle.client.application.project;

import java.util.logging.Level;
import java.util.logging.Logger;

import mobi.nuuvo.frimgle.client.application.ApplicationPresenter;
import mobi.nuuvo.frimgle.client.application.widget.campaignlist.CampaignListPresenter;
import mobi.nuuvo.frimgle.client.place.NameTokens;
import mobi.nuuvo.frimgle.client.requestfactory.FrimgleRequestFactory;
import mobi.nuuvo.frimgle.client.requestfactory.proxy.ProjectProxy;
import mobi.nuuvo.frimgle.client.requestfactory.requestcontext.ProjectRequestContext;
import mobi.nuuvo.frimgle.client.security.LoggedInGatekeeper;

import com.google.common.base.Strings;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.RangeChangeEvent;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionChangeEvent.Handler;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.UseGatekeeper;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

public class ProjectPresenter extends
		Presenter<ProjectPresenter.MyView, ProjectPresenter.MyProxy> implements
		ProjectUiHandlers {

	/** The LOGGER constant for ProjectPresenter. */
	private static final Logger LOGGER = Logger
			.getLogger(ProjectPresenter.class.getName());

	public static final Object SLOT_CampaignListPresenter = new Object();

	final private Provider<FrimgleRequestFactory> requestFactoryProvider;
	final private CampaignListPresenter campaignListPresenter;
	private final SingleSelectionModel<ProjectProxy> selectionModel = new SingleSelectionModel<>();

	public interface MyView extends View, HasUiHandlers<ProjectUiHandlers> {
		HasData<ProjectProxy> getTable();

		public Column<ProjectProxy, String> getTitleColumn();
	}

	@ProxyCodeSplit
	@NameToken(NameTokens.PROJECTS)
	@UseGatekeeper(LoggedInGatekeeper.class)
	public interface MyProxy extends ProxyPlace<ProjectPresenter> {
	}

	@Inject
	public ProjectPresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy,
			final ProjectListDataProvider projectListDataProvider,
			final ProjectNameFieldUpdater nameFieldUpdater,
			final Provider<FrimgleRequestFactory> requestFactoryProvider,
			final CampaignListPresenter campaignListPresenter,
			final PlaceManager placeManager) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_SetMainContent);

		this.requestFactoryProvider = requestFactoryProvider;
		this.campaignListPresenter = campaignListPresenter;

		getView().setUiHandlers(this);
		getView().getTitleColumn().setFieldUpdater(nameFieldUpdater);
		projectListDataProvider.addDataDisplay(getView().getTable());

		selectionModel.addSelectionChangeHandler(new Handler() {

			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				ProjectProxy selectedProject = selectionModel
						.getSelectedObject();
				if (null != selectedProject) {
					PlaceRequest request = new PlaceRequest.Builder()
							.nameToken(NameTokens.PROJECTS)
							.with(NameTokens.ProjectsParameters.ID,
									requestFactoryProvider.get()
											.getHistoryToken(
													selectedProject.stableId()))
							.build();
					placeManager.revealPlace(request);
				}
			}
		});
		getView().getTable().setSelectionModel(selectionModel);
	}

	@Override
	protected void onReset() {
		super.onReset();
		RangeChangeEvent.fire(getView().getTable(), getView().getTable()
				.getVisibleRange());
	}

	@Override
	protected void onBind() {
		super.onBind();
		setInSlot(SLOT_CampaignListPresenter, campaignListPresenter);
	}

	@Override
	public void createProject(String projectName) {
		if (null != projectName && !projectName.trim().isEmpty()) {
			final ProjectRequestContext projectRequestContext = requestFactoryProvider
					.get().projectRequest();
			final ProjectProxy project = projectRequestContext
					.create(ProjectProxy.class);
			project.setName(projectName);
			projectRequestContext.putMy(project).fire(
					new Receiver<ProjectProxy>() {
						@Override
						public void onSuccess(ProjectProxy response) {
							RangeChangeEvent.fire(getView().getTable(),
									getView().getTable().getVisibleRange());
							selectionModel.setSelected(response, true);
						}
					});
		}
	}

	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
		final String projectIdString = request.getParameter(
				NameTokens.ProjectsParameters.ID, null);

		EntityProxyId<ProjectProxy> projectId = null;
		try {
			projectId = requestFactoryProvider.get()
					.getProxyId(projectIdString);
		} catch (Exception e) {
			if (LOGGER.isLoggable(Level.FINEST)) {
				LOGGER.log(
						Level.FINEST,
						"Invalid project id "
								+ Strings.nullToEmpty(projectIdString), e);
			}
		}
		if (null != projectId) {
			requestFactoryProvider.get().find(projectId)
					.fire(new Receiver<ProjectProxy>() {
						@Override
						public void onSuccess(ProjectProxy response) {
							if (null != response) {
								getView().getTable().getSelectionModel()
										.setSelected(response, true);
								campaignListPresenter
										.setCurrentProject(response);
							} else {
								if (LOGGER.isLoggable(Level.FINEST)) {
									LOGGER.log(
											Level.FINEST,
											"Invalid project id "
													+ Strings
															.nullToEmpty(projectIdString));
								}
							}
						}
					});
		}
	}
}