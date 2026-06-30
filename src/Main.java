import java.io.*;

public class Main {

    private static final int HEADERSIZE = 0xE;
    private static final int INFORMATIONHEADER = 0x28;
    private static final byte[] DEFAULTYPE = {0x42, 0x4D};
    private static final short DEFAULTVALUE = 0x00;
    private static final int RGBPIXEL = 0x4;
    private static final int HEADERSUM = 0x48;
    private static final int OFFSET = 0x36;

    public static void header(DataOutputStream out) throws IOException {
        out.write(DEFAULTYPE);
        out.writeInt(Integer.reverseBytes(HEADERSUM));
        out.writeShort(Short.reverseBytes(DEFAULTVALUE));
        out.writeShort(Short.reverseBytes(DEFAULTVALUE));
        out.writeInt(Integer.reverseBytes(OFFSET));
    }

    public static void informationHeader(DataOutputStream out) throws IOException{
        short planes = 0x1;
        int width = 0x2;
        int height = 0x2;
        short bitsPerPixel = 0x18;

        out.writeInt(Integer.reverseBytes(INFORMATIONHEADER));
        out.writeInt(Integer.reverseBytes(width));
        out.writeInt(Integer.reverseBytes(height));
        out.writeShort(Short.reverseBytes(planes));
        out.writeShort(Short.reverseBytes(bitsPerPixel));

        int compress = 0x00;
        int sizeRaw = 0x00;
        int horizontal = 0xB13 ;
        int vertical = 0xB13 ;
        int nColor = 0x00;
        int importColor = 0x00;

        out.writeInt(Integer.reverseBytes(compress));
        out.writeInt(Integer.reverseBytes(sizeRaw));
        out.writeInt(Integer.reverseBytes(horizontal));
        out.writeInt(Integer.reverseBytes(vertical));
        out.writeInt(Integer.reverseBytes(nColor));
        out.writeInt(Integer.reverseBytes(importColor));

    }

    public static void main(String[] args) throws IOException {
    }
}