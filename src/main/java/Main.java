import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    //private static ArrayList<Integer> arrlist = new ArrayList<Integer>(); // This ArrayList isn't necessary.
    private static ArrayList<Integer> expenses = new ArrayList<Integer>();
    private static Scanner sc = new Scanner(System.in); //More efficient to have a global scanner that closes when application is done.

    public static void addSampleExpenses() {
        expenses.add(1000);
        expenses.add(2300);
        expenses.add(45000);
        expenses.add(32000);
        expenses.add(110);
        //expenses.addAll(arrlist); // This is not used for anything.

    }

    public static void main(String[] args) {
        /*System.out.println("Hello World!");*/

        addSampleExpenses();
        System.out.println("\n**************************************\n");
        System.out.println("\tWelcome to TheDesk \n");
        System.out.println("**************************************");
        optionsSelection();

    }
    private static void optionsSelection() {
        System.out.println("\n**************************************\n");
        String[] arr = {"1. I wish to review my expenditure",
                "2. I wish to add my expenditure",
                "3. I wish to delete my expenditure",
                "4. I wish to sort the expenditures",
                "5. I wish to search for a particular expenditure",
                "6. Close the application"
        };
        int[] arr1 = {1,2,3,4,5,6};
        int  slen = arr1.length;
        for(int i=0; i<slen;i++){
            System.out.println(arr[i]);
            // display the all the Strings mentioned in the String array
        }
        System.out.println("\nEnter your choice:\t");
        //Scanner sc = new Scanner(System.in);
        int  options =  sc.nextInt();
        
        //for(int j=1;j<=slen;j++){  //Both this for loop and the if statement below are pointless thanks to the switch statement.
            //if(options==j){
        switch (options){
            case 1:
                System.out.println("Your saved expenses are listed below: \n");
                System.out.println(expenses+"\n");
                optionsSelection();
                break;
            case 2:
                System.out.println("Enter the value to add your Expense: \n");
                int value = sc.nextInt();
                expenses.add(value);
                System.out.println("Your value is updated\n");
                //expenses.addAll(arrlist);
                System.out.println(expenses+"\n");
                optionsSelection();

                break;
            case 3:
                System.out.println("You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
                int con_choice = sc.nextInt();
                if(con_choice==options){
                       expenses.clear();
                    System.out.println(expenses+"\n");
                    System.out.println("All your expenses are erased!\n");
                } else {
                    System.out.println("Oops... try again!");
                }
                optionsSelection();
                break;
            case 4:
                sortExpenses(expenses);
                optionsSelection();
                break;
            case 5:
                searchExpenses(expenses);
                optionsSelection();
                break;
            case 6:
                closeApp();
                break;
            default:
                System.out.println("You have made an invalid choice!");
                optionsSelection(); //Don't want to close the application till the user decides to.
                break;
        }
            //}
        //}
        sc.close(); //Application is terminated.
    }
    private static void closeApp() {
        System.out.println("Closing your application... \nThank you!");
            }
    private static void searchExpenses(ArrayList<Integer> arrayList) {
        System.out.println("Enter the expense you need to search:\t");
        //Scanner sc = new Scanner(System.in);
        int  expense =  sc.nextInt();
        System.out.println("You are searching for: " + expense);
        sortExpenses(arrayList);	//Sorting necessary for the algorithm to work
        int index = BinarySearcher.binarySearch(arrayList, 0, arrayList.size()-1, expense);
        if(index!=-1)
        	System.out.println("Expense was found at index " + index + ".");
        else
        	System.out.println("The expense was not found.");
        
    }
    private static void sortExpenses(ArrayList<Integer> arrayList) {
        HeapSorter.sort(arrayList);
        //System.out.println(arrayList.toString());
    }
}
