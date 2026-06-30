package util;

import entity.Header;
import entity.InformationHeader;
import entity.PixelData;

public class PixelCalculator {
    private final int width;
    private final int bitsPerPixel;
    private final int height;
    private int rowSizeInBytes;
    private int totalSizeInBytes;

    public PixelCalculator(int width, int bitsPerPixel, int height) throws IllegalArgumentException {
        this.width = width;
        this.bitsPerPixel = bitsPerPixel;
        this.height = height;
        validation();
    }

    private void validation(){
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
        totalSizeInBytes = (rowSizeInBytes * height) + Header.headerSizeBytes + InformationHeader.INFORMATIONHEADER;
    }
}
