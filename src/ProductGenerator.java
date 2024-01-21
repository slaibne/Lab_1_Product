import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

/**
 *
 * @author wulft
 *
 * Demonstrates how to use Java NIO, a thread safe File IO library
 * to write a text file
 */
public class ProductGenerator
{


    /**
     * @param args the command line arguments
     */
    public static void main(String [] args)
    {



        // Test data the lines of the file we will write
        Boolean response = true;
        Scanner in = new Scanner(System.in);
        ArrayList <Product> recs = new ArrayList<Product>();
        String idNo;
        String name;

        String desc;
        double cost;

        while(response)
        {
            idNo = SafeInput.getNonZeroLenString(in,"What is this product's ID Number?");
            name = SafeInput.getNonZeroLenString(in,"What is this product's name?");

            desc = SafeInput.getNonZeroLenString(in,"What is this product's description?");
            cost = SafeInput.getDouble(in,"What is this product's cost?");
            recs.add(new Product(idNo,name,desc,cost));
            response = SafeInput.getYNConfirm(in, "Do you have more products?");
        }



        // use the toolkit to get the current working directory of the IDE
        // will create the file within the Netbeans project src folder
        // (may need to adjust for other IDE)
        // Not sure if the toolkit is thread safe...
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath(), "//src//" + "productTestData.txt");

        try
        {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));


            for(Product p : recs)
            {
                String csvRec = p.toCSV();
                writer.write(csvRec, 0, csvRec.length());
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}