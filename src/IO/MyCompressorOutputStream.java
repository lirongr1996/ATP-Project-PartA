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
        for (int i=25;i<b.length;i++)
        {
            if(b[i]!=b[i-1]) {
                if (i-previous>255) {
                    int num = i - previous;
                    while (num > 255) {
                        out.write(255);
                        out.write(0);
                        num -= 255;
                    }
                    out.write(num);
                }
                else
                    out.write(i);
                previous = i;
            }

        }
        out.write(b.length);
    }
}
