package mobi.nuuvo.frimgle.client.application.project;

import com.google.gwt.cell.client.FieldUpdater;
import com.google.inject.Inject;
import com.google.inject.Provider;
import mobi.nuuvo.frimgle.client.requestfactory.proxy.ProjectProxy;
import mobi.nuuvo.frimgle.client.requestfactory.requestcontext.ProjectRequestContext;

/**
 * Updater for the editable list name column. Must be in presenter because needs
 * to fire requests.
 */
public class ProjectNameFieldUpdater implements FieldUpdater<ProjectProxy, String> {
	private Provider<ProjectRequestContext> projectRequestProvider;

	@Inject
	public ProjectNameFieldUpdater(
			Provider<ProjectRequestContext> projectRequestProvider) {
		this.projectRequestProvider = projectRequestProvider;
	}

	@Override
    public void update(int index, final ProjectProxy project, final String newName) {
        ProjectRequestContext projectRequest = projectRequestProvider.get();
        final String oldName = project.getName();
        ProjectProxy editable = projectRequest.edit(project);
        editable.setName(newName);
        projectRequest.putMy(editable).fire();
    }
}