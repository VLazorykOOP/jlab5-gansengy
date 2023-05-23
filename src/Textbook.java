import java.util.Scanner;

class Textbook extends PrintedPublication /*implements Comparable<Textbook>*/ {
    private String subject;
    private int pageCount;

    public Textbook(String title, String author, int year, int pageCount, String subject) {
        super(title, author, year);
        try {
            this.subject = subject;
        } catch (Exception e) {
            System.out.println("Error: Invalid subject value.");
            this.subject = "";
        }
        this.pageCount = pageCount;
    }

    public void show() {
        super.show();
        System.out.println("Subject: " + subject);
        System.out.println("Page Count: " + pageCount);
    }

    public static Textbook createFromInput() {
        Scanner scanner = new Scanner(System.in);
        PrintedPublication printedPublication = PrintedPublication.createFromInput();
        int pageCount = 0;
        try {
            pageCount = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid page count format. Page count should be an integer.");
        }
        System.out.print("Enter the subject: ");
        String subject = scanner.nextLine();
        return new Textbook(printedPublication.getTitle(), printedPublication.getAuthor(), printedPublication.getYear(), pageCount, subject);
    }

    /*@Override
    public int compareTo(Textbook other) {
        // Compare based on title
        return getTitle().compareTo(other.getTitle());
    }*/
}
