package exception_file;


import java.io.*;
import java.util.Scanner;

public class AccountFileSaver {
    private Account act;
    String fileName ;
    private static Scanner in = new Scanner(System.in);

    AccountFileSaver(String fn) {
        this.fileName = fn;
    }

    public boolean saveAccount()  {
        File file = new File(getFileName());
        try {
            PrintWriter output = new PrintWriter(file);
            output.print(getAccount().getFirstName()+", ");
            output.print(getAccount().getLastName()+", ");
            output.print(getAccount().getAccountNumber()+", ");
            output.print(getAccount().getStartDate().toString()+"\n");
            output.close();

        } catch (IOException e) {
            throw new BadFileException ("Error Writing To File");
        }
        return true;
    }

    public boolean createAccount() {
        boolean accountLoaded = false;
        try {
            System.out.println("Input Account Details.");
            String firstName = getResponseTo("First name: ");
            String lastName = getResponseTo("Last name: ");
            String actNum = getResponseTo("Account number (using format NNN-NNNNNNN): ");
            String actStartUpDate = getResponseTo("Account startup date as YYYY-MM-DD: ");
            setAccount(new Account(actNum, firstName, lastName, actStartUpDate));
            accountLoaded = true;
        } catch (BadAccountInputException ex) {
            System.out.println(ex.getMessage() + ". Please re-enter account details \n");
        }
        return accountLoaded;
    }

    private String getResponseTo(String s) {
        System.out.print(s);
        return(in.nextLine());
    }

    public boolean readAccount()  {
        File file = new File(getFileName());
        StringBuffer sb = new StringBuffer();
        try {
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()) {
                sb.append(scan.nextLine()+"\n");
            }
            scan.close();
        } catch (FileNotFoundException e) {
            throw new BadFileException("File does not exist");
        }

        if(sb.toString().isEmpty())
            return false;
        else
            System.out.println(sb.toString());
        return true;
    }

    public boolean cleanAccountFile()  {
        try {
            File f = new File(fileName);
            if (f.delete())  {
                return true;
            }
            else {
                return false;
            }
        }

        catch (Exception e ) {
            System.out.println(" Error while reading file : " + e.getMessage() );
            return false;
        }
    }

    public Account getAccount() {
        return act;
    }

    public void setAccount(Account act) {
        this.act = act;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}

