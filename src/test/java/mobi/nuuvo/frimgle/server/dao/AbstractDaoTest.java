package mobi.nuuvo.frimgle.server.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import mobi.nuuvo.frimgle.shared.domain.BaseEntity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalMemcacheServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.common.collect.ImmutableList;
import com.googlecode.objectify.Key;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractDaoTest implements the tests for the {@link BaseDao} class
 * that all our Dao classes extend.
 *
 * @param <T>
 *            the generic type
 * @param <U>
 *            the generic type
 */
public abstract class AbstractDaoTest<T extends BaseEntity, U extends BaseDao<T>> {

	/** The test entity. */
	protected T testEntity;

	/** The test dao. */
	protected U testDao = newDao();

	/** The helper. */
	private final LocalServiceTestHelper helper = new LocalServiceTestHelper(
			new LocalDatastoreServiceTestConfig(),
			new LocalMemcacheServiceTestConfig());

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() throws Exception {
		helper.setUp();
		testEntity = newEntity();
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@After
	public void tearDown() throws Exception {
		helper.tearDown();
	}

	/**
	 * New entity.
	 *
	 * @return the t
	 */
	abstract protected T newEntity();

	/**
	 * New dao.
	 *
	 * @return the u
	 */
	abstract protected U newDao();

	/**
	 * Test method for {@link mobi.nuuvo.frimgle.server.dao.BaseDao#getAll()}.
	 */
	@Test
	public void testGetAll() {
		assertTrue("The test datastore config should not contain any entries",
				testDao.getAll().isEmpty());
		testDao.put(testEntity);
		assertTrue("The test datastore config should not contain any entries",
				testDao.getAll().size() == 1);
	}

	/**
	 * Test method for
	 * {@link mobi.nuuvo.frimgle.server.dao.BaseDao#put(mobi.nuuvo.frimgle.shared.domain.BaseEntity)}
	 * .
	 */
	@Test
	public void testPutT() {
		testDao.put(testEntity);
		assertNotNull(
				"The test user has been saved and should not have a null ID",
				testEntity.getId());
	}

	/**
	 * Test method for
	 * {@link mobi.nuuvo.frimgle.server.dao.BaseDao#put(java.lang.Iterable)}.
	 */
	@Test
	public void testPutIterableOfT() {
		testDao.put(ImmutableList.of(testEntity, newEntity(), newEntity()));
		assertEquals(3, testDao.findTotalCount().intValue());
	}

	/**
	 * Test method for
	 * {@link mobi.nuuvo.frimgle.server.dao.BaseDao#get(com.googlecode.objectify.Key)}
	 * .
	 */
	@Test
	public void testGetKeyOfT() {
		testDao.put(testEntity);
		final Key<T> testEntityKey = Key.create(testEntity);
		assertNotNull(testDao.get(testEntityKey));
		assertEquals(testEntity, testDao.get(testEntityKey));
	}

	/**
	 * Test method for
	 * {@link mobi.nuuvo.frimgle.server.dao.BaseDao#get(java.lang.Long)}.
	 */
	@Test
	public void testGetLong() {
		testDao.put(testEntity);
		assertEquals(testEntity, testDao.get(testEntity.getId()));
	}

	/**
	 * Test method for
	 * {@link mobi.nuuvo.frimgle.server.dao.BaseDao#exists(com.googlecode.objectify.Key)}
	 * .
	 */
	@Test
	public void testExistsKeyOfT() {
		testDao.put(testEntity);
		final Key<T> testEntityKey = Key.create(testEntity);
		assertTrue(testDao.exists(testEntityKey));
	}

	/**
	 * Test method for
	 * {@link mobi.nuuvo.frimgle.server.dao.BaseDao#exists(java.lang.Long)}.
	 */
	@Test
	public void testExistsLong() {
		testDao.put(testEntity);
		assertTrue(testDao.exists(testEntity.getId()));
	}

	/**
	 * Test method for
	 * {@link mobi.nuuvo.frimgle.server.dao.BaseDao#getSubset(java.util.List)}.
	 */
	@Test
	public void testGetSubset() {
		testDao.put(ImmutableList.of(testEntity, newEntity(), newEntity()));
		assertEquals(3, testDao.findTotalCount().intValue());
		assertTrue(!testDao.getSubset(ImmutableList.of(testEntity.getId()))
				.isEmpty());
	}

	/**
	 * Test method for
	 * {@link mobi.nuuvo.frimgle.server.dao.BaseDao#getSubsetMap(java.util.List)}
	 * .
	 */
	@Test
	public void testGetSubsetMap() {
		testDao.put(ImmutableList.of(testEntity, newEntity(), newEntity()));
		assertEquals(3, testDao.findTotalCount().intValue());
		assertEquals(
				testEntity,
				testDao.getSubsetMap(ImmutableList.of(testEntity.getId())).get(
						testEntity.getId()));
	}

	/**
	 * Test method for
	 * {@link mobi.nuuvo.frimgle.server.dao.BaseDao#delete(mobi.nuuvo.frimgle.shared.domain.BaseEntity)}
	 * .
	 */
	@Test
	public void testDeleteT() {
		testDao.put(testEntity);
		final int count = testDao.findTotalCount();
		assertTrue("Test entity was not persisted correctly", count > 0);
		testDao.delete(testEntity);
		assertEquals(count - 1, testDao.findTotalCount().intValue());
	}

	/**
	 * Test method for
	 * {@link mobi.nuuvo.frimgle.server.dao.BaseDao#delete(java.lang.Long)}.
	 */
	@Test
	public void testDeleteLong() {
		testDao.put(testEntity);
		assertTrue(testDao.findTotalCount() > 0);
		testDao.delete(testEntity.getId());
		assertTrue(testDao.findTotalCount() == 0);
	}

	/**
	 * Test method for
	 * {@link mobi.nuuvo.frimgle.server.dao.BaseDao#delete(java.util.List)}.
	 */
	@Test
	public void testDeleteListOfT() {
		testDao.put(testEntity);
		assertTrue(testDao.findTotalCount() > 0);
		testDao.delete(ImmutableList.of(testEntity));
		assertTrue(testDao.findTotalCount() == 0);
	}

	/**
	 * Test method for
	 * {@link mobi.nuuvo.frimgle.server.dao.BaseDao#findTotalCount()}.
	 */
	@Test
	public void testFindTotalCount() {
		testDao.put(testEntity);
		assertTrue(testDao.findTotalCount() == 1);
	}

	/**
	 * Test method for
	 * {@link mobi.nuuvo.frimgle.server.dao.BaseDao#get(java.util.List)}.
	 */
	@Test
	public void testGetListOfKeyOfT() {
		testDao.put(ImmutableList.of(testEntity, newEntity(), newEntity()));
		assertEquals(3, testDao.findTotalCount().intValue());
		assertTrue(!testDao.get(ImmutableList.of(Key.create(testEntity)))
				.isEmpty());
	}

	/**
	 * Test method for {@link mobi.nuuvo.frimgle.server.dao.BaseDao#ofy()}.
	 */
	@Test
	public void testOfy() {
		assertNotNull(testDao.ofy());
	}

	/**
	 * Test method for {@link mobi.nuuvo.frimgle.server.dao.BaseDao#query()}.
	 */
	@Test
	public void testQuery() {
		assertNotNull(testDao.query());
	}
}
