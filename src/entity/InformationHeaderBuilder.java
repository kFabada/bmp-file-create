package entity;

public class InformationHeaderBuilder extends InformationHeaderAbstract{
    private final short planes;
    private final int compress;
    private final int sizeRaw;
    private final int horizontal;
    private final int vertical;
    private final int nColor;
    private final int importColor;

    public InformationHeaderBuilder(short planes, int compress, int sizeRaw, int horizontal, int vertical, int nColor, int importColor) {
        this.planes = planes;
        this.compress = compress;
        this.sizeRaw = sizeRaw;
        this.horizontal = horizontal;
        this.vertical = vertical;
        this.nColor = nColor;
        this.importColor = importColor;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private short planes;
        private int compress;
        private int sizeRaw;
        private int horizontal;
        private int vertical;
        private int nColor;
        private int importColor;

        public Builder() {}

        public void setPlanes(short planes) {
            this.planes = planes;
        }

        public void setImportColor(int importColor) {
            this.importColor = importColor;
        }

        public void setNcolor(int nColor) {
            this.nColor = nColor;
        }

        public void setVertical(int vertical) {
            this.vertical = vertical;
        }

        public void setHorizontal(int horizontal) {
            this.horizontal = horizontal;
        }

        public void setSizeRaw(int sizeRaw) {
            this.sizeRaw = sizeRaw;
        }

        public void setCompress(int compress) {
            this.compress = compress;
        }

        public InformationHeaderBuilder build(){
            return new InformationHeaderBuilder(planes, compress, sizeRaw, horizontal, vertical, nColor, importColor);
        }
    }
}
