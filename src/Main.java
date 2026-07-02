import entity.*;
import service.FileHandle;
import service.HeaderWriter;
import util.PixelCalculator;

import java.io.*;

public class Main {
    public static void main(String[] args){
        PixelCalculator pixelCalculator = new PixelCalculator(1920, 24, 1080);
        PixelData pixelData = pixelCalculator.calculator();

        Header header = new Header(pixelData);
        InformationHeader informationHeader = new InformationHeader();

        FileHandle fileHandle = FileHandle.getInstance("", "image");

        HeaderWriter headerWriter = new HeaderWriter(header, informationHeader,0, fileHandle);
        headerWriter.write();
    }
}