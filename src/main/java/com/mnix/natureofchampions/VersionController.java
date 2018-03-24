package com.mnix.natureofchampions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class VersionController {
    @Value("${git.commit.id.describe-short}")
    private String version;

    @GetMapping("/version")
    public String version() {
        return version;
    }
}
