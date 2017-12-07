# Camunda Rest
Camunda is a Java-based framework supporting BPMN for workflow and process automation, CMMN for Case Management and DMN for Business Decision Management.
The goal of the REST API is to provide access to all relevant interfaces of the engine.

## Best Practice
1. **Gateway, Event, Task**
   <br/>So in general, you must use **ExecutionListeners** on events and gateways, **JavaDelegates** on ServiceTasks and **TaskListeners** on UserTasks.
2. **Listeners**
   <br/>**ExecutionListener** is available for all elements and allows access to the **DelegateExecution**, while the **TaskListener** only applies to tasks (bpmn and cmmn) and gives you access to the **DelegateTask**.<br/>
   
   When the user task is executed
   - The execution listener is called
   - The task listener is called
   
   In general, the task listener event cycle is contained between execution listener events `start` and `end`. So the cycle when a user task is executed is:
   ```Java
   1. ExecutionListener#start
   2. TaskListener#create
   3. TaskListener#{assignment}*
   4. TaskListener#{complete, delete}
   5. ExecutionListener#end
   ```
