package com.may.serializable;

import java.io.*;
import java.util.Base64;

public class SerializablePractice {
    public static void main(String[] args) throws Exception{

        User user = new User("ayolo", "문아영", 22);
        byte[] serializedMember;

        try(ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()){
            try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)){
                objectOutputStream.writeObject(user);
                serializedMember = byteArrayOutputStream.toByteArray();
            }
        }
        System.out.println(Base64.getEncoder().encodeToString(serializedMember));

        String filename = "serializable.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        // 위에서 생성한 fileOutputStream 객체를 인자로 받는 ObjectOutputStream 객체를 생성

        objectOutputStream.writeObject(user);
        // 객체를 직렬화하여 파일에 저장
        objectOutputStream.close();
        fileOutputStream.close();

        // 파일로부터 객체를 읽어 객체 생성
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename));
        // Object로 리턴되므로 형변환 필요
        User user2 = (User)inputStream.readObject();

        System.out.println(user2.toString());
        inputStream.close();
    }
}
