/* Name: Max
 Assignment: Lab 2
 Title: LoanCalculator
 Course: CS 144
 Class section: 2
 Lab Section: 1
 Semester: Fall 2017
 Instructor: Cao
 Date: 9/21/2017
 Sources consulted: none
 Known Bugs: none
 Program description: Given the loan amount, exchange rate, annual interest
 rate, and the term of the loan my program calculates the monthly payment in US
 dollars and local currency
 Creativity: The user can choose the compound period (weekly, monthly,
 half-yearly)
 Instructions: Follow the prompts and enter country, currency, loan amount, int
 rate, term of loan, and compound period. The program will tell you your monthly
 payment
 */



import java.util.Scanner;

public class LoanCalculator
{
  public static void main(String[] args)
  {
    //declare variables
    int exchangeRate, loanTerm;
    double localLoan, convLoan, intRate, moPayment, convMoPayment, compIntRate;

    //instantiate scanner object
    Scanner scan = new Scanner(System.in);

    //Prompt user for Country of loan's origin
    System.out.print("Enter the country where loan is requested: ");

    //read in and store Country
    String country = scan.nextLine();

    //prompt user for name of local currency
    System.out.print("Enter the name of the local currency: ");

    //read in and store local currency name
    String currencyName = scan.nextLine();

    //prompt user for exchange rate
    System.out.print("Enter the exchange rate (equal to $1 U.S): ");

    //read in and store exchange rate
    exchangeRate = scan.nextInt();

    //prompt user for loan amount in local currency
    System.out.print("Please enter the loan amount in " + currencyName +
                    "(no commas or $): ");

    //read in and store local loan amount
    localLoan = scan.nextDouble();

    //prompt user for Interest rate w/ usage example
    System.out.print("Please enter the annual interest rate" +
                      "(ex: 0.054 for 5.4%): ");

    //read in and store interest rate
    intRate = scan.nextDouble();

    //prompt user for the term of the loan
    System.out.print("Please enter the term of the loan in years: ");

    //read in and store term of the laon in years
    loanTerm = scan.nextInt();

    //Clearing newLine from input buffer
    scan.nextLine();

    //Prompt user to select the compound period
    System.out.print("Please enter the compound period you would like" +
                    "(choices: (M)monthly, (Q)quarterly, (H)half-yearly): ");

    //declare compound period String,
    //read in and store user compound period choice change to uppper store fir
    //charAt
    char compPeriod = scan.nextLine().toUpperCase().charAt(0);

    //Check compound char and caclulate compounded IntRate
    if(compPeriod == 'M' )
    {
      compIntRate = intRate / 12;
    }
    else if(compPeriod == 'Q')
    {
      compIntRate = intRate / 4;
    }
    else
    {
      compIntRate = intRate / 2;
    }
    //Convert loan amount to US dollars
    convLoan = localLoan * exchangeRate;

    //Calculate monthly payment
    moPayment = convLoan * ((compIntRate * (Math.pow(1 + compIntRate, loanTerm * 12))) /
                ((Math.pow(1 + compIntRate, loanTerm * 12)) - 1));

    //convert US dollar payment to local currency Monthly payment
    convMoPayment = moPayment / exchangeRate;


    //output loan amount in local currency then US dollars

    System.out.println("\nPAYMENT CALCULATOR");
    System.out.println("Loan Amount: " + localLoan +
                      " ($" + convLoan + " U.S.)");

    //calculate and output interest rate
    double displayIntRate = intRate * 100;
    System.out.println("Interest Rate: " + displayIntRate + "%");

    //Display the term of the loan in years
    System.out.println("Term of Loan: " + loanTerm + " years");

    //Display monthly payment in local currency then U.S dollars
    System.out.println("Monthly Payment: " + convMoPayment + " " + currencyName +
                      " ($" + moPayment + " U.S. Dollars)");

    //Calculate and display interest accrued over life of loan
    double totAmntPaid, totIntAccrued, localIntAccrued;

    totAmntPaid = moPayment * (loanTerm * 12);
    totIntAccrued = totAmntPaid - convLoan;
    localIntAccrued = totIntAccrued / exchangeRate;
    System.out.println("Total Interest Accrued: " + localIntAccrued +
                        "($" + totIntAccrued + " U.S.)");

  }
}
