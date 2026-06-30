package entity;

public record PixelData(
        int width,
        int heigth,
        int rowSize,
        int totalSize,
        int bitsPerPixel
) {
}
