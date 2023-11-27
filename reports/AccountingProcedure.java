package reports;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import operator.Management;
import reports.AccountingProcedure;
import reports.EFTReport;
import reports.MemberReport;
import reports.ProviderReport;
import reports.SummaryReport;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author Hamza Adnan
 */

public class AccountingProcedure {
    public static void main(String[] args) throws IOException {
        // Check if today is Friday and time is midnight to run the weekly procedure
    	if (isMidnight(null) && isFriday(null)) {
            runWeeklyProcedure(null);
        }
    }


    
    static boolean isMidnight(LocalDateTime dateTime) {
        return dateTime.getHour() == 0 && dateTime.getMinute() == 0;
    }

    static boolean isFriday(LocalDateTime dateTime) {
        return dateTime.getDayOfWeek() == DayOfWeek.FRIDAY;
    }

    static Scanner reader = new Scanner(System.in);

    public static void runWeeklyProcedure(Management reports) throws IOException {
        // Logic to process the week's file and generate reports
        System.out.println("Running weekly accounting procedure...");
        // Example: Create file and generate reports
        EFTReport etf = new EFTReport();

        System.out.println("Please enter the ID of the provider that you would like to generate a provider report for.");
        int providerID = Integer.parseInt(reader.nextLine());
        ProviderReport provider = new ProviderReport(reports.findProvider(providerID));
        provider.printProviderReport();

        System.out.println("Please enter the ID of the member that you would like to generate a member report for.");
        int memberID = Integer.parseInt(reader.nextLine());
        MemberReport member = new MemberReport(reports.findMember(memberID));
        member.printMemberReport();
        	
        SummaryReport summary = new SummaryReport(reports);
        summary.printSummaryReport();
        

        System.out.println("Weekly procedure completed.");
    }

    

}
