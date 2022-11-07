package cn.har01d.alist_tvbox.web;

import cn.har01d.alist_tvbox.service.TvBoxService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/vod")
public class TvBoxController {
    private final TvBoxService tvBoxService;

    public TvBoxController(TvBoxService tvBoxService) {
        this.tvBoxService = tvBoxService;
    }

    @GetMapping
    public Object api(String site, String t, String ids, HttpServletRequest request) {
        log.debug("{} {} {}", request.getMethod(), request.getRequestURI(), request.getQueryString());
        log.info("site: {}  path: {}  folder: {}", site, ids, t);
        if (ids != null && !ids.isEmpty()) {
            return tvBoxService.getDetail(site, ids);
        } else if (t != null && !t.isEmpty()) {
            return tvBoxService.getMovieList(site, t);
        } else {
            return tvBoxService.getCategoryList(site);
        }
    }
}
