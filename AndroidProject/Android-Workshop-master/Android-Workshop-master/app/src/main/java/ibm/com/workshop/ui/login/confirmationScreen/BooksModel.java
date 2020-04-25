package ibm.com.workshop.ui.login.confirmationScreen;

public class BooksModel {
    public int BookImage;
    public String bookName;

    public BooksModel(int bookImage, String bookName) {
        BookImage = bookImage;
        this.bookName = bookName;
    }

    public int getBookImage() {
        return BookImage;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookImage(int bookImage) {
        BookImage = bookImage;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}

