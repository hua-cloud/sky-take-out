package com.sky.controller.notify;

import com.alibaba.fastjson.JSON;
import com.sky.result.Result;
import com.sky.websocket.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController()
@RequestMapping("/order")
public class OrderNotify {

    @Autowired
    private WebSocketServer webSocketServer;

    /**
     * 通过websocket向客户端浏览器推送消息(下单提醒)
     */
    @GetMapping("/place")
    public void placeOrder() {
        Map map = new HashMap();
        map.put("type", 1);
        map.put("orderId", 12345678);
        map.put("content", "订单号: 12345678");

        String json = JSON.toJSONString(map);
        webSocketServer.sendToAllClient(json);
    }

    /**
     * 通过websocket向客户端浏览器推送消息(催单提醒)
     */
    @GetMapping("/urge")
    public Result urgeOrder() {
        Map map = new HashMap();
        map.put("type", 2);
        map.put("orderId", 12345678);
        map.put("content", "订单号: 12345678");

        String json = JSON.toJSONString(map);
        webSocketServer.sendToAllClient(json);
        return Result.success();
    }
}
