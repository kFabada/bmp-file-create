package util;

import entity.Header;
import entity.PixelData;

public class PixelCalculator {
    private final int width;
    private final int bitsPerPixel;
    private final int heigth;
    private int rowSize;
    private int totalSize;

    public PixelCalculator(int width, int bitsPerPixel, int heigth) throws IllegalArgumentException {
        this.width = width;
        this.bitsPerPixel = bitsPerPixel;
        this.heigth = heigth;
        validation();
    }

    public void validation(){
        if(width <= 0 | heigth <= 0 | bitsPerPixel != Header.headerSizeBytes){
            throw new IllegalArgumentException();
        }
    }

    public PixelData calculator(){
        rowCalculator();
        totalCalculator();
        return new PixelData(width, heigth, rowSize, totalSize, bitsPerPixel);
    }

    private void rowCalculator(){
        rowSize = ((bitsPerPixel * width) / 32) * 4;
    }

    private void totalCalculator(){
        totalSize = rowSize * heigth;
    }
}
