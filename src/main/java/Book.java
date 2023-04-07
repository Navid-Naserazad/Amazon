public class Book extends Product {
    private String bookName;
    private String author;
    private int yearOfPublish;
    public Book(String name, double price, int quantity, String category, String bookName, String author, int yearOfPublish)
    {
        super(name, price, quantity, category);
        this.bookName = bookName;
        this.author = author;
        this.yearOfPublish = yearOfPublish;
    }

    public String getBookname() {
        return bookName;
    }

    public void setName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public void setYearOfPublish(int yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }

    @Override
    public String toString() {
        return super.toString() + "->" + "Book{" +
                "name='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", yearOfPublish=" + yearOfPublish +
                '}';
    }
}