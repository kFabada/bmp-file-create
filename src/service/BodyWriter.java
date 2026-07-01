package service;

import entity.BodyData;
import entity.RGBColor;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class BodyWriter {
    private final FileHandle handle;
    private final BodyData bodyData;
    private final short ALIGNMENT_PADDING = 0x00;

    public BodyWriter(FileHandle handle, BodyData bodyData) throws IllegalArgumentException{
        this.handle = handle;
        this.bodyData = bodyData;
    }

    public void write(){
        DataOutputStream out = handle.getOut();
        Iterator<RGBColor> dataIterator = bodyData.iterator();

        try {
            while (dataIterator.hasNext()){
                RGBColor color = dataIterator.next();
                out.write(color.toByteArray());
            }

            out.flush();
            out.close();
        }catch (IOException e){
            System.out.printf("filed body writer bmp {%s}", e.getMessage());
        }

    }
}
