/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplebyteout;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author pfares
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException   {
        // TODO code application logic here

        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
        byte[] buffer = new byte[16];
        int numberRead;
        while ((numberRead = System.in.read(buffer)) > -1) {
            byteArrayOut.write(buffer, 0, numberRead);
        }
        System.out.println("Read " + byteArrayOut.size() + " bytes.");
        System.out.write(byteArrayOut.toByteArray());
        PrintStream printStream = new PrintStream(byteArrayOut);
        for (int i = 0; i < args.length; ++i) {
            printStream.println("Written to " + args[i] + ".");
            FileOutputStream fileOut = new FileOutputStream(args[i]);
            byteArrayOut.writeTo(fileOut);
            fileOut.close();
        }
    }
}
