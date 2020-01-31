package main.gfs;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2020/1/31 9:48 PM
 */
public class GFSClient extends BaseGFSClient {

    private int chunkSize;

    private Map<String, Integer> fileChunkNum = new HashMap<>();
    /*
     * @param chunkSize: An integer
     */
    public GFSClient(int chunkSize) {
        // do intialization if necessary
        this.chunkSize = chunkSize;
    }

    /*
     * @param filename: a file name
     * @return: conetent of the file given from GFS
     */
    public String read(String filename) {
        // write your code here
        if (!fileChunkNum.containsKey(filename)){
            return null;
        }
        String content = "";
        int chuckNum = fileChunkNum.get(filename);
        for (int i = 0; i < chuckNum; i++){
            content += readChunk(filename, i);
        }
        return content;
    }

    /*
     * @param filename: a file name
     * @param content: a string
     * @return: nothing
     */
    public void write(String filename, String content) {
        // write your code here
        int chunkNum = content.length() / chunkSize + 1;
        if (content.length() % chunkSize == 0){
            chunkNum--;
        }
        fileChunkNum.put(filename, chunkNum);
        for (int i = 0; i < chunkNum; i++){
            int start = i * chunkSize;
            int end = (i + 1) * chunkSize < content.length() ? (i + 1) * chunkSize : content.length();
            String subContent = content.substring(start, end);
            writeChunk(filename, i, subContent);
        }
    }
}


class BaseGFSClient {
    private Map<String, String> chunk_list;
    public BaseGFSClient() {}
    public String readChunk(String filename, int chunkIndex) {
        // Read a chunk from GFS
        return "";
    }
    public void writeChunk(String filename, int chunkIndex, String content) {
        // Write a chunk to GFS
    }
}