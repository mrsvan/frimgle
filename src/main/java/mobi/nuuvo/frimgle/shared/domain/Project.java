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

package mobi.nuuvo.frimgle.shared.domain;

import java.util.Date;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Load;
import com.googlecode.objectify.annotation.Parent;

/**
 * The Class Project.
 */
@Entity
@Cache
public class Project extends BaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5566762732379759508L;

	/** The name. */
	private String name;

	/** The creation date */
	@Index
	Date dateCreated = new Date();

	/** The account. */
	@Load
	@Parent
	@Index
	private Ref<Account> account;

	/**
	 * Instantiates a new project.
	 */
	public Project() {
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the account.
	 *
	 * @return the account
	 */
	public Account getAccount() {
		return account == null ? null : account.get();
	}

	/**
	 * Sets the account.
	 *
	 * @param account
	 *            the new account
	 */
	public void setAccount(Account account) {
		this.account = safeRef(account);
	}
}
