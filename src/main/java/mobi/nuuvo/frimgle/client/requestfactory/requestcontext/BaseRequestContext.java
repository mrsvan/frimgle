package mobi.nuuvo.frimgle.client.requestfactory.requestcontext;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;

/**
 * The Interface BaseRequestContext should be extended to access services that
 * they themselves are extending BaseDao.
 */
@SuppressWarnings("requestfactory")
interface BaseRequestContext<T extends EntityProxy> extends RequestContext {
	Request<List<T>> getAll();
	Request<T> put(T entity);
	Request<T> get(Long id);
	Request<Boolean> exists(Long id);
	Request<List<T>> getSubset(List<Long> id);
	Request<Void> delete(T entity);
	Request<Void> delete(Long id);
	Request<Void> delete(List<T> entities);
	Request<Integer> findTotalCount();
}
