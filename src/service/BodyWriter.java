package service;

import entity.BodyData;
import entity.RGBColor;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class BodyWriter {
    private final BodyData bodyData;
    private final byte ALIGNMENT_PADDING = 0x00;

    public BodyWriter(BodyData bodyData) throws IllegalArgumentException{
        this.bodyData = bodyData;
    }

    public void writeTo(DataOutputStream out){
        Iterator<RGBColor> dataIterator = bodyData.iterator();

        try {
            while (dataIterator.hasNext()){
                RGBColor color = dataIterator.next();
                out.write(color.toByteArray());
                out.write(ALIGNMENT_PADDING);
            }

            out.flush();
            out.close();
        }catch (IOException e){
            System.out.printf("filed body writer bmp {%s}", e.getMessage());
        }

    }
}
