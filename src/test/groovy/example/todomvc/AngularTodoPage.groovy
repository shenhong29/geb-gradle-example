package example.todomvc

import geb.Page
import org.openqa.selenium.Keys

class AngularTodoPage extends Page {
    static url = "http://todomvc.com/examples/angularjs"

    static at = { title.contains('Angular') }

    static content = {
        newToDoField { $("input[ng-model='newTodo']") }
        removeTodoLink(required: false) { $(".destroy") }
        toDoItems(required: false) { $(".view").find('label') }
    }

    void addToDo(String newToDo) {
        waitFor { newToDoField.displayed }

        newToDoField = newToDo
        newToDoField << Keys.ENTER
    }

    List<String> getToDoItemTexts() {
        toDoItems.collect { it.text().trim() }
    }

    Integer getNumberOfToDoItems() {
        toDoItems.size()
    }

    void removeFirstToDoItem() {
        def firstToDoItem = toDoItems.first()

        interact {
            moveToElement(firstToDoItem)
        }

        waitFor { removeTodoLink.displayed }

        removeTodoLink.click()
    }
}
