/*-
 * ============LICENSE_START=======================================================
 * Copyright (C) 2019 AT&T Intellectual Property. All rights reserved.
 * ================================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 * ============LICENSE_END=========================================================
 */

package org.onap.policy.pdpx.main.rest;

import com.openpojo.reflection.filters.FilterClassName;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

import org.junit.Test;
import org.onap.policy.common.utils.validation.ToStringTester;
import org.onap.policy.pdpx.main.rest.model.StatisticsReport;

/**
 * Class to perform unit testing of {@link StatisticsReport}.
 *
 */
public class TestStatisticsReport {

    @Test
    public void testStatisticsReport() {
        final Validator validator = ValidatorBuilder.create().with(new ToStringTester()).with(new SetterMustExistRule())
                .with(new GetterMustExistRule()).with(new SetterTester()).with(new GetterTester()).build();
        validator.validate(StatisticsReport.class.getPackage().getName(),
                new FilterClassName(StatisticsReport.class.getName()));
    }
}
