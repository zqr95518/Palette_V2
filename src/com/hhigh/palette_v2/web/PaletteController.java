package com.hhigh.palette_v2.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 乔然 on 2016/8/5.
 */
@Controller
@RequestMapping("/PaletteController")
public class PaletteController {
    @RequestMapping("/getAll")
    public void getAll(HttpServletRequest request, HttpServletResponse response){
        try {
          /*  List<WeatherCityJson> cities = this.getAllCity();
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());
            JSONArray jsonarray = JSONArray.fromObject(cities, jsonConfig);*/
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html");
            response.getWriter().write(jsonarray.toString());
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
