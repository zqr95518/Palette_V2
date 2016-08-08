package com.hhigh.palette_v2.service;

import com.hhigh.palette_v2.persistence.PaletteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 乔然 on 2016/8/8.
 */
@Service("paletteService")
public class PaletteService {
    @Autowired
    PaletteMapper paletteMapper;
}
