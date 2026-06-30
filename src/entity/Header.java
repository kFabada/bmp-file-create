package entity;

public class Header {
    public static final int headerSizeBytes = 0x0E;
    public static final byte[] TYPE = {0x42, 0x4D};
    public static final int RESERVED = 0x00;
    public static final int OFFSET = 0x36;
    private final PixelData pixelData;


    public Header(PixelData pixelData) throws IllegalArgumentException{
        this.pixelData = pixelData;
        validation();
    }

    public void validation(){
        if(pixelData == null) throw new IllegalArgumentException();
    }

    public PixelData getPixelData() {
        return pixelData;
    }
}
