package com.dch.tutorial.camunda.listener;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Class that implements {@link TaskListener} to call custom business logic in
 * task listener. Using {@code @Service} because we use Delegate Expression in
 * BPMN file.
 *
 * @author David.Christianto
 */
@Service
public class TaskCreateListener implements TaskListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskCreateListener.class);

    /**
     * If {@code delegateTask.getEventName()} equals with
     * {@link EVENTNAME_CREATE}, then listener will set assignee to "demo".
     * user.
     */
    @Override
    public void notify(DelegateTask delegateTask) {
        if (delegateTask.getEventName().equals(EVENTNAME_CREATE)) {
            delegateTask.setAssignee("demo");
            LOGGER.info("----------------------------- Set assignee to " + delegateTask.getAssignee());
        }

        LOGGER.info("----------------------------- End create event");
    }

}
