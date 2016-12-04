/*
 * This code was writen to rename 2452 XML files using names fount at a spesific position in each file.
 */

package medscape;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Medscape {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        BufferedReader names = new BufferedReader(new FileReader("dir.txt"));
        String[] nArr = new String[2452];
        for(int i=0; i < nArr.length; i++) {
            nArr[i] = names.readLine();
        }
        names.close();

        for (int i = 0; i < nArr.length; i++) {
            BufferedReader in = new BufferedReader(new FileReader(nArr[i]));
            in.skip(77);
            String name = in.readLine();
            name = name.substring(0, name.length() - 5);
            while (name.contains("/")){
                int idx = name.indexOf("/");
                String tmp1 = name.substring(idx + 1);
                String tmp2 = name.substring(0, idx);
                name = tmp2 + " & " + tmp1;
            }
            name = name + ".xml";
            in.close();
            File file = new File(nArr[i]);
            File file2 = new File(name);
            boolean success = file.renameTo(file2); 
        }
        
    }
    
}
