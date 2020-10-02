/*-
 * ============LICENSE_START=======================================================
 * ONAP
 * ================================================================================
 * Copyright (C) 2019-2020 AT&T Intellectual Property. All rights reserved.
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

package org.onap.policy.xacml.pdp.application.naming;

import java.util.Arrays;
import org.onap.policy.models.tosca.authorative.concepts.ToscaPolicyTypeIdentifier;
import org.onap.policy.pdp.xacml.application.common.ToscaPolicyTranslator;
import org.onap.policy.pdp.xacml.application.common.std.StdCombinedPolicyResultsTranslator;
import org.onap.policy.pdp.xacml.application.common.std.StdXacmlApplicationServiceProvider;

public class NamingPdpApplication extends StdXacmlApplicationServiceProvider {

    private static final ToscaPolicyTypeIdentifier namingPolicyType = new ToscaPolicyTypeIdentifier(
            "onap.policies.Naming", "1.0.0");

    private StdCombinedPolicyResultsTranslator translator = new StdCombinedPolicyResultsTranslator();

    /**
     * Constructor.
     */
    public NamingPdpApplication() {
        super();

        applicationName = "naming";
        actions = Arrays.asList("naming");
        supportedPolicyTypes.add(namingPolicyType);
    }

    @Override
    public boolean canSupportPolicyType(ToscaPolicyTypeIdentifier policyTypeId) {
        return namingPolicyType.equals(policyTypeId);
    }

    @Override
    protected ToscaPolicyTranslator getTranslator(String type) {
        //
        // Return translator
        //
        return translator;
    }
}
