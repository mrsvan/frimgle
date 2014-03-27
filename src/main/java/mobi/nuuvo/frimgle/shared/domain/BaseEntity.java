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

import javax.persistence.Version;

import mobi.nuuvo.frimgle.shared.dto.Dto;

import com.google.common.base.Preconditions;
import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Id;

/**
 * The Class BaseEntity provides the basic fields for storage in a datastore.
 */
public abstract class BaseEntity implements Dto {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7592684008469377672L;

	/** The id. */
	@Id
	protected Long id;

	/** The version. */
	@Version
	protected Integer version = 1;

	/**
	 * Create a {@link Ref} safely (ie return null for a null object).
	 *
	 * @param <T>
	 *            the generic type
	 * @param entity
	 *            the entity
	 * @return the ref
	 * @throws IllegalArgumentException
	 *             if you provide the method with an entity that has not been
	 *             persisted yet.
	 */
	protected static <T extends BaseEntity> Ref<T> safeRef(T entity) {
		if (entity == null) {
			return null;
		} else {
			Preconditions.checkArgument(entity.getId() != null,
					"The provided entity must be persisted");
			return Ref.create(entity);
		}
	}

	/**
	 * Gets the version.
	 *
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * Sets the version.
	 *
	 * @param version
	 *            the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * Instantiates a new base entity.
	 */
	protected BaseEntity() {
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}

		BaseEntity other = (BaseEntity) obj;

		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}

		return true;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Checks if is saved.
	 *
	 * @return true, if is saved
	 */
	public boolean isSaved() {
		return (id != null);
	}
}
