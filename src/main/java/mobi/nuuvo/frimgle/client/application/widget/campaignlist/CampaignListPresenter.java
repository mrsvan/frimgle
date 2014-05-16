package mobi.nuuvo.frimgle.client.application.widget.campaignlist;

import mobi.nuuvo.frimgle.client.place.NameTokens;
import mobi.nuuvo.frimgle.client.requestfactory.FrimgleRequestFactory;
import mobi.nuuvo.frimgle.client.requestfactory.proxy.CampaignProxy;
import mobi.nuuvo.frimgle.client.requestfactory.proxy.ProjectProxy;
import mobi.nuuvo.frimgle.client.requestfactory.requestcontext.CampaignRequestContext;

import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.RangeChangeEvent;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionChangeEvent.Handler;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

public class CampaignListPresenter extends
		PresenterWidget<CampaignListPresenter.MyView> implements
		CampaignListUiHandlers {

	final private Provider<FrimgleRequestFactory> requestFactoryProvider;
	final private CampaignListDataProvider campaignListDataProvider;

	private ProjectProxy currentProject = null;
	private final SingleSelectionModel<CampaignProxy> selectionModel = new SingleSelectionModel<>();

	public interface MyView extends View,
			HasUiHandlers<CampaignListUiHandlers>, HasEnabled {
		HasData<CampaignProxy> getTable();
	}

	@Inject
	public CampaignListPresenter(final EventBus eventBus, final MyView view,
			final CampaignListDataProvider campaignListDataProvider,
			final Provider<FrimgleRequestFactory> requestFactoryProvider,
			final PlaceManager placeManager) {
		super(eventBus, view);
		getView().setUiHandlers(this);
		this.campaignListDataProvider = campaignListDataProvider;
		campaignListDataProvider.addDataDisplay(getView().getTable());
		this.requestFactoryProvider = requestFactoryProvider;

		selectionModel.addSelectionChangeHandler(new Handler() {

			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				CampaignProxy selectedCampaign = selectionModel
						.getSelectedObject();
				if (null != selectedCampaign) {
					PlaceRequest request = new PlaceRequest.Builder()
							.nameToken(NameTokens.CAMPAIGN)
							.with(NameTokens.CampaignParameters.ID,
									requestFactoryProvider.get()
											.getHistoryToken(
													selectedCampaign.stableId()))
							.build();
					placeManager.revealPlace(request);
					selectionModel.clear();
				}
			}
		});
		getView().getTable().setSelectionModel(selectionModel);	}

	@Override
	protected void onReveal() {
		super.onReveal();
		RangeChangeEvent.fire(getView().getTable(), getView().getTable()
				.getVisibleRange());
	}

	@Override
	public void createCampaign(String campaignName) {
		if (null != currentProject && null != campaignName
				&& !campaignName.trim().isEmpty()) {
			final CampaignRequestContext campaignRequestContext = requestFactoryProvider
					.get().campaignRequest();
			final CampaignProxy campaign = campaignRequestContext
					.create(CampaignProxy.class);
			campaign.setName(campaignName);
			campaign.setProject(currentProject);
			campaignRequestContext.put(campaign).fire(
					new Receiver<CampaignProxy>() {
						@Override
						public void onSuccess(CampaignProxy response) {
							RangeChangeEvent.fire(getView().getTable(),
									getView().getTable().getVisibleRange());
							selectionModel.setSelected(response, true);
						}
					});
		}
	}

	/**
	 * @return the currentProject
	 */
	public ProjectProxy getCurrentProject() {
		return currentProject;
	}

	/**
	 * @param currentProject
	 *            the currentProject to set
	 */
	public void setCurrentProject(ProjectProxy currentProject) {
		this.currentProject = currentProject;
		campaignListDataProvider.setProject(currentProject);
		getView().setEnabled(null != currentProject);
	}

}
