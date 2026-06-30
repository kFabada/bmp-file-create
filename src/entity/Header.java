package entity;

import util.PixelCalculator;

public class Header {
    public static final int headerSizeBytes = 0x0E;
    private final byte[] TYPE = {0x42, 0x4D};
    private final int RESERVED = 0x00;
    private final int fileSizeInBytes;
    private final int OFFSET = 0x36;
    private final PixelCalculator pixelCalculator;

    public Header(int fileSizeInBytes, PixelCalculator pixelCalculator) {
        this.fileSizeInBytes = fileSizeInBytes;
        this.pixelCalculator = pixelCalculator;
    }


}
