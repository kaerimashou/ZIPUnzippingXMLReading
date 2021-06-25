import javax.xml.bind.JAXBException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZIPDecifer {
    public static void main(String[] args){
        try(ZipInputStream zin=new ZipInputStream(new FileInputStream("D:\\test.zip"))){
            ZipEntry entry;
            while((entry=zin.getNextEntry())!=null){
                System.out.println("Filename: "+entry.getName());
                FileOutputStream fout=new FileOutputStream("D:\\TestingUnzipping\\"+entry.getName());
                int c;
                while((c=zin.read())!=-1){
                    fout.write(c);
                }
                XMLDecifer.readXML("D:\\TestingUnzipping\\"+entry.getName());
                fout.flush();
                zin.closeEntry();
                fout.close();
            }

        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }
}
