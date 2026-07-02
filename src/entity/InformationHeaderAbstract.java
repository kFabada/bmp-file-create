package entity;

public abstract class InformationHeaderAbstract {
    private final int INFORMATIONHEADER = 0x28;
    private final short planes = 0x01;
    private final int compress = 0x00;
    private final int sizeRaw = 0x00;
    private final int horizontal = 0xB13 ;
    private final int vertical = 0xB13 ;
    private final int nColor = 0x00;
    private final int importColor = 0x00;

    public int getINFORMATIONHEADER() {
        return INFORMATIONHEADER;
    }

    public int getImportColor() {
        return importColor;
    }

    public int getnColor() {
        return nColor;
    }

    public int getVertical() {
        return vertical;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public int getSizeRaw() {
        return sizeRaw;
    }

    public int getCompress() {
        return compress;
    }

    public short getPlanes() {
        return planes;
    }
}
