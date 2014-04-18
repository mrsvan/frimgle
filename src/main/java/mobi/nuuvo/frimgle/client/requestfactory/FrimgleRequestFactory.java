package mobi.nuuvo.frimgle.client.requestfactory;

import mobi.nuuvo.frimgle.client.requestfactory.requestcontext.AccountRequestContext;
import mobi.nuuvo.frimgle.client.requestfactory.requestcontext.CampaignRequestContext;
import mobi.nuuvo.frimgle.client.requestfactory.requestcontext.ProjectRequestContext;
import mobi.nuuvo.frimgle.client.requestfactory.requestcontext.UserRequestContext;

import com.google.web.bindery.requestfactory.shared.RequestFactory;

/**
 * A factory for creating FrimgleRequest objects.
 */
public interface FrimgleRequestFactory extends RequestFactory {

	/**
	 * Account request.
	 *
	 * @return the account request context
	 */
	AccountRequestContext accountRequest();

	/**
	 * Campaign request.
	 *
	 * @return the campaign request context
	 */
	CampaignRequestContext campaignRequest();

	/**
	 * Project request.
	 *
	 * @return the project request context
	 */
	ProjectRequestContext projectRequest();

	/**
	 * User request.
	 *
	 * @return the user request context
	 */
	UserRequestContext userRequest();

}
