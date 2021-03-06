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

package mobi.nuuvo.frimgle.server.guice;

import com.google.inject.servlet.ServletModule;
import com.googlecode.objectify.ObjectifyFilter;
import com.gwtplatform.dispatch.rpc.server.guice.DispatchServiceImpl;
import com.gwtplatform.dispatch.rpc.shared.ActionImpl;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import mobi.nuuvo.frimgle.server.appcache.ManifestServlet;
import mobi.nuuvo.frimgle.server.rest.RestModule;

/**
 * The Class DispatchServletModule.
 */
public class DispatchServletModule extends ServletModule {

    /*
     * (non-Javadoc)
     *
     * @see com.google.inject.servlet.ServletModule#configureServlets()
     */
    @Override
    public void configureServlets() {
        filter("/*").through(ObjectifyFilter.class);
        serve("/" + ActionImpl.DEFAULT_SERVICE_NAME + "*").with(
                DispatchServiceImpl.class);
        install(new InjectedRequestFactoryModule());
        serve("/gwtRequest").with(InjectedRequestFactoryServlet.class);
        serve("/frimgle.appcache").with(ManifestServlet.class);
        install(new RestModule());
        serve("/rest/*").with(GuiceContainer.class);
    }
}
