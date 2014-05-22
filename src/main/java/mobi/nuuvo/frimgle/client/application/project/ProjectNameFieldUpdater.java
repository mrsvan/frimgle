package mobi.nuuvo.frimgle.client.application.project;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.FluentIterable;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.web.bindery.requestfactory.shared.Receiver;
import mobi.nuuvo.frimgle.client.requestfactory.proxy.ProjectProxy;
import mobi.nuuvo.frimgle.client.requestfactory.requestcontext.ProjectRequestContext;
import org.gwtbootstrap3.extras.bootbox.client.Bootbox;

import javax.annotation.Nullable;
import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * Updater for the editable list name column. Must be in presenter because needs
 * to fire requests.
 */
public class ProjectNameFieldUpdater implements FieldUpdater<ProjectProxy, String> {
    private static final Function<ConstraintViolation<?>, String> ERROR_MSG = new Function<ConstraintViolation<?>, String>() {
        @Nullable
        @Override
        public String apply(@Nullable ConstraintViolation<?> input) {
            return input == null ? null : input.getMessage();
        }
    };

    private final ProjectPresenter.MyView view;
    private final Provider<ProjectRequestContext> projectRequestProvider;

    @Inject
    public ProjectNameFieldUpdater(final ProjectPresenter.MyView view,
                                   Provider<ProjectRequestContext> projectRequestProvider) {
        this.projectRequestProvider = projectRequestProvider;
        this.view = view;
    }

    @Override
    public void update(final int index, final ProjectProxy project, final String newName) {
        ProjectRequestContext projectRequest = projectRequestProvider.get();
        final String oldName = project.getName();
        final ProjectProxy editable = projectRequest.edit(project);
        editable.setName(newName);
        projectRequest.putMy(editable).fire(new Receiver<ProjectProxy>() {
            @Override
            public void onSuccess(ProjectProxy response) {
                // The project name was successfully updated, so we don't have to do anything special.
            }

            @Override
            public void onConstraintViolation(Set<ConstraintViolation<?>> violations) {
                Bootbox.alert(Joiner.on("/n").skipNulls().join(FluentIterable.from(violations).transform(ERROR_MSG)).toString());
                editable.setName(oldName);
                ((EditTextCell) view.getTitleColumn().getCell()).clearViewData(project);
                view.getTable().setVisibleRangeAndClearData(view.getTable().getVisibleRange(), true);
            }
        });
    }
}