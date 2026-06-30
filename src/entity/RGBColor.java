package entity;

public record RGBColor(byte r,  byte g, byte b) {
    public byte[] toByteArray(){
        return new byte[]{r, g, b};
    }
}
