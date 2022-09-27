import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineBookStore
{
    public static int ISBN_INDEX = 0;
    public static int TITLE_INDEX = 1;
    public static int AUTHOR_INDEX = 2;
    public static int PUBLISHER_INDEX = 3;
    public static int PUBLISHER_YEAR_INDEX = 4;
    public static int QUANTITY_INDEX = 5;
    public static int PRICE_INDEX = 6;

    public static void main(String[] args)
    {
        ArrayList<Book> bookList = new ArrayList<Book>();
        try
        {
            FileReader fileReader = new FileReader("books.txt");// Enter the entire path of the file if needed
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            boolean endOfFile = false;

            while(!endOfFile)
            {
                String bookLine = bufferedReader.readLine();
                if (bookLine != null)
                {
                    String[] bookData = bookLine.split(", ");
                    String isbn = bookData[ISBN_INDEX];
                    String title = bookData[TITLE_INDEX];
                    String author = bookData[AUTHOR_INDEX];
                    String publisher = bookData[PUBLISHER_INDEX];
                    int publishYear = Integer.parseInt (bookData[PUBLISHER_YEAR_INDEX]);
                    int quantity = Integer.parseInt (bookData[QUANTITY_INDEX]);
                    double price = Double.parseDouble (bookData[PRICE_INDEX]);
                    Book book = new Book(isbn, title, author, publisher, publishYear, quantity, price);
                    bookList.add(book);

                }
                else
                {
                    endOfFile = true;
                }
            }
            bufferedReader.close();
            fileReader.close();
        } // End try

        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        printBookDetails(bookList);
        purchaseBook(bookList);
    }

    public static void printBookDetails(ArrayList<Book> bookList){
        for(int i = 0; i < bookList.size(); i++){
            System.out.printf("%s, %S, %s, %s, %d, %d, %d%n", bookList.get(i).getIsbn(), bookList.get(i).getTitle(), bookList.get(i).getAuthor(),
                    bookList.get(i).getPublisher(), bookList.get(i).getPublishYear(), bookList.get(i).getQuantity(), bookList.get(i).getPrice());
        }
    }

    public static Book getBook(ArrayList<Book> bookList, String title){
        boolean same=  false;
        int i;
        for(i = 0; !same && i < bookList.size(); i++){
            same = (bookList.get(i).getTitle() == title) ? true : false;
        }
        return same ? bookList.get(i) : null;
    }

    public static void topUpCard(ChargeCard card, double amount){
        card.topUpFunds(amount);
    }

    public static void purchaseBook(ArrayList<Book> bookList){
        System.out.println("Enter the fund in your card: ");
        Scanner input = new Scanner(System.in);
        boolean quit = false;
        while(!quit) {
            if (input.hasNextDouble()) {
                double fund = input.nextDouble();
                if (fund > 0) {
                    ChargeCard theCard = new ChargeCard();
                    theCard.topUpFunds(fund);
                    System.out.println("Enter the book title you would like to purchase: ");
                    String title = input.next();
                    Book theBook = getBook(bookList, title);
                    if (theBook != null) {
                        if (theBook.getQuantity() == 0) {
                            System.out.println("Sorry. This book is sold out.");
                        } else {
                            theBook.setQuantity(theBook.getQuantity() - 1);
                            theCard.removeFunds(theBook.getPrice());
                        }
                    } else {
                        System.out.println("Book not found!");
                    }
                } else {
                    System.out.println("Please enter a number over zero!");
                }
            } else if (input.hasNext("quit")) {
                quit = true;
                input.close();
            } else {
                System.out.println("Please enter a number!");
            }
        }
    }
}