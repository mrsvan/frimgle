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

package mobi.nuuvo.frimgle.client.place;

/**
 * This class contains the constant name tokens for navigating within the
 * application.
 *
 * @author "Stefaan Vanderheyden (svd@nuuvo.mobi)"
 *
 */
public class NameTokens {
	public static final String HOME = "home";
	public static final String PROJECTS = "projects";
	public static final String CAMPAIGN = "campaign";

	public static class EntityParameters {
		public static final String ID = "id";
	}

	public static class ProjectsParameters extends EntityParameters {
	}

	public static class CampaignParameters extends EntityParameters {
	}

	/**
	 * NameTokens is a utility class with only static methods.
	 */
	protected NameTokens() {
		// Don't do anything;
	}
}
