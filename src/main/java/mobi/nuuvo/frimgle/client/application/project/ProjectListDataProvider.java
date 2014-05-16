package mobi.nuuvo.frimgle.client.application.project;

import java.util.ArrayList;
import java.util.List;

import mobi.nuuvo.frimgle.client.requestfactory.proxy.ProjectProxy;
import mobi.nuuvo.frimgle.client.requestfactory.requestcontext.ProjectRequestContext;

import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.web.bindery.requestfactory.shared.Receiver;

public class ProjectListDataProvider extends AsyncDataProvider<ProjectProxy> {
	private Provider<ProjectRequestContext> projectRequestProvider;

	@Inject
	public ProjectListDataProvider(
			Provider<ProjectRequestContext> projectRequestProvider) {
		this.projectRequestProvider = projectRequestProvider;
	}

	@Override
	protected void onRangeChanged(HasData<ProjectProxy> display) {
		projectRequestProvider.get().getAllMy()
				.fire(new Receiver<List<ProjectProxy>>() {
					@Override
					public void onSuccess(List<ProjectProxy> projectProxies) {
						updateRowData(0, projectProxies == null ? new ArrayList<ProjectProxy>() : projectProxies);
					}
				});
		projectRequestProvider.get().findMyTotalCount()
				.fire(new Receiver<Integer>() {
					@Override
					public void onSuccess(Integer count) {
						updateRowCount(count, true);
					}
				});

	}
}