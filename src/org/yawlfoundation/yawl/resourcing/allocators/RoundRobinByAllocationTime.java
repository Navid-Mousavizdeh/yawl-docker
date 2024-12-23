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

package org.yawlfoundation.yawl.resourcing.allocators;

import org.yawlfoundation.yawl.engine.interfce.WorkItemRecord;
import org.yawlfoundation.yawl.resourcing.datastore.eventlog.EventLogger;
import org.yawlfoundation.yawl.resourcing.datastore.eventlog.ResourceEvent;
import org.yawlfoundation.yawl.resourcing.resource.Participant;

import java.util.*;

/**
 * Allocates a workitem to a participant on a round-robin basis, to the participant who
 * has not performed the task for the longest time.
 *
 *  Create Date: 23/08/2007. Last Date: 12/11/2007
 *
 *  @author Michael Adams (BPM Group, QUT Australia)
 *  @version 2.0
 */

public class RoundRobinByAllocationTime extends AbstractAllocator {

    public RoundRobinByAllocationTime() {
        super();
        setName(this.getClass().getSimpleName()) ;        
        setDisplayName("Round Robin (by Allocation time)");
        setDescription("The Round-Robin (by Allocation Time) allocator distributes a " +
                "workitem to the participant in the distribution set who was allocated " +
                "(as opposed to completed) the task the least recently.");
    }


    public Participant performAllocation(Set<Participant> participants,
                                         WorkItemRecord wir) {
        Participant chosen = null;
        long maxTime = Long.MAX_VALUE;                                     // initiator
        if ((participants != null) && (!participants.isEmpty())) {
            if (participants.size() == 1) {
                chosen = participants.iterator().next();               // only one in set
            }
            else {
                // more than one part. in the set
                List events = getLoggedEvents(wir, EventLogger.event.allocate);
                if (! events.isEmpty()) {
                    for (Participant p : filterForLowestFrequency(participants, events)) {
                        long eventTime = getEarliestTime(events, p);
                        if (eventTime == Long.MAX_VALUE) {
                            chosen = p; break;         // this p has never performed item
                        }
                        else {
                            if (eventTime < maxTime) {
                                chosen = p ;
                                maxTime = eventTime ;
                            }
                        }
                    }
                }
                else {

                    // if log is unavailable, default to a random choice
                    chosen = new RandomChoice().performAllocation(participants, wir);
                }
            }
        }
        return chosen;
    }


    private long getEarliestTime(List events, Participant p) {
        long result = Long.MAX_VALUE;
        Iterator itr = events.iterator();
        while (itr.hasNext()) {
            ResourceEvent event = (ResourceEvent) itr.next();
            if (event.get_resourceID().equals(p.getID()) &&
               (event.get_timeStamp() < result))
                 result = event.get_timeStamp();
        }
        return result;
    }

}
