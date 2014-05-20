package mobi.nuuvo.frimgle.client.application.campaign;

import com.gwtplatform.mvp.client.UiHandlers;

public interface CampaignUiHandlers extends UiHandlers {
    void save();

    void cancel();

    void updateDirtyStatus();
}
