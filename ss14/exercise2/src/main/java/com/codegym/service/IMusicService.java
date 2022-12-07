package com.codegym.service;

import com.codegym.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMusicService {
    Page<Music> findAll(Pageable pageable);

    void save(Music music);

//    Optional<Music> findById(int id);
    Music findById(int id);
}
