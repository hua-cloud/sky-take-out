package com.sky.controller.user;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController("userShopController")
@RequestMapping("/user/shop")
@Slf4j
@Api(tags = "店铺相关接口")
public class ShopController {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/status")
    @ApiOperation("获取店铺营业状态")
    public Result<Integer> getStatus() {
        String shopStatus = stringRedisTemplate.opsForValue().get("SHOP_STATUS");
        Integer status = Integer.valueOf(shopStatus);
        log.info("获取到的店铺营业状态为:{}", status == 1 ? "营业中" : "打烊中");
        return Result.success(status);
    }
}
