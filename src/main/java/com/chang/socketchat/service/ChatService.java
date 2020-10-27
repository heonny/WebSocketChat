/**
 * ChatService는 ChatRoomRepository가 대체하므로 삭제
 */

//package com.chang.socketchat.service;
//
//import com.chang.socketchat.dto.ChatRoom;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.UUID;
//import javax.annotation.PostConstruct;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//
///**
// * 채팅방을 생성, 조회하고 하나의 세션에 메시지 발송을 하는 서비스를 아래와 같이 구현합니다.
// * <p>
// * 채팅방 Map은 서버에 생성된 모든 채팅방의 정보를 모아둔 구조체입니다.
// * <p>
// * 채팅룸의 정보 저장은 빠른구현을 위해
// * <p>
// * 일단 외부 저장소를 이용하지 않고 HashMap에 저장하는 것으로 구현하였습니다.
// * <p>
// * 채팅방 조회 – 채팅방 Map에 담긴 정보를 조회.
// * <p>
// * 채팅방 생성 – Random UUID로 구별ID를 가진 채팅방 객체를 생성하고 채탕방 Map에 추가.
// * <p>
// * 메시지 발송 – 지정한 Websocket 세션에 메시지를 발송.
// */
//@Slf4j
//@RequiredArgsConstructor
//@Service
//public class ChatService {
//
//  private final ObjectMapper objectMapper;
//  private Map<String, ChatRoom> chatRooms;
//
//  @PostConstruct
//  private void init() {
//    chatRooms = new LinkedHashMap<>();
//  }
//
//  public List<ChatRoom> findAllRoom() {
//    return new ArrayList<>(chatRooms.values());
//  }
//
//  public ChatRoom findRoomById(String roomId) {
//    return chatRooms.get(roomId);
//  }
//
//  public ChatRoom createRoom(String name) {
//    String randomId = UUID.randomUUID().toString();
//    ChatRoom chatRoom = ChatRoom.builder()
//        .roomId(randomId)
//        .name(name)
//        .build();
//    chatRooms.put(randomId, chatRoom);
//    return chatRoom;
//  }
//
//  public <T> void sendMessage(WebSocketSession session, T message) {
//    try {
//      session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));
//    } catch (IOException e) {
//      log.error(e.getMessage(), e);
//    }
//  }
//}