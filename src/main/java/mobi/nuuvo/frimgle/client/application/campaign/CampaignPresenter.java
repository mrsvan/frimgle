package mobi.nuuvo.frimgle.client.application.campaign;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.ConstraintViolation;

import mobi.nuuvo.frimgle.client.application.ApplicationPresenter;
import mobi.nuuvo.frimgle.client.editor.CampaignEditor;
import mobi.nuuvo.frimgle.client.place.NameTokens;
import mobi.nuuvo.frimgle.client.requestfactory.FrimgleRequestFactory;
import mobi.nuuvo.frimgle.client.requestfactory.proxy.CampaignProxy;
import mobi.nuuvo.frimgle.client.requestfactory.requestcontext.CampaignRequestContext;
import mobi.nuuvo.frimgle.client.security.LoggedInGatekeeper;

import com.google.common.base.Strings;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.IsEditor;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;
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

public class CampaignPresenter extends
		Presenter<CampaignPresenter.MyView, CampaignPresenter.MyProxy>
		implements CampaignUiHandlers {

	/** The LOGGER constant for ProjectPresenter. */
	private static final Logger LOGGER = Logger
			.getLogger(CampaignPresenter.class.getName());

	interface Driver extends
			RequestFactoryEditorDriver<CampaignProxy, CampaignEditor> {
	}

	final Driver driver = GWT.create(Driver.class);

	final private Provider<FrimgleRequestFactory> requestFactoryProvider;
	final private PlaceManager placeManager;

	public interface MyView extends View, HasUiHandlers<CampaignUiHandlers>,
			IsEditor<CampaignEditor> {
	}

	@ProxyCodeSplit
	@NameToken(NameTokens.CAMPAIGN)
	@UseGatekeeper(LoggedInGatekeeper.class)
	public interface MyProxy extends ProxyPlace<CampaignPresenter> {
	}

	@Inject
	public CampaignPresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy,
			final Provider<FrimgleRequestFactory> requestFactoryProvider,
			final PlaceManager placeManager) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_SetMainContent);

		this.requestFactoryProvider = requestFactoryProvider;
		this.placeManager = placeManager;

		driver.initialize(placeManager.getEventBus(),
				requestFactoryProvider.get(), getView().asEditor());

		getView().setUiHandlers(this);
	}

	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
		final String idString = request.getParameter(
				NameTokens.EntityParameters.ID, null);

		if (null == idString) {
			placeManager.navigateBack();
		}

		EntityProxyId<CampaignProxy> entityId = null;
		try {
			entityId = requestFactoryProvider.get().getProxyId(idString);
		} catch (Exception e) {
			if (LOGGER.isLoggable(Level.FINEST)) {
				LOGGER.log(Level.FINEST,
						"Invalid entity id " + Strings.nullToEmpty(idString), e);
			}
			placeManager.navigateBack();
		}
		if (null != entityId) {
			requestFactoryProvider.get().find(entityId)
					.fire(new Receiver<CampaignProxy>() {
						@Override
						public void onSuccess(CampaignProxy proxy) {
							if (null != proxy) {
								CampaignRequestContext request = requestFactoryProvider
										.get().campaignRequest();
								request.put(proxy).to(
										new Receiver<CampaignProxy>() {
											@Override
											public void onSuccess(
													CampaignProxy response) {
												placeManager
														.setOnLeaveConfirmation(null);
												placeManager.navigateBack();
											}

											@Override
											public void onConstraintViolation(
													Set<ConstraintViolation<?>> violations) {
												driver.setConstraintViolations(violations);
											}
										});
								driver.edit(proxy, request);
								placeManager
										.setOnLeaveConfirmation("Are you sure you want to abandon the changes to this campaign?");
							} else {
								if (LOGGER.isLoggable(Level.FINEST)) {
									LOGGER.log(
											Level.FINEST,
											"Invalid project id "
													+ Strings
															.nullToEmpty(idString));
								}
								placeManager.navigateBack();
							}
						}
					});
		}
	}

	@Override
	public void save() {
		driver.flush().fire();
	}

	@Override
	public void cancel() {
		placeManager.navigateBack();
	}
}