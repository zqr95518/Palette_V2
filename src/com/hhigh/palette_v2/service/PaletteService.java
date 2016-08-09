package com.hhigh.palette_v2.service;

import com.hhigh.palette_v2.domain.Palette;
import com.hhigh.palette_v2.persistence.PaletteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 乔然 on 2016/8/8.
 */
@Service("paletteService")
public class PaletteService {
    @Autowired
    PaletteMapper paletteMapper;

    public List<Palette> getall() {
        return paletteMapper.getall();
    }

    public void save(Palette palette) {
        paletteMapper.save(palette);
    }

    public void delete(String id) {
        paletteMapper.delete(id);
    }

    public void update(Palette palette) {
        paletteMapper.update(palette);
    }
}
