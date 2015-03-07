package com.ai.wx.entity.response;

/**
 * 响应消息之音乐消息<br> 
 * 〈功能详细描述〉
 *
 * @author 14040909
 */
public class ResponseMusicMessage extends ResponseBaseMessage {
    // 音乐
    private Music Music;

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        Music = music;
    }
}
