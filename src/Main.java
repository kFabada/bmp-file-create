import entity.*;
import service.FileHandle;
import service.HeaderWriter;
import util.PixelCalculator;

public class Main {
    public static void main(String[] args){
        InformationHeaderAbstract informationHeader = new InformationHeaderNoCompress();
        PixelCalculator pixelCalculator = new PixelCalculator(1920, 24, 1080, informationHeader);
        PixelData pixelData = pixelCalculator.calculator();

        Header header = new Header(pixelData);


        FileHandle fileHandle = FileHandle.getInstance("", "image");

        HeaderWriter headerWriter = new HeaderWriter(header, informationHeader,0);
        headerWriter.writeTo(fileHandle.getOutput());
    }
}