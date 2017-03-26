package com.githup.ussheepsheep.web;

import com.githup.ussheepsheep.domain.Good;
import com.githup.ussheepsheep.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by daren on 2017/2/14.
 */
@RestController
@RequestMapping("/good")
public class GoodController {

    @Autowired
    private GoodService goodService;

    @ResponseBody
    @GetMapping("findAll")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(goodService.findAll());
    }

    @ResponseBody
    @PostMapping("save")
    public ResponseEntity saveOne(@RequestParam String name, @RequestParam String desc) {
        Good good = new Good();
        good.setGoodName(name);
        good.setGoodDesc(desc);
        goodService.saveOne(name, desc);
        return ResponseEntity.ok().build();
    }
}
