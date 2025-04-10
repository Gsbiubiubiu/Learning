package com.gs.designmodel.exterior;

/**
 * @author: Gaos
 * @Date: 2023-01-30 17:33
 **/
public class CodecFactory {
    public static Codec extract(VideoFile file) {
        String codecType = file.getCodecType();
        if(codecType.equals("mp4")) {
            System.out.println("CodecFactory: extracting mpeg audio...");
            return new MPEG4CompressionCodec();
        }else {
            System.out.println("CodecFactory: extracting ogg audio...");
            return new OggCompressionCodec();
        }
    }
}