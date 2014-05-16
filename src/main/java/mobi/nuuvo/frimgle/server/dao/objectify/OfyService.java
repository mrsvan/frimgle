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

package mobi.nuuvo.frimgle.server.dao.objectify;

import mobi.nuuvo.frimgle.shared.domain.Account;
import mobi.nuuvo.frimgle.shared.domain.Campaign;
import mobi.nuuvo.frimgle.shared.domain.Project;
import mobi.nuuvo.frimgle.shared.domain.User;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

/**
 * For use of: import static
 * com.sceneverse.shozon.server.dao.objectify.OfyService.ofy;
 */
public class OfyService {
	static {
		factory().register(Account.class);
		factory().register(Campaign.class);
		factory().register(Project.class);
		factory().register(User.class);

	}

	public static Objectify ofy() {
		return ObjectifyService.ofy();
	}

	public static ObjectifyFactory factory() {
		return ObjectifyService.factory();
	}
}
