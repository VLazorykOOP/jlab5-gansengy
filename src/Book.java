import java.util.Scanner;

class Book extends PrintedPublication /*implements Comparable<Book>*/ {
    private int pageCount;
    public Book(String title, String author, int year, int pageCount) {
        super(title, author, year);
        this.pageCount = pageCount;
    }

    public void show() {
        super.show();
        System.out.println("Page Count: " + pageCount);
    }

    public static Book createFromInput() {
        PrintedPublication printedPublication = PrintedPublication.createFromInput();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the page count: ");
        int pageCount = scanner.nextInt();
        return new Book(printedPublication.getTitle(), printedPublication.getAuthor(), printedPublication.getYear(), pageCount);
    }

    public int getPageCount() {
        return pageCount;
    }
    /*@Override
    public int compareTo(Book other) {
        // Compare based on title
        return getTitle().compareTo(other.getTitle());
    }*/
}