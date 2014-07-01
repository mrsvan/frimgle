package mobi.nuuvo.frimgle.client.requestfactory.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import mobi.nuuvo.frimgle.server.requestfactory.BaseLocator;

@ProxyFor(value = mobi.nuuvo.frimgle.shared.domain.Campaign.class, locator = BaseLocator.class)
public interface CampaignProxy extends EntityProxy {

    EntityProxyId<CampaignProxy> stableId();

    java.lang.Long getId();

    java.lang.Integer getVersion();

    public String getSkipButtonImgUrl();

    public void setSkipButtonImgUrl(String skipButtonImgUrl);

    public String getCtaTitleImgUrl();

    public void setCtaTitleImgUrl(String ctaTitleImgUrl);

    public String getCtaButtonImgUrl();

    public void setCtaButtonImgUrl(String ctaButtonImgUrl);

    public String getCtaRecipientEmail();

    public void setCtaRecipientEmail(String ctaRecipientEmail);

    public String getCtaPlaceholderText();

    public void setCtaPlaceholderText(String ctaPlaceholderText);

    /**
     * @return the logoUrl
     */
    public String getLogoUrl();

    /**
     * @param logoUrl the logoUrl to set
     */
    public void setLogoUrl(String logoUrl);

    /**
     * @return the videoUrl
     */
    public String getVideoUrl();

    /**
     * @param videoUrl the videoUrl to set
     */
    public void setVideoUrl(String videoUrl);

    /**
     * @return the ctaBackgroundImgUrl
     */
    public String getCtaBackgroundImgUrl();

    /**
     * @param ctaBackgroundImgUrl the ctaBackgroundImgUrl to set
     */
    public void setCtaBackgroundImgUrl(String ctaBackgroundImgUrl);

    /**
     * @return the thnxTxt
     */
    public String getThnxTxt();

    /**
     * @param thnxTxt the thnxTxt to set
     */
    public void setThnxTxt(String thnxTxt);

    /**
     * @return the facebookThumbnailUrl
     */
    public String getFacebookThumbnailUrl();

    /**
     * @param facebookThumbnailUrl the facebookThumbnailUrl to set
     */
    public void setFacebookThumbnailUrl(String facebookThumbnailUrl);

    /**
     * @return the facebookTitle
     */
    public String getFacebookTitle();

    /**
     * @param facebookTitle the facebookTitle to set
     */
    public void setFacebookTitle(String facebookTitle);

    /**
     * @return the facebookDescription
     */
    public String getFacebookDescription();

    /**
     * @param facebookDescription the facebookDescription to set
     */
    public void setFacebookDescription(String facebookDescription);

    /**
     * Gets the project.
     *
     * @return the project
     */
    public ProjectProxy getProject();

    /**
     * Sets the project.
     *
     * @param project the project to set
     */
    public void setProject(ProjectProxy project);

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName();

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name);
}