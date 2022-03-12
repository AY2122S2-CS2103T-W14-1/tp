package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.book.Book;

/**
 * Panel containing the list of patrons.
 */
public class BookListPanel extends UiPart<Region> {
    private static final String FXML = "BookListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(BookListPanel.class);

    @FXML
    private ListView<Book> bookListView;

    /**
     * Creates a {@code BookListPanel} with the given {@code ObservableList}.
     */
    public BookListPanel(ObservableList<Book> bookList) {
        super(FXML);
        bookListView.setItems(bookList);
        bookListView.setCellFactory(listView -> new BookListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Book} using a {@code BookCard}.
     */
    class BookListViewCell extends ListCell<Book> {
        @Override
        protected void updateItem(Book bookStub, boolean empty) {
            super.updateItem(bookStub, empty);

            if (empty || bookStub == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new BookCard(bookStub, getIndex() + 1).getRoot());
            }
        }
    }

}
