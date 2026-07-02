package util;

import entity.Header;
import entity.InformationHeaderAbstract;
import entity.PixelData;

public class PixelCalculator {
    private final int width;
    private final int bitsPerPixel;
    private final int height;
    private int rowSizeInBytes;
    private int totalSizeInBytes;
    private final InformationHeaderAbstract informationHeader;

    public PixelCalculator(int width, int bitsPerPixel, int height, InformationHeaderAbstract informationHeader) throws IllegalArgumentException {
        this.width = width;
        this.bitsPerPixel = bitsPerPixel;
        this.height = height;
        this.informationHeader = informationHeader;
        validation();
    }

    private void validation() throws IllegalArgumentException {
        if(width <= 0 | height <= 0 | bitsPerPixel != Header.headerSizeBytes){
            throw new IllegalArgumentException();
        }
    }

    public PixelData calculator(){
        rowCalculator();
        totalCalculator();
        return new PixelData(width, height, rowSizeInBytes, totalSizeInBytes, bitsPerPixel);
    }

    private void rowCalculator(){
        rowSizeInBytes = ((bitsPerPixel * width) / 32) * 4;
    }

    private void totalCalculator(){
        totalSizeInBytes = (rowSizeInBytes * height) + Header.headerSizeBytes + informationHeader.getHeaderByteSize();
    }
}
