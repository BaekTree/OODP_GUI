5월 7일

ListPane.java
<pre>
class TaskListPane extends ListPane{
	protected void showGUI() {
		int N = TaskManagement.getTaskList().size();// How many Tasks
		for(int i = 0 ; i < N; i ++) {

			<b>Button TaskTitle = new Button("" + TaskManagement.getTaskList().get(i).getTitle() );
        //-> Management 클래스들을 다 하나로 묶는 부모클래스를 만들어서 strategy 패턴?</b>
			TaskTitle.setOnAction(new TaskSpecificHandler(i));
			getChildren().add(TaskTitle);

		}
		Button addBt = new Button("ADD");
		getChildren().add(0,addBt);
		<b>addBt.setOnAction(new AddTaskBtHandler());
    //-> 비슷한 Pane들끼리 비슷한 버튼을 부른다. strategy pattern?</b>
	}
}//TaskListPane
</pre>

5월 8일

1. class ListPane

	 adjust template method design pattern

	 template method: showGUI()
	 hook method: showList()

	 plus: the design pattern is adjusted to panes.

2. class ListPane
	tried factory method pattern on button handlers
	turned out it is impossible since the handlers themselves
	are the key specifier to distinguish which buttons are pressed.

3. class AddEachEntityBt
	separated from Handler class

	adjusted template method design pattern as well

	template method: handle()
	hook method: setPane()

	the design pattern is adjusted to handle method,
	this is the difference from the 1. ListPane pattern.

4. class SpecificHandler
	separated from Handler class

	adjusted template method design pattern

	template method: handle()
	hook method: setPane()

	same means used in 3. AddEachEntityBt
