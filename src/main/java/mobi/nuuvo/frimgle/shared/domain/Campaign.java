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
import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Load;
import com.googlecode.objectify.annotation.Parent;

/**
 * The Class Campaign.
 */
@Entity
@Cache
public class Campaign extends BaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4082856461761019085L;

	/** The name. */
	private String name;

	private String logoUrl, title, description, videoUrl;

	private String skipText;

	private String ctaText;

	private String ctaBackgroundImgUrl;

	private String ctaLogoUrl;

	private String ctaBtnColor;

	private String thnxTxt;

	private String thnxBackgroundImgUrl;

	private String thnxLogoUrl;

	private String facebookThumbnailUrl;

	private String facebookTitle;

	private String facebookDescription;

	/** The account. */
	@Load
	@Parent
	@Index
	private Ref<Project> project;

	/**
	 * @return the logoUrl
	 */
	public String getLogoUrl() {
		return logoUrl;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the videoUrl
	 */
	public String getVideoUrl() {
		return videoUrl;
	}

	/**
	 * @return the skipText
	 */
	public String getSkipText() {
		return skipText;
	}

	/**
	 * @return the ctaText
	 */
	public String getCtaText() {
		return ctaText;
	}

	/**
	 * @return the ctaBackgroundImgUrl
	 */
	public String getCtaBackgroundImgUrl() {
		return ctaBackgroundImgUrl;
	}

	/**
	 * @return the ctaLogoUrl
	 */
	public String getCtaLogoUrl() {
		return ctaLogoUrl;
	}

	/**
	 * @return the ctaBtnColor
	 */
	public String getCtaBtnColor() {
		return ctaBtnColor;
	}

	/**
	 * @return the thnxTxt
	 */
	public String getThnxTxt() {
		return thnxTxt;
	}

	/**
	 * @return the thnxBackgroundImgUrl
	 */
	public String getThnxBackgroundImgUrl() {
		return thnxBackgroundImgUrl;
	}

	/**
	 * @return the thnxLogoUrl
	 */
	public String getThnxLogoUrl() {
		return thnxLogoUrl;
	}

	/**
	 * @return the facebookThumbnailUrl
	 */
	public String getFacebookThumbnailUrl() {
		return facebookThumbnailUrl;
	}

	/**
	 * @return the facebookTitle
	 */
	public String getFacebookTitle() {
		return facebookTitle;
	}

	/**
	 * @return the facebookDescription
	 */
	public String getFacebookDescription() {
		return facebookDescription;
	}

	/**
	 * @param logoUrl
	 *            the logoUrl to set
	 */
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param videoUrl
	 *            the videoUrl to set
	 */
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	/**
	 * @param skipText
	 *            the skipText to set
	 */
	public void setSkipText(String skipText) {
		this.skipText = skipText;
	}

	/**
	 * @param ctaText
	 *            the ctaText to set
	 */
	public void setCtaText(String ctaText) {
		this.ctaText = ctaText;
	}

	/**
	 * @param ctaBackgroundImgUrl
	 *            the ctaBackgroundImgUrl to set
	 */
	public void setCtaBackgroundImgUrl(String ctaBackgroundImgUrl) {
		this.ctaBackgroundImgUrl = ctaBackgroundImgUrl;
	}

	/**
	 * @param ctaLogoUrl
	 *            the ctaLogoUrl to set
	 */
	public void setCtaLogoUrl(String ctaLogoUrl) {
		this.ctaLogoUrl = ctaLogoUrl;
	}

	/**
	 * @param ctaBtnColor
	 *            the ctaBtnColor to set
	 */
	public void setCtaBtnColor(String ctaBtnColor) {
		this.ctaBtnColor = ctaBtnColor;
	}

	/**
	 * @param thnxTxt
	 *            the thnxTxt to set
	 */
	public void setThnxTxt(String thnxTxt) {
		this.thnxTxt = thnxTxt;
	}

	/**
	 * @param thnxBackgroundImgUrl
	 *            the thnxBackgroundImgUrl to set
	 */
	public void setThnxBackgroundImgUrl(String thnxBackgroundImgUrl) {
		this.thnxBackgroundImgUrl = thnxBackgroundImgUrl;
	}

	/**
	 * @param thnxLogoUrl
	 *            the thnxLogoUrl to set
	 */
	public void setThnxLogoUrl(String thnxLogoUrl) {
		this.thnxLogoUrl = thnxLogoUrl;
	}

	/**
	 * @param facebookThumbnailUrl
	 *            the facebookThumbnailUrl to set
	 */
	public void setFacebookThumbnailUrl(String facebookThumbnailUrl) {
		this.facebookThumbnailUrl = facebookThumbnailUrl;
	}

	/**
	 * @param facebookTitle
	 *            the facebookTitle to set
	 */
	public void setFacebookTitle(String facebookTitle) {
		this.facebookTitle = facebookTitle;
	}

	/**
	 * @param facebookDescription
	 *            the facebookDescription to set
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
	 * @param project
	 *            the project to set
	 */
	public void setProject(Project project) {
		this.project = safeRef(project);
	}

	/**
	 * Instantiates a new user.
	 */
	public Campaign() {
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
}
