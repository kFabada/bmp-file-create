package service;

import entity.Header;
import entity.InformationHeaderAbstract;

import java.io.DataOutputStream;
import java.io.IOException;

public class HeaderWriter {
    private final Header header;
    private final InformationHeaderAbstract informationHeader;
    private final int dataSize;

    public HeaderWriter(Header header, InformationHeaderAbstract informationHeader, int dataSize) {
        this.header = header;
        this.informationHeader = informationHeader;
        this.dataSize = dataSize;
    }

    public void writeTo(DataOutputStream out){
        try {
            out.write(Header.TYPE);
            out.writeInt(dataSize + header.getPixelData().totalSize());
            out.writeShort(Header.RESERVED);
            out.writeShort(Header.RESERVED);
            out.writeInt(Header.OFFSET);

            out.writeInt(informationHeader.getHeaderByteSize());
            out.writeInt(header.getPixelData().width());
            out.writeInt(header.getPixelData().height());
            out.writeShort(informationHeader.getPlanes());
            out.writeShort((short)header.getPixelData().bitsPerPixel());

            out.writeInt(informationHeader.getCompress());
            out.writeInt(informationHeader.getSizeRaw());
            out.writeInt(informationHeader.getHorizontal());
            out.writeInt(informationHeader.getVertical());
            out.writeInt(informationHeader.getnColor());
            out.writeInt(informationHeader.getImportColor());

            out.flush();
        } catch (IOException e) {
            System.out.printf("filed write bmp {%s}", e.getMessage());
        }
    }
}
