package entity;

public class InformationHeaderBuilder extends InformationHeaderAbstract{
    private final int headerByteSize;
    private final short planes;
    private final int compress;
    private final int sizeRaw;
    private final int horizontal;
    private final int vertical;
    private final int nColor;
    private final int importColor;

    public InformationHeaderBuilder(int headerByteSize, short planes, int compress, int sizeRaw, int horizontal, int vertical, int nColor, int importColor) {
        this.headerByteSize = headerByteSize;
        this.planes = planes;
        this.compress = compress;
        this.sizeRaw = sizeRaw;
        this.horizontal = horizontal;
        this.vertical = vertical;
        this.nColor = nColor;
        this.importColor = importColor;
    }

    @Override
    public int getHeaderByteSize() {
        return headerByteSize;
    }

    @Override
    public short getPlanes() {
        return planes;
    }

    @Override
    public int getCompress() {
        return compress;
    }

    @Override
    public int getSizeRaw() {
        return sizeRaw;
    }

    @Override
    public int getHorizontal() {
        return horizontal;
    }

    @Override
    public int getVertical() {
        return vertical;
    }

    @Override
    public int getnColor() {
        return nColor;
    }

    @Override
    public int getImportColor() {
        return importColor;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private int headerByteSize;
        private short planes;
        private int compress;
        private int sizeRaw;
        private int horizontal;
        private int vertical;
        private int nColor;
        private int importColor;

        public Builder() {}

        public Builder setPlanes(short planes) {
            this.planes = planes;
            return this;
        }

        public Builder setImportColor(int importColor) {
            this.importColor = importColor;
            return this;
        }

        public Builder setHeaderByteSize(int headerByteSize) {
            this.headerByteSize = headerByteSize;
            return this;
        }

        public Builder setnColor(int nColor) {
            this.nColor = nColor;
            return this;
        }

        public Builder setVertical(int vertical) {
            this.vertical = vertical;
            return this;
        }

        public Builder setHorizontal(int horizontal) {
            this.horizontal = horizontal;
            return this;
        }

        public Builder setSizeRaw(int sizeRaw) {
            this.sizeRaw = sizeRaw;
            return this;
        }

        public Builder setCompress(int compress) {
            this.compress = compress;
            return this;
        }

        public InformationHeaderBuilder build(){
            return new InformationHeaderBuilder(
                    headerByteSize,
                    planes,
                    compress,
                    sizeRaw,
                    horizontal,
                    vertical,
                    nColor,
                    importColor
            );
        }
    }
}
