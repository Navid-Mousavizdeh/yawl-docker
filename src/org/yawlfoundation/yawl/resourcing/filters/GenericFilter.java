/*
 * Copyright (c) 2004-2020 The YAWL Foundation. All rights reserved.
 * The YAWL Foundation is a collaboration of individuals and
 * organisations who are committed to improving workflow technology.
 *
 * This file is part of YAWL. YAWL is free software: you can
 * redistribute it and/or modify it under the terms of the GNU Lesser
 * General Public License as published by the Free Software Foundation.
 *
 * YAWL is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General
 * Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with YAWL. If not, see <http://www.gnu.org/licenses/>.
 */

package org.yawlfoundation.yawl.resourcing.filters;

import org.yawlfoundation.yawl.engine.interfce.WorkItemRecord;
import org.yawlfoundation.yawl.resourcing.resource.Participant;

import java.util.Map;
import java.util.Set;

/**
 * A base or generic filter class which allows external entities such as the
 * Editor the ability to instantiate it as a medium for specification XML generation
 * <p/>
 * Create Date: 14/08/2007. Last Date: 12/11/2007
 *
 * @author Michael Adams (BPM Group, QUT Australia)
 * @version 2.0
 */

public class GenericFilter extends AbstractFilter {

    public GenericFilter() {}

    public GenericFilter(String name) { super(name); }

    public GenericFilter(String name, Map<String, String> params) { super(name, params); }

    public Set<Participant> performFilter(Set<Participant> resources, WorkItemRecord wir) {
        return null;
    }

}
