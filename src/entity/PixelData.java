package entity;

public record PixelData(
        int width,
        int height,
        int rowSize,
        int totalSize,
        int bitsPerPixel
) {
}
