import java.util.Scanner;

class PrintedPublication implements Comparable<PrintedPublication> {
    private String title;
    private String author;
    private int year;
    public PrintedPublication(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public void show() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year: " + year);
    }

    public String toFileString() {
        return "PrintedPublication, " + title + ", " + author + ", " + year;
    }

    public static PrintedPublication createFromInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title: ");
        String title = scanner.nextLine();
        System.out.print("Enter the author: ");
        String author = scanner.nextLine();
        System.out.print("Enter the year: ");
        int year = scanner.nextInt();
        return new PrintedPublication(title, author, year);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
    @Override
    public int compareTo(PrintedPublication other) {
        // Compare based on title
        return this.getTitle().compareTo(other.getTitle());
    }

}