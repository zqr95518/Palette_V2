package com.hhigh.palette_v2.web;

import com.hhigh.palette_v2.domain.Palette;
import com.hhigh.palette_v2.service.PaletteService;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/save", method = {RequestMethod.POST}, consumes = "application/json")
    public void save(@RequestBody Palette palette, HttpServletRequest request, HttpServletResponse response)throws IOException {
        paletteService.save(palette);
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.getWriter().write(JSONObject.fromObject(palette).toString());
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping("/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response)throws IOException {
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");
        paletteService.delete(id);
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.getWriter().write(id);
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping("/update")
    public void update(HttpServletRequest request, HttpServletResponse response)throws IOException {
        Palette palette = new Palette();
        response.setContentType("text/html;charset=utf-8");
        palette.setName((String)request.getParameter("name"));
        palette.setColor((String)request.getParameter("color"));
        palette.setId((String)request.getParameter("id"));
        paletteService.update(palette);
        JSONObject jsonObject = JSONObject.fromObject(palette);
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.getWriter().write(jsonObject.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }
}
