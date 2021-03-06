package com.hhigh.palette_v2.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.hhigh.palette_v2.domain.Palette;
import com.hhigh.palette_v2.persistence.PaletteMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 乔然 on 2016/8/8.
 */
@Service("paletteService")
public class PaletteService {
    @Autowired
    PaletteMapper paletteMapper;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    private String namespace = "com.hhigh.palette_v2.persistence.PaletteMapper";

    public List<Palette> getall() {
        return paletteMapper.getall(null);
    }

    public List<Palette> getbypage(PageBounds pageBounds, String input_data) {
        List<Palette> data = null;
        try {
            SqlSession session = sqlSessionFactory.openSession();
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("input_data", input_data);
            data = session.selectList(namespace + ".getall", params, pageBounds);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public void save(Palette palette) {
        paletteMapper.save(palette);
    }

    public void delete(int id) {
        paletteMapper.delete(id);
    }

    public void update(Palette palette) {
        paletteMapper.update(palette);
    }

    public int getrowcount(String input_data) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("input_data", input_data);
        return paletteMapper.getrowcount(params);
    }
}
