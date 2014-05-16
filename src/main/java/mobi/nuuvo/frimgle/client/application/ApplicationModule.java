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

package mobi.nuuvo.frimgle.client.application;

import mobi.nuuvo.frimgle.client.application.campaign.CampaignModule;
import mobi.nuuvo.frimgle.client.application.home.HomeModule;
import mobi.nuuvo.frimgle.client.application.project.ProjectModule;
import mobi.nuuvo.frimgle.client.application.widget.WidgetModule;
import mobi.nuuvo.frimgle.client.requestfactory.FrimgleRequestFactory;
import mobi.nuuvo.frimgle.client.requestfactory.requestcontext.CampaignRequestContext;
import mobi.nuuvo.frimgle.client.requestfactory.requestcontext.ProjectRequestContext;

import com.google.gwt.core.shared.GWT;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ApplicationModule extends AbstractPresenterModule {
	@Override
	protected void configure() {
		install(new HomeModule());
		install(new ProjectModule());
		install(new CampaignModule());
		install(new WidgetModule());

		bindPresenter(ApplicationPresenter.class,
				ApplicationPresenter.MyView.class, ApplicationView.class,
				ApplicationPresenter.MyProxy.class);
	}

	@Provides
	@Singleton
	FrimgleRequestFactory providesFrimgleRequestFactory(EventBus eventBus) {
		FrimgleRequestFactory requestFactory = GWT
				.create(FrimgleRequestFactory.class);
		requestFactory.initialize(eventBus);
		return requestFactory;
	}

	@Provides
	ProjectRequestContext provideProjectRequest(
			FrimgleRequestFactory requestFactory) {
		return requestFactory.projectRequest();
	}

	@Provides
	CampaignRequestContext provideCampaignRequest(
			FrimgleRequestFactory requestFactory) {
		return requestFactory.campaignRequest();
	}
}
