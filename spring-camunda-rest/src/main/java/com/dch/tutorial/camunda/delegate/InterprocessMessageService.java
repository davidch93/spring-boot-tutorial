package com.dch.tutorial.camunda.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Class that implements {@link JavaDelegate} to call custom business logic
 * about interprocess message. Using {@code @Service} because we use Delegate
 * Expression in BPMN file.
 * 
 * @author David.Christianto
 */
@Service
public class InterprocessMessageService implements JavaDelegate {

	private static final Logger LOGGER = LoggerFactory.getLogger(InterprocessMessageService.class);

	/**
	 * Execute service then notify message.
	 */
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		LOGGER.info("----------------------------- Start task and notify task to demo");
		execution.getProcessEngineServices().getRuntimeService().createMessageCorrelation("sendTask")
				.correlateWithResult();
	}

}
