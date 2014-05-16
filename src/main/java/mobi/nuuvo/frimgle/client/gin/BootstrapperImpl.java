/**
 * Copyright 2012 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package mobi.nuuvo.frimgle.client.gin;

import javax.inject.Inject;

import mobi.nuuvo.frimgle.client.dispatch.AsyncCallbackImpl;
import mobi.nuuvo.frimgle.shared.dispatch.FetchCurrentUserAction;
import mobi.nuuvo.frimgle.shared.dispatch.FetchCurrentUserResult;
import mobi.nuuvo.frimgle.shared.dto.CurrentUserDto;

import com.google.gwt.user.client.ui.RootPanel;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Bootstrapper;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

public class BootstrapperImpl implements Bootstrapper {
    private final PlaceManager placeManager;
    private final DispatchAsync dispatcher;
    private final CurrentUserDto currentUserDto;

    @Inject
    public BootstrapperImpl(PlaceManager placeManager, DispatchAsync dispatcher, CurrentUserDto currentUserDto) {
        this.placeManager = placeManager;
        this.dispatcher = dispatcher;
        this.currentUserDto = currentUserDto;
    }

    @Override
    public void onBootstrap() {
        fetchCurrentUser();
    }

    private void fetchCurrentUser() {
        dispatcher.execute(new FetchCurrentUserAction(), new AsyncCallbackImpl<FetchCurrentUserResult>() {
            @Override
            public void onSuccess(FetchCurrentUserResult result) {
                onFetchCurrentUserSuccess(result.getCurrentUser());
            }

            @Override
            public void onFailure(Throwable caught) {
                super.onFailure(caught);
                placeManager.revealCurrentPlace();
            }
        });
    }

    private void onFetchCurrentUserSuccess(CurrentUserDto currentUser) {
        currentUserDto.copyFrom(currentUser);
    	RootPanel.get("loading").setVisible(false);
        placeManager.revealCurrentPlace();
    }
}
