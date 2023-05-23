import java.util.Scanner;
class Magazine extends PrintedPublication /*implements Comparable<Magazine>*/ {
    private int issueNumber;
    public Magazine(String title, String author, int year, int issueNumber) {
        super(title, author, year);
        this.issueNumber = issueNumber;
    }

    public void show() {
        super.show();
        System.out.println("Issue Number: " + issueNumber);
    }

    public static Magazine createFromInput() {
        PrintedPublication printedPublication = PrintedPublication.createFromInput();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the issue number: ");
        int issueNumber = scanner.nextInt();
        return new Magazine(printedPublication.getTitle(), printedPublication.getAuthor(), printedPublication.getYear(), issueNumber);
    }
    /*@Override
    public int compareTo(Magazine other) {
        // Compare based on title
        return getTitle().compareTo(other.getTitle());
    }*/
}
