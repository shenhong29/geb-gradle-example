package example.todomvc

import geb.spock.GebReportingSpec

class AngularTodoGebSpec extends GebReportingSpec {
    def 'should be able to add and remove a to-do item'() {
        given:
        AngularTodoPage todoPage = to(AngularTodoPage)

        when:
        todoPage.addToDo('My new item')

        then:
        waitFor { todoPage.numberOfToDoItems == 1 }

        assert todoPage.toDoItemTexts == ['My new item']

        when:
        todoPage.removeFirstToDoItem()

        then:
        waitFor { todoPage.numberOfToDoItems == 0 }
    }
}
