package exception_file;

import java.text.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Account {

    private String accountNumber = "0000000";
    private String firstName, lastName;
    private static final Calendar ACCOUNTSTARTDATE = Calendar.getInstance();
    private DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
    private Date startDate;

    public Account(String accountNumber, String firstName, String lastName, String startDate) {
        dateFormat.setLenient(false);
        setAccountNumber(accountNumber);
        setFirstName(firstName);
        setLastName(lastName);
        setStartDate(startDate);
    }

    private void setAccountNumber(String accountNumber) {
        if(!isDigitFormatCorrect(accountNumber))
            throw new BadAccountInputException();

        this.accountNumber = accountNumber;
    }

    private static boolean isDigitFormatCorrect(String accountNumber ) {
        return (accountNumber.matches("[1-2]{1}[4-9]{2}[-]{1}[1-9]{7}"));
    }

    private static boolean isInputNameCorrect(String name)  {
        if(name == null || name.isEmpty())
            return false;
        else {
            if(name.substring(0,1).matches("[A-Za-z]+") &&
                    name.substring(name.length()-1).matches("[A-Za-z]+")) {
                if(name.length()>3) {
                    return (name.substring(1, name.length() -1).matches("[A-Za-z .'|-]+"));
                } else
                    return true;
            } else {
                return false;
            }
        }
    }

    public void setStartDate(String startDate)
            throws BadAccountInputException {
        Calendar start = Calendar.getInstance();
        Calendar old = Calendar.getInstance();
        try {

            Date date = dateFormat.parse(startDate);
            start.setTime(date);

            Date oldest = dateFormat.parse("1900-01-01");
            old.setTime(oldest);

        }
        catch (ParseException pe) {
            throw new BadAccountInputException("Format is YYYY-MM-DD");
        }
        catch (RuntimeException re) {
            throw new BadAccountInputException("General runtime exception "
                    + "thrown setting start date");
        }
        if(start.after(ACCOUNTSTARTDATE))
            throw new BadAccountInputException("Date cannot be in the future");
        if(start.before(old))
            throw new BadAccountInputException("Date cannot be that old");

        this.startDate = start.getTime();
    }

    private void setFirstName(String firstName) {
        if (!isInputNameCorrect(firstName))
            throw new BadAccountInputException("Bad Name Format");
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        if (!isInputNameCorrect(lastName))
            throw new BadAccountInputException("Bad Name Format");
        this.lastName = lastName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String toString() {
        return "Customer name: " + getFirstName() + " " + getLastName()
                + "\nCustomer Account number: " + getAccountNumber()
                + "\nAccount Created: " + getStartDate().toString();
    }

}
