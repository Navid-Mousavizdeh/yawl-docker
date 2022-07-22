package org.yawlfoundation.yawl.stateless.listener.event;

/**
 * @author Michael Adams
 * @date 24/8/20
 */
public enum YEventType {
    ITEM_ENABLED,
    ITEM_STARTED,
    ITEM_COMPLETED,
    ITEM_STATUS_CHANGE,
    ITEM_CANCELLED,
    ITEM_DATA_VALUE_CHANGE,
    ITEM_ENABLED_REANNOUNCE,
    ITEM_STARTED_REANNOUNCE,
    CASE_STARTED,
    CASE_COMPLETED,
    CASE_CANCELLED,
    CASE_DEADLOCKED,
    CASE_SUSPENDING,
    CASE_SUSPENDED,
    CASE_RESUMED,
    CASE_UNLOADED,
    CASE_RESTORED,
    CASE_IDLE_TIMEOUT,
    TIMER_STARTED,
    TIMER_EXPIRED,
    TIMER_CANCELLED,
    ITEM_CHECK_PRECONSTRAINTS,
    ITEM_CHECK_POSTCONSTRAINTS,
    CASE_CHECK_PRECONSTRAINTS,
    CASE_CHECK_POSTCONSTRAINTS,
    ITEM_ABORT,
    NET_STARTED,
    NET_CANCELLED,
    NET_COMPLETED,
    NO_EVENT
}
