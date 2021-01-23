package io;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        String url = "D:\\download\\400T付费网课资源目录.txt";
        File file = new File(url);
        FileInputStream fileInputStream = new FileInputStream(url);
        if(file != null){
            System.out.println(file.getName());
        }
        HashSet<String> set = new HashSet<>();
        BufferedReader reader =  new BufferedReader( new InputStreamReader(new FileInputStream(url)));
        String content = null;
        StringBuilder builder = new StringBuilder();
        int i = 0;
        String first = null;
        String second = null;
        String third = null;
        String fourth = null;
        String fifth = null;
        String sixth = null;
        HashMap<String,FileEntity> map = new HashMap<>();
        ArrayList<FileEntity> list = new ArrayList<>();
        StringBuilder name = new StringBuilder();
        int line = 0;

        while ( (content = reader.readLine()) != null){
            String title = null;
            if(content.indexOf("目录：")>0){
                title = content;
            }else if(content.indexOf("━━")>0){
                String [] arr = content.split("━━");
                title = arr[arr.length-1];
            }
            if(name.indexOf(title) ==-1){
                name.append("-"+title);
                FileEntity entity = new FileEntity();
                entity.setIndex(name.toString());
                entity.setName(name.toString());
                list.add(entity);
            }
//            ++line;
//            StringBuilder indexPath = new StringBuilder("");
//            if(content.indexOf("目录：")>0){
//                first = content;
//            }else if(content.indexOf("━━")>0){
//                String []index = content.split("━━");
//                if(index.length == 1){
//                    second = content;
//                }else if(index.length == 2){
//                    third = content;
//                }else if(index.length == 3){
//                    fourth = content;
//                }else if(index.length == 4){
//                    fifth = content;
//                }else if(index.length == 5){
//                    sixth = content;
//                }else if(index.length == 6){
//                    System.out.println("------------------ errr");
//                    return;
//                }
//            }
//            StringBuilder name = new StringBuilder(first);
//            if(second != null){
//                name.append(second);
//            }
//            if(third != null){
//                name.append(third);
//            }
//            if(fourth != null){
//                name.append(fourth);
//            }
//            if(fifth != null){
//                name.append(fifth);
//            }
//            if(sixth != null){
//                name.append(sixth);
//            }
//            FileEntity entity = null;
//            String key = name.toString();
//            if(!map.containsKey(key)){
//                entity = new FileEntity();
//                entity.setIndex(key);
//                entity.setName(key);
//                list.add(entity);
//                map.put(key,entity);
//            }
            i++;
            if(i>100){
                System.out.println("test finish exit list");
                for(FileEntity item:list){
                    System.out.println(item.getName());
                }
                return;
            }
        }
    }
}
