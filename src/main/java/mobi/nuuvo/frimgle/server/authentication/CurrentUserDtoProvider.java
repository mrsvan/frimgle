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

package mobi.nuuvo.frimgle.server.authentication;

import javax.inject.Inject;
import javax.inject.Provider;

import mobi.nuuvo.frimgle.server.dao.UserDao;
import mobi.nuuvo.frimgle.shared.domain.User;
import mobi.nuuvo.frimgle.shared.dto.CurrentUserDto;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class CurrentUserDtoProvider implements Provider<CurrentUserDto> {
    private final UserService userService = UserServiceFactory.getUserService();
    private final UserDao userDao;

    @Inject
    public CurrentUserDtoProvider(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public CurrentUserDto get() {
        return getCurrentUserDto();
    }

    private CurrentUserDto getCurrentUserDto() {
        Boolean isLoggedIn = userService.isUserLoggedIn();

        CurrentUserDto currentUser = new CurrentUserDto(isLoggedIn, getUser());
        currentUser.setLogoutUrl(userService.createLogoutURL("/"));
        currentUser.setLoginUrl(userService.createLoginURL("/"));

        if (isLoggedIn) {
            currentUser.setIsAdmin(userService.isUserAdmin());
            currentUser.setNickname(userService.getCurrentUser().getNickname());
        }

        return currentUser;
    }

    private User getUser() {
        Boolean isLoggedIn = userService.isUserLoggedIn();

        User user = new User();
        if (isLoggedIn) {
            String googleId = userService.getCurrentUser().getUserId();

            user = userDao.findByGoogleId(googleId);
            if (user == null) {
                user = createUserForCurrentUser();
            }
        }
        return user;
    }

    private User createUserForCurrentUser() {
    	if (!userService.isUserLoggedIn()) {
    		return null;
    	}

        User user = new User();
        final com.google.appengine.api.users.User currentUser = userService.getCurrentUser();
		user.setGoogleId(currentUser.getUserId());
        user.setName(currentUser.getEmail());
        return userDao.put(user);
    }
}
