package com.bridgelabz.fundoonotes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundoonotes.model.Label;

@Repository
public interface LabelRepository  extends JpaRepository<Label,Integer> {


    List<Label> findAllByUserId(int userId);
    Label findByUserId(int userId);
    void deleteAllByUserId(int userId);
    Label findByLabelId(int labelId);
}

