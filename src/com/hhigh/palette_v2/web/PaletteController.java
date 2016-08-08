package com.hhigh.palette_v2.web;

import com.hhigh.palette_v2.domain.Palette;
import com.hhigh.palette_v2.service.PaletteService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by 乔然 on 2016/8/5.
 */
@Controller
@RequestMapping("/PaletteController")
public class PaletteController {
    @Autowired
    PaletteService paletteService;

    @RequestMapping("/getAll")
    public void getAll(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Palette> records = paletteService.getall();
            JSONArray jsonArray = JSONArray.fromObject(records);
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html");
            response.getWriter().write(jsonArray.toString());
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @RequestMapping("/save")
    public void save(HttpServletRequest request, HttpServletResponse response)throws IOException {
        Palette palette = new Palette();
        response.setContentType("text/html;charset=utf-8");
        palette.setName(request.getParameter("name"));
        palette.setColor(request.getParameter("color"));
        JSONObject jsonObject = JSONObject.fromObject(palette);
        paletteService.save(palette);
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.getWriter().write(jsonObject.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }
}
