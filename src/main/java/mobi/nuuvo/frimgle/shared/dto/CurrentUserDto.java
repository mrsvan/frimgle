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

package mobi.nuuvo.frimgle.shared.dto;

import mobi.nuuvo.frimgle.shared.domain.User;

// TODO: Auto-generated Javadoc
/**
 * The Class CurrentUserDto.
 */
public class CurrentUserDto implements Dto {

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4126001846233511606L;

	/** The is admin. */
	private Boolean isAdmin;

    /** The is logged in. */
    private Boolean isLoggedIn;

    /** The user. */
    private User user;

    /** The logout url. */
    private String logoutUrl;

    /** The login url. */
    private String loginUrl;

    /** The nickname. */
    private String nickname;

    /**
     * Instantiates a new current user dto.
     */
    public CurrentUserDto() {
        isAdmin = false;
        isLoggedIn = false;
        user = new User();
        loginUrl = "";
        logoutUrl = "";
    }

    /**
     * Instantiates a new current user dto.
     *
     * @param isLoggedIn the is logged in
     * @param user the user
     */
    public CurrentUserDto(Boolean isLoggedIn, User user) {
        this.isLoggedIn = isLoggedIn;
        this.user = user;
    }

    /**
     * Checks if is admin.
     *
     * @return the boolean
     */
    public Boolean isAdmin() {
        return isAdmin;
    }

    /**
     * Checks if is logged in.
     *
     * @return the boolean
     */
    public Boolean isLoggedIn() {
        return isLoggedIn;
    }

    /**
     * Gets the user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the logout url.
     *
     * @param logoutUrl the new logout url
     */
    public void setLogoutUrl(String logoutUrl) {
        this.logoutUrl = logoutUrl;
    }

    /**
     * Gets the logout url.
     *
     * @return the logout url
     */
    public String getLogoutUrl() {
        return logoutUrl;
    }

    /**
     * Sets the login url.
     *
     * @param loginUrl the new login url
     */
    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    /**
     * Gets the login url.
     *
     * @return the login url
     */
    public String getLoginUrl() {
        return loginUrl;
    }

    /**
     * Sets the nickname.
     *
     * @param nickname the new nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Gets the nickname.
     *
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Copy from.
     *
     * @param currentUser the current user
     */
    public void copyFrom(CurrentUserDto currentUser) {
        isAdmin = currentUser.isAdmin;
        isLoggedIn = currentUser.isLoggedIn;
        user = currentUser.user;
        logoutUrl = currentUser.logoutUrl;
        loginUrl = currentUser.loginUrl;
        nickname = currentUser.nickname;
    }

    /**
     * Sets the checks if is admin.
     *
     * @param isAdmin the new checks if is admin
     */
    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}
