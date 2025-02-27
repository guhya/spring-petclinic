/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.guhya.petclinic.module.common.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class WelcomeRestController {

	@GetMapping("/")
	public String welcome() {
		String welcome = "<pre>"
				+ "                 _                 		<br>"
				+ "                | |                		<br>"
				+ "   ___ __ _ _ __| |__   ___  _ __  		<br>"
				+ "  / __/ _` | '__| '_ \\ / _ \\| '_ \\ 	<br>"
				+ " | (_| (_| | |  | |_) | (_) | | | | 		<br>"
				+ "  \\___\\__,_|_|  |_.__/ \\___/|_| |_|	<br>"
				+ "			by eWIDEPLUS"
				+ "</pre>";
	
	
		return welcome;
	}

}
