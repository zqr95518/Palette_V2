package com.hhigh.palette_v2.persistence;

import com.hhigh.palette_v2.domain.Palette;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by 乔然 on 2016/8/8.
 */
@Repository
public interface PaletteMapper {
    List<Palette> getall(Map map);

    void save(Palette palette);

    void delete(int id);

    void update(Palette palette);

    int getrowcount(Map map);

    List<Palette> autosearch(Map map);
}
