/*
 *
 *  Copyright 2016-2018 Red Hat, Inc, and individual contributors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package io.openshift.booster.cache.name;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.arquillian.DefaultDeployment;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.notNullValue;

/**
 * @author Michal Szynkiewicz, michal.l.szynkiewicz@gmail.com
 * <br>
 * Date: 2/9/18
 */
@RunWith(Arquillian.class)
@DefaultDeployment
public class NameResourceTest {

    private static final String BASE_URI = "http://localhost:8080";

    @Test
    @RunAsClient
    public void testGetName() {
        // @formatter:off
        when()
                .get(BASE_URI + "/api/name")
        .then()
                .statusCode(200)
                .body("name", notNullValue());
        // @formatter:on
    }
}
