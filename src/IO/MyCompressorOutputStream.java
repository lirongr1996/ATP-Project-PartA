package IO;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MyCompressorOutputStream extends OutputStream {
    private OutputStream out;

    public MyCompressorOutputStream(OutputStream out) {
        this.out = out;
    }

    @Override
    public void write(int b) throws IOException {
        out.write(b);
    }


    @Override
    public void write(byte [] b) throws IOException {
        for (int i=0;i<24;i++)
            out.write(b[i]);
        if (b[24]==1)
            out.write(0);
        int previous=24;
        int j=25;
        for (j=25;j<b.length;j++)
        {
            if(b[j]!=b[j-1]) {
                if (j-previous>255) {
                    int num = previous+255;
                    while (num > 255) {
                        out.write(num);
                        out.write(0);
                        num += 255;
                    }
                    out.write(j);
                }
                else
                    out.write(j);
                previous = j;
            }

        }
        if (j-previous>255) {
            int num =previous+255;
            while (num <j) {
                out.write(num);
                out.write(0);
                num += 255;
            }
            int d=j-(num-255);
            out.write(d);
        }
        else
            out.write(b.length);
    }
}