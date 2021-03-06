/*
 *   Copyright (c) 2013 Intellectual Reserve, Inc.  All rights reserved.
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
package cf.client.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Mike Heath
 */
public class SharedDomain extends Domain {

	
	private final UUID router_group_guid;

	public SharedDomain(
			@JsonProperty("name") String name,
			@JsonProperty("router_group_guid") UUID router_group_guid) {
		super(name);
		this.router_group_guid = router_group_guid;
	}


	public UUID getRouter_group_guid() {
		return router_group_guid;
	}


}
