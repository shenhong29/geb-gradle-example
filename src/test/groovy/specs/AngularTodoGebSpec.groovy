package specs

import geb.spock.GebReportingSpec
import org.junit.Rule
import org.junit.rules.TestName
import pages.AngularTodoPage

class AngularTodoGebSpec extends GebReportingSpec {

    @Rule
    TestName testName = new TestName();

    def todo1 = 'My new item 1'
    def todo2 = 'My new item 2'
    def todo3 = 'My new item 3'

    def toDoLIst = new ArrayList<>();

    def 'should be able to add 3 to-do items and remove 1 to-do_item'() {
        given:
        AngularTodoPage todoPage = to(AngularTodoPage)

        when:
        todoPage.addToDo(todo1)
        toDoLIst.add(todo1);
        todoPage.addToDo(todo2)
        toDoLIst.add(todo2);
        todoPage.addToDo(todo3)
        toDoLIst.add(todo3);

        then:
        waitFor { todoPage.numberOfToDoItems == 3 }

        assert todoPage.toDoItemTexts == toDoLIst

        when:
        todoPage.removeFirstToDoItem()

        then:
        waitFor { todoPage.numberOfToDoItems == 2 }
    }

}
