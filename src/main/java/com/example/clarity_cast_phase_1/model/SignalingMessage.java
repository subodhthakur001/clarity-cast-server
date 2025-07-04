package com.example.clarity_cast_phase_1.model;

import java.util.Objects;

public class SignalingMessage {
    private String type; // "offer", "answer", "candidate"
    private String senderId; // ID of the sender
    private String receiverId; // ID of the intended receiver (for direct messages)
    private String sdp; // Session Description Protocol (for offer/answer)
    private String candidate; // ICE Candidate (for network info)
    private String sdpMid; // For ICE Candidate
    private Integer sdpMLineIndex; // For ICE Candidate
    private String roomId; // To join a specific room

    public SignalingMessage(String type, String senderId, String receiverId, String sdp, String candidate, String sdpMid, Integer sdpMLineIndex, String roomId) {
        this.type = type;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.sdp = sdp;
        this.candidate = candidate;
        this.sdpMid = sdpMid;
        this.sdpMLineIndex = sdpMLineIndex;
        this.roomId = roomId;
    }
    public SignalingMessage(){}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getSdp() {
        return sdp;
    }

    public void setSdp(String sdp) {
        this.sdp = sdp;
    }

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public String getSdpMid() {
        return sdpMid;
    }

    public void setSdpMid(String sdpMid) {
        this.sdpMid = sdpMid;
    }

    public Integer getSdpMLineIndex() {
        return sdpMLineIndex;
    }

    public void setSdpMLineIndex(Integer sdpMLineIndex) {
        this.sdpMLineIndex = sdpMLineIndex;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "SignalingMessage{" +
                "type='" + type + '\'' +
                ", senderId='" + senderId + '\'' +
                ", receiverId='" + receiverId + '\'' +
                ", sdp='" + (sdp != null ? "..." : "null") + '\'' + // Avoid logging full SDP
                ", candidate='" + (candidate != null ? "..." : "null") + '\'' + // Avoid logging full candidate
                ", sdpMid='" + sdpMid + '\'' +
                ", sdpMLineIndex=" + sdpMLineIndex +
                ", roomId='" + roomId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SignalingMessage that = (SignalingMessage) o;
        return Objects.equals(type, that.type) &&
                Objects.equals(senderId, that.senderId) &&
                Objects.equals(receiverId, that.receiverId) &&
                Objects.equals(sdp, that.sdp) &&
                Objects.equals(candidate, that.candidate) &&
                Objects.equals(sdpMid, that.sdpMid) &&
                Objects.equals(sdpMLineIndex, that.sdpMLineIndex) &&
                Objects.equals(roomId, that.roomId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, senderId, receiverId, sdp, candidate, sdpMid, sdpMLineIndex, roomId);
    }
}