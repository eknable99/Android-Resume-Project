package com.example.resumeproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Comment {
    private String mName;
    private String mComment;

    public Comment(String name, String comment){
        mName = name;
        mComment = comment;
    }

    public String getName() {
        return mName;
    }

    public String getComment() {
        return mComment;
    }

    private static int lastUserId = 0;

//    public static ArrayList<Comment> createCommentsList(int numComments){
////        ArrayList<Comment> comments = new ArrayList<Comment>();
////
////        for (int i = 1; i <= numComments; i++) {
////            comments.add(new Comment("Name ", "Comment"));
////        }
////
////        return comments;
////    }
    public static ArrayList<Comment> createCommentsList(Map<String, String> nameMap, Map<String, String> commentMap){
        Iterator nameMapIterator = nameMap.entrySet().iterator();
        ArrayList<Comment> comments = new ArrayList<>();

        while (nameMapIterator.hasNext()){
            Map.Entry nameMapElement = (Map.Entry)nameMapIterator.next();
            //Map.Entry commentMapElement = (Map.Entry)commentMapIterator.next();
            comments.add(new Comment(nameMapElement.getValue().toString(), commentMap.get(nameMapElement.getValue().toString())));
        }
        
        return comments;
    }

}
