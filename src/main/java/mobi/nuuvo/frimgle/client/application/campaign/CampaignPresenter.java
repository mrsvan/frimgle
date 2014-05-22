package mobi.nuuvo.frimgle.client.application.campaign;

import com.google.common.base.Strings;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.user.client.Window;
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
import mobi.nuuvo.frimgle.client.application.ApplicationPresenter;
import mobi.nuuvo.frimgle.client.editor.CampaignEditor;
import mobi.nuuvo.frimgle.client.place.NameTokens;
import mobi.nuuvo.frimgle.client.requestfactory.FrimgleRequestFactory;
import mobi.nuuvo.frimgle.client.requestfactory.proxy.CampaignProxy;
import mobi.nuuvo.frimgle.client.requestfactory.requestcontext.CampaignRequestContext;
import mobi.nuuvo.frimgle.client.security.LoggedInGatekeeper;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CampaignPresenter extends
        Presenter<CampaignPresenter.MyView, CampaignPresenter.MyProxy>
        implements CampaignUiHandlers {

    public static final String ON_LEAVE_CONFIRMATION = "You have made changes to this campaign and are about to abandon them without saving!";
    /**
     * The LOGGER constant for ProjectPresenter.
     */
    private static final Logger LOGGER = Logger
            .getLogger(CampaignPresenter.class.getName());
    final Driver driver = GWT.create(Driver.class);
    final private Provider<FrimgleRequestFactory> requestFactoryProvider;
    final private PlaceManager placeManager;

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

        Window.addWindowClosingHandler(new Window.ClosingHandler() {
            @Override
            public void onWindowClosing(Window.ClosingEvent event) {
                if (isBound() && driver.isDirty() && Strings.isNullOrEmpty(event.getMessage())) {
                    event.setMessage(ON_LEAVE_CONFIRMATION);
                } else {
                    event.setMessage(null);
                }
            }
        });
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
                                                clearConstraintViolations();
                                                placeManager
                                                        .setOnLeaveConfirmation(null);
                                                placeManager.navigateBack();
                                            }

                                            @Override
                                            public void onConstraintViolation(
                                                    Set<ConstraintViolation<?>> violations) {
                                                getView().addError("Please review the highlighted fields and correct the errors!");
                                                driver.setConstraintViolations(violations);
                                            }
                                        }
                                );
                                driver.edit(proxy, request);
                            } else {
                                if (LOGGER.isLoggable(Level.FINEST)) {
                                    LOGGER.log(
                                            Level.FINEST,
                                            "Invalid project id "
                                                    + Strings
                                                    .nullToEmpty(idString)
                                    );
                                }
                                placeManager.navigateBack();
                            }
                        }
                    });
        }
    }

    @Override
    public void save() {
        navigateBack(true);
    }

    @Override
    public void cancel() {
        navigateBack(false);
    }

    private void navigateBack(boolean save) {
        updateDirtyStatus();
        clearConstraintViolations();
        if (save && driver.isDirty()) {
            driver.flush().fire();
        } else {
            placeManager.navigateBack();
        }
    }

    private void clearConstraintViolations() {
        getView().clearErrors();
        driver.setConstraintViolations(new ArrayList<ConstraintViolation<?>>());
    }

    @Override
    public void updateDirtyStatus() {
        if (driver.isDirty()) {
            placeManager
                    .setOnLeaveConfirmation(ON_LEAVE_CONFIRMATION);
        } else {
            placeManager
                    .setOnLeaveConfirmation(null);
        }
    }

    interface Driver extends
            RequestFactoryEditorDriver<CampaignProxy, CampaignEditor> {
    }

    public interface MyView extends View, HasUiHandlers<CampaignUiHandlers>,
            IsEditor<CampaignEditor> {
        void addError(String errorMsg);

        void clearErrors();
    }

    @ProxyCodeSplit
    @NameToken(NameTokens.CAMPAIGN)
    @UseGatekeeper(LoggedInGatekeeper.class)
    public interface MyProxy extends ProxyPlace<CampaignPresenter> {
    }
}