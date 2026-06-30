package entity;

public class InformationHeader {
    private final PixelData pixelData;
    private final short planes = 0x01;
    private final int compress = 0x00;
    private final int sizeRaw = 0x00;
    private final int horizontal = 0xB13 ;
    private final int vertical = 0xB13 ;
    private final int nColor = 0x00;
    private final int importColor = 0x00;

    public InformationHeader(PixelData pixelData) {
        this.pixelData = pixelData;
    }
}
