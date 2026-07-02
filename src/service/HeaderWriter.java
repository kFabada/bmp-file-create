package service;

import entity.Header;
import entity.InformationHeader;

import java.io.DataOutputStream;
import java.io.IOException;

public class HeaderWriter {
    private final Header header;
    private final InformationHeader informationHeader;
    private final int dataSize;
    private final FileHandle handle;

    public HeaderWriter(Header header, InformationHeader informationHeader, int dataSize, FileHandle handle) {
        this.header = header;
        this.informationHeader = informationHeader;
        this.dataSize = dataSize;
        this.handle = handle;
    }

    public void write(){
        DataOutputStream out = handle.getOut();

        try {
            out.write(Header.TYPE);
            out.writeInt(dataSize + header.getPixelData().totalSize());
            out.writeShort(Header.RESERVED);
            out.writeShort(Header.RESERVED);
            out.writeInt(Header.OFFSET);

            out.writeInt(InformationHeader.INFORMATIONHEADER);
            out.writeInt(header.getPixelData().width());
            out.writeInt(header.getPixelData().height());
            out.writeShort(InformationHeader.planes);
            out.writeShort((short)header.getPixelData().bitsPerPixel());

            out.writeInt(InformationHeader.compress);
            out.writeInt(InformationHeader.sizeRaw);
            out.writeInt(InformationHeader.horizontal);
            out.writeInt(InformationHeader.vertical);
            out.writeInt(InformationHeader.nColor);
            out.writeInt(InformationHeader.importColor);

            out.flush();
        } catch (IOException e) {
            System.out.printf("filed write bmp {%s}", e.getMessage());
        }
    }
}
