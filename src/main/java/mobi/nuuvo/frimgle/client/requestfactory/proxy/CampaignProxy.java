package mobi.nuuvo.frimgle.client.requestfactory.proxy;

import mobi.nuuvo.frimgle.server.requestfactory.BaseLocator;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(value = mobi.nuuvo.frimgle.shared.domain.Campaign.class, locator = BaseLocator.class)
public interface CampaignProxy extends EntityProxy {

	EntityProxyId<CampaignProxy> stableId();

	java.lang.Long getId();

	java.lang.Integer getVersion();

	java.lang.String getName();

	java.lang.String getLogoUrl();

	java.lang.String getTitle();

	java.lang.String getDescription();

	java.lang.String getVideoUrl();

	java.lang.String getSkipText();

	java.lang.String getCtaText();

	java.lang.String getCtaBackgroundImgUrl();

	java.lang.String getCtaLogoUrl();

	java.lang.String getCtaBtnColor();

	java.lang.String getThnxTxt();

	java.lang.String getThnxBackgroundImgUrl();

	java.lang.String getThnxLogoUrl();

	java.lang.String getFacebookThumbnailUrl();

	java.lang.String getFacebookTitle();

	java.lang.String getFacebookDescription();

	ProjectProxy getProject();

	void setName(java.lang.String name);

	void setLogoUrl(java.lang.String logoUrl);

	void setTitle(java.lang.String title);

	void setDescription(java.lang.String description);

	void setVideoUrl(java.lang.String videoUrl);

	void setSkipText(java.lang.String skipText);

	void setCtaText(java.lang.String ctaText);

	void setCtaBackgroundImgUrl(java.lang.String ctaBackgroundImgUrl);

	void setCtaLogoUrl(java.lang.String ctaLogoUrl);

	void setCtaBtnColor(java.lang.String ctaBtnColor);

	void setThnxTxt(java.lang.String thnxTxt);

	void setThnxBackgroundImgUrl(java.lang.String thnxBackgroundImgUrl);

	void setThnxLogoUrl(java.lang.String thnxLogoUrl);

	void setFacebookThumbnailUrl(java.lang.String facebookThumbnailUrl);

	void setFacebookTitle(java.lang.String facebookTitle);

	void setFacebookDescription(java.lang.String facebookDescription);

	void setProject(ProjectProxy project);

}
