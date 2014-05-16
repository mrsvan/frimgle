package mobi.nuuvo.frimgle.server.dao;

import javax.inject.Singleton;

import mobi.nuuvo.frimgle.server.authentication.CurrentUserDtoProvider;
import mobi.nuuvo.frimgle.shared.dto.CurrentUserDto;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class DaoTestModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(CurrentUserDtoProvider.class).in(Singleton.class);
		bind(CurrentUserDto.class).toProvider(CurrentUserDtoProvider.class).in(
				Scopes.SINGLETON);
	}

}
