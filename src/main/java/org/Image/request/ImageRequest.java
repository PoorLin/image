package org.Image.request;

import java.io.Serializable;
import java.util.Arrays;

public class ImageRequest implements Serializable {
    private byte[] data;

    private String fileName;

    public ImageRequest() {
    }

    public ImageRequest(byte[] data, String fileName) {
        this.data = data;
        this.fileName = fileName;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "ImageRequest{" +
                "data=" + Arrays.toString(data) +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
