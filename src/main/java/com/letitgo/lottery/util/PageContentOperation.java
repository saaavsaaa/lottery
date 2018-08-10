package com.letitgo.lottery.util;

import java.io.*;

/**
 * Created by aaa on 2017/1/29.
 */
public class PageContentOperation {

    public static String getContent(InputStream inputStream) throws IOException {
        return getContent(inputStream, "UTF-8");
    }

    public static String getContent(InputStream inputStream, String encode) throws IOException {
        InputStreamReader inputStreamReader = tranToInputStreamReader(inputStream, encode);
        String content = "";
        int tChar = 0;
        while((tChar = inputStreamReader.read()) != -1){
            //if not end,the total content add the value of the stream read this time
            content += (char)tChar;
        }
        inputStreamReader.close();
        return content;
    }

    /*
    * 此方法遍历了整个流，目标是只读取一次
    * */
    @Deprecated
    public static InputStream clearDOCTYPENode(InputStream inputStream) throws IOException {
        return clearDOCTYPENode(inputStream, "UTF-8");
    }

    public static InputStream clearDOCTYPENode(InputStream inputStream, String encode) throws IOException {
        InputStreamReader inputStreamReader = tranToInputStreamReader(inputStream, encode);
        int t = 0;
        boolean beginClear = false;
        boolean beginWatch = false;
        String tag = "";
        String content = "";
        while((t = inputStreamReader.read()) != -1){
            //if not end,the total content add the value of the stream read this time
            char c = (char)t;
            if (beginClear){
                content += c;
            } else {
                tag += c;
                if (!beginWatch && tag.equalsIgnoreCase("<!DOCTYPE")){
                    beginWatch = true;
                    continue;
                }
                if (beginWatch && c == '>'){
                    beginClear = true;
                    continue;
                }
            }
        }
        inputStreamReader.close();

        InputStream newInput = new ByteArrayInputStream(content.getBytes());
        return newInput;
    }

    public static InputStreamReader tranToInputStreamReader(InputStream input, String encode) throws UnsupportedEncodingException {
        return new InputStreamReader(input, encode);
    }
}