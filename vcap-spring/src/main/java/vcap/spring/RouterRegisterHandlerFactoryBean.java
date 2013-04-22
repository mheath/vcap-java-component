/*
 *   Copyright (c) 2013 Mike Heath.  All rights reserved.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */
package vcap.spring;

import nats.vcap.NatsVcap;
import nats.vcap.RouterRegisterHandler;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;

import java.util.List;

/**
 * @author Mike Heath <elcapo@gmail.com>
 */
public class RouterRegisterHandlerFactoryBean implements DisposableBean, FactoryBean<RouterRegisterHandler> {

	private final RouterRegisterHandler routerRegisterHandler;

	public RouterRegisterHandlerFactoryBean(NatsVcap natsVcap, String host, Integer port, List<String> uris) {
		routerRegisterHandler = new RouterRegisterHandler(natsVcap, host, port, uris);
	}

	@Override
	public void destroy() throws Exception {
		routerRegisterHandler.close();
	}

	@Override
	public RouterRegisterHandler getObject() throws Exception {
		return routerRegisterHandler;
	}

	@Override
	public Class<?> getObjectType() {
		return routerRegisterHandler.getClass();
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}