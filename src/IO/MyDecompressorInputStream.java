package IO;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyDecompressorInputStream extends InputStream {
    private InputStream in;

    public MyDecompressorInputStream(InputStream in) {
        this.in = in;
    }

    @Override
    public int read() throws IOException {
        return 0;
    }

    public int read(byte[] b) throws IOException{
        for (int i=0;i<24;i++)
            b[i]=(byte) in.read();
        int temp=in.read();
        int index=24;
        if (temp==0) {
            temp =in.read();
            index++;
        }
        int j=24;
        int previous=24;
        while (temp!=-1)
        {
            if (index%2==0)
            {
                if (temp<previous)
                {
                    for (int i=0;i<256-previous+temp;i++,j++)
                        b[j]=0;
                }
                else {
                    for (int i = previous; i < temp; i++, j++)
                        b[j] = 0;
                }
            }
            else
            {
                if (temp<previous)
                {
                    for (int i=0;i<256-previous+temp;i++,j++)
                        b[j]=1;
                }
                else {
                for (int i=previous;i<temp;i++,j++)
                    b[j]=1;
                }
            }
            index++;
            previous=temp;
            temp=in.read();

        }
        return 0;
    }
}
