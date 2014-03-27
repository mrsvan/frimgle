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

package mobi.nuuvo.frimgle.server.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mobi.nuuvo.frimgle.server.dao.objectify.OfyService;
import mobi.nuuvo.frimgle.shared.domain.BaseEntity;

import com.google.common.collect.Lists;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.cmd.LoadType;

/**
 * The Class BaseDao.
 *
 * @param <T>
 *            the generic type
 */
public abstract class BaseDao<T extends BaseEntity> {

	/** The clazz. */
	private final Class<T> clazz;

	/** The lazy ofy. */
	private Objectify lazyOfy;

	/**
	 * Instantiates a new base dao.
	 *
	 * @param clazz
	 *            the clazz
	 */
	protected BaseDao(final Class<T> clazz) {
		this.clazz = clazz;
	}

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	public List<T> getAll() {
		return query().list();
	}

	/**
	 * Increment the entity's version and save it to the datastore.
	 *
	 * @param object
	 *            the object
	 * @return the t
	 */
	public T put(T object) {
		object.setVersion(object.getVersion() + 1);
		ofy().save().entity(object).now();

		return object;
	}

	/**
	 * Increments multiple entities' version and saves them to the datastore.
	 *
	 * @param entities
	 *            the entities
	 * @return the collection
	 */
	public Collection<T> put(Iterable<T> entities) {
		for (T entity : entities) {
			entity.setVersion(entity.getVersion() + 1);
		}
		return ofy().save().entities(entities).now().values();
	}

	/**
	 * Gets the.
	 *
	 * @param key
	 *            the key
	 * @return the t
	 */
	public T get(Key<T> key) {
		return ofy().load().key(key).now();
	}

	/**
	 * Gets the.
	 *
	 * @param id
	 *            the id
	 * @return the t
	 */
	public T get(Long id) {
		// work around for objectify cacheing and new query not having the
		// latest
		// data
		ofy().clear();

		return query().id(id).now();
	}

	/**
	 * Exists.
	 *
	 * @param key
	 *            the key
	 * @return the boolean
	 */
	public Boolean exists(Key<T> key) {
		return get(key) != null;
	}

	/**
	 * Exists.
	 *
	 * @param id
	 *            the id
	 * @return the boolean
	 */
	public Boolean exists(Long id) {
		return get(id) != null;
	}

	/**
	 * Gets the subset.
	 *
	 * @param ids
	 *            the ids
	 * @return the subset
	 */
	public List<T> getSubset(List<Long> ids) {
		return new ArrayList<T>(query().ids(ids).values());
	}

	/**
	 * Gets the subset map.
	 *
	 * @param ids
	 *            the ids
	 * @return the subset map
	 */
	public Map<Long, T> getSubsetMap(List<Long> ids) {
		return new HashMap<Long, T>(query().ids(ids));
	}

	/**
	 * Delete.
	 *
	 * @param object
	 *            the object
	 */
	public void delete(T object) {
		ofy().delete().entity(object).now();
	}

	/**
	 * Delete.
	 *
	 * @param id
	 *            the id
	 */
	public void delete(Long id) {
		Key<T> key = Key.create(clazz, id);
		ofy().delete().entity(key).now();
	}

	/**
	 * Delete.
	 *
	 * @param objects
	 *            the objects
	 */
	public void delete(List<T> objects) {
		ofy().delete().entities(objects).now();
	}

    /**
     * Find total count.
     *
     * @return the integer
     */
    public Integer findTotalCount() {
        return query().count();
    }

	/**
	 * Gets the.
	 *
	 * @param keys
	 *            the keys
	 * @return the list
	 */
	public List<T> get(List<Key<T>> keys) {
		return Lists.newArrayList(ofy().load().keys(keys).values());
	}

	/**
	 * Ofy.
	 *
	 * @return the objectify
	 */
	protected Objectify ofy() {
		if (lazyOfy == null) {
			lazyOfy = OfyService.ofy();
		}
		return lazyOfy;
	}

	/**
	 * Query.
	 *
	 * @return the load type
	 */
	protected LoadType<T> query() {
		return ofy().load().type(clazz);
	}
}
