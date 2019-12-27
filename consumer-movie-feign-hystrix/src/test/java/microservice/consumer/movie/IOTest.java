package microservice.consumer.movie;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class IOTest {

    public static void main(String[] args) throws IOException {
        String fileName="E:\\CSS视频\\新建 DOC 文档.doc";
        File f=new File(fileName);
        InputStream in=new FileInputStream(f);
        byte[] b=new byte[10];
        int temp;
        StringBuilder builder = new StringBuilder();
        /*while((temp=in.read()) != -1){
            //System.out.println("the value of temp=================="+temp);
            builder.append(new String());
        }*/
        int temp1;
        /*while ((temp1=in.read(b)) != -1){
            //System.out.println("the value of temp1=================="+temp1);
            builder.append(new String(b,0,temp1));
        }*/
        temp1 = in.read(b);
        builder.append(new String(b,0,temp1));
        System.out.println("the value of builder=================="+builder.toString());
        System.out.println("文件长度为："+f.length());
        in.close();
        //System.out.println(new String(b));
        System.out.println("string======"+new String(b,0,temp1+1));
    }

}
