package mock;

import entity.BodyData;
import entity.RGBColor;

import java.util.LinkedList;

public class ImageCreate {
    private final int width;
    private final int height;
    private final int
    private final byte[] colorRGB;

    public ImageCreate(int width, int height, byte[] colorRGB) {
        this.width = width;
        this.height = height;
        this.colorRGB = colorRGB;
    }

    public BodyData create(){
        LinkedList<RGBColor> rgbColors = new LinkedList<>();

        for (int i = 0; i < height - 1; i++){
            for(int j = 0; j < width - 1; j++){
                rgbColors.add(new RGBColor(colorRGB[0], colorRGB[1], colorRGB[2]));
            }
        }

        return new BodyData(rgbColors);
    }
}
