package mobi.nuuvo.frimgle.client.application.widget.campaignlist;

import java.util.ArrayList;
import java.util.List;

import mobi.nuuvo.frimgle.client.requestfactory.proxy.CampaignProxy;
import mobi.nuuvo.frimgle.client.requestfactory.proxy.ProjectProxy;
import mobi.nuuvo.frimgle.client.requestfactory.requestcontext.CampaignRequestContext;

import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.web.bindery.requestfactory.shared.Receiver;

public class CampaignListDataProvider extends AsyncDataProvider<CampaignProxy> {
	private final Provider<CampaignRequestContext> projectRequestProvider;
	private ProjectProxy project;

	@Inject
	public CampaignListDataProvider(
			Provider<CampaignRequestContext> projectRequestProvider) {
		this.projectRequestProvider = projectRequestProvider;
	}

	@Override
	protected void onRangeChanged(HasData<CampaignProxy> display) {
		if (null != project) {
			projectRequestProvider.get().countWithProjectEquals(getProject())
					.fire(new Receiver<Integer>() {
						@Override
						public void onSuccess(Integer count) {
							updateRowCount(count, true);
						}
					});
			projectRequestProvider.get().findWithProjectEquals(getProject())
					.fire(new Receiver<List<CampaignProxy>>() {
						@Override
						public void onSuccess(List<CampaignProxy> projectProxies) {
							updateRowData(
									0,
									projectProxies == null ? new ArrayList<CampaignProxy>()
											: projectProxies);
						}
					});
		} else {
			updateRowCount(0, true);
			updateRowData(0, new ArrayList<CampaignProxy>());
		}
	}

	/**
	 * @return the project
	 */
	public ProjectProxy getProject() {
		return project;
	}

	/**
	 * @param project
	 *            the project to set
	 */
	public void setProject(ProjectProxy project) {
		this.project = project;
		for (HasData<CampaignProxy> display : getDataDisplays()) {
			onRangeChanged(display);
		}
	}
}