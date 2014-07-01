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

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * The Class Campaign.
 */
@Entity
@Cache
public class Campaign extends BaseEntity {
    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 4082856461761019085L;
    /**
     * The name.
     */
    @NotBlank(message = "You must provide a non-blank campaign name.")
    private String name;
    @Pattern(regexp = "^https?:\\/\\/(?:[a-z\\-]+\\.)+[a-z]{2,6}(?:\\/[^\\/#?]+)+\\.(?:jpe?g|gif|png)$", flags = Pattern.Flag.CASE_INSENSITIVE, message = "You must provide a valid image URL.")
    private String logoUrl, skipButtonImgUrl, ctaTitleImgUrl, ctaBackgroundImgUrl, ctaButtonImgUrl, facebookThumbnailUrl;
    @Pattern(regexp = "^https?:\\/\\/(?:[a-z\\-]+\\.)+[a-z]{2,6}(?:\\/[^\\/#?]+)+\\.(?:avi|wmv|flv|mpg|mp4|webm)$", flags = Pattern.Flag.CASE_INSENSITIVE, message = "You must provide a valid video URL.")
    private String videoUrl;
    private String ctaRecipientEmail, ctaPlaceholderText;
    private String thnxTxt;
    private String facebookTitle, facebookDescription;
    /**
     * The account.
     */
    @Load
    @Parent
    @Index
    private Ref<Project> project;

    public Campaign(final String name, final String logoUrl, final String skipButtonImgUrl, final String ctaTitleImgUrl, final String ctaBackgroundImgUrl, final String ctaButtonImgUrl, final String facebookThumbnailUrl, final String videoUrl, final String ctaRecipientEmail, final String ctaPlaceholderText, final String thnxTxt, final String facebookTitle, final String facebookDescription) {
        this.name = name;
        this.logoUrl = logoUrl;
        this.skipButtonImgUrl = skipButtonImgUrl;
        this.ctaTitleImgUrl = ctaTitleImgUrl;
        this.ctaBackgroundImgUrl = ctaBackgroundImgUrl;
        this.ctaButtonImgUrl = ctaButtonImgUrl;
        this.facebookThumbnailUrl = facebookThumbnailUrl;
        this.videoUrl = videoUrl;
        this.ctaRecipientEmail = ctaRecipientEmail;
        this.ctaPlaceholderText = ctaPlaceholderText;
        this.thnxTxt = thnxTxt;
        this.facebookTitle = facebookTitle;
        this.facebookDescription = facebookDescription;
    }

    /**
     * Instantiates a new user.
     */
    public Campaign() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSkipButtonImgUrl() {
        return skipButtonImgUrl;
    }

    public void setSkipButtonImgUrl(String skipButtonImgUrl) {
        this.skipButtonImgUrl = skipButtonImgUrl;
    }

    public String getCtaTitleImgUrl() {
        return ctaTitleImgUrl;
    }

    public void setCtaTitleImgUrl(String ctaTitleImgUrl) {
        this.ctaTitleImgUrl = ctaTitleImgUrl;
    }

    public String getCtaButtonImgUrl() {
        return ctaButtonImgUrl;
    }

    public void setCtaButtonImgUrl(String ctaButtonImgUrl) {
        this.ctaButtonImgUrl = ctaButtonImgUrl;
    }

    public String getCtaRecipientEmail() {
        return ctaRecipientEmail;
    }

    public void setCtaRecipientEmail(String ctaRecipientEmail) {
        this.ctaRecipientEmail = ctaRecipientEmail;
    }

    public String getCtaPlaceholderText() {
        return ctaPlaceholderText;
    }

    public void setCtaPlaceholderText(String ctaPlaceholderText) {
        this.ctaPlaceholderText = ctaPlaceholderText;
    }

    /**
     * @return the logoUrl
     */
    public String getLogoUrl() {
        return logoUrl;
    }

    /**
     * @param logoUrl the logoUrl to set
     */
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    /**
     * @return the videoUrl
     */
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     * @param videoUrl the videoUrl to set
     */
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    /**
     * @return the ctaBackgroundImgUrl
     */
    public String getCtaBackgroundImgUrl() {
        return ctaBackgroundImgUrl;
    }

    /**
     * @param ctaBackgroundImgUrl the ctaBackgroundImgUrl to set
     */
    public void setCtaBackgroundImgUrl(String ctaBackgroundImgUrl) {
        this.ctaBackgroundImgUrl = ctaBackgroundImgUrl;
    }

    /**
     * @return the thnxTxt
     */
    public String getThnxTxt() {
        return thnxTxt;
    }

    /**
     * @param thnxTxt the thnxTxt to set
     */
    public void setThnxTxt(String thnxTxt) {
        this.thnxTxt = thnxTxt;
    }

    /**
     * @return the facebookThumbnailUrl
     */
    public String getFacebookThumbnailUrl() {
        return facebookThumbnailUrl;
    }

    /**
     * @param facebookThumbnailUrl the facebookThumbnailUrl to set
     */
    public void setFacebookThumbnailUrl(String facebookThumbnailUrl) {
        this.facebookThumbnailUrl = facebookThumbnailUrl;
    }

    /**
     * @return the facebookTitle
     */
    public String getFacebookTitle() {
        return facebookTitle;
    }

    /**
     * @param facebookTitle the facebookTitle to set
     */
    public void setFacebookTitle(String facebookTitle) {
        this.facebookTitle = facebookTitle;
    }

    /**
     * @return the facebookDescription
     */
    public String getFacebookDescription() {
        return facebookDescription;
    }

    /**
     * @param facebookDescription the facebookDescription to set
     */
    public void setFacebookDescription(String facebookDescription) {
        this.facebookDescription = facebookDescription;
    }

    /**
     * Gets the project.
     *
     * @return the project
     */
    public Project getProject() {
        return project == null ? null : project.get();
    }

    /**
     * Sets the project.
     *
     * @param project the project to set
     */
    public void setProject(Project project) {
        this.project = safeRef(project);
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
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }
}
