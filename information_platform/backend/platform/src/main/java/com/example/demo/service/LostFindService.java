package com.example.demo.service;

import com.example.demo.model.jsonRequest.LostAFoundDelete;
import com.example.demo.model.jsonRequest.LostAFoundPublish;
import com.example.demo.model.ov.Result;

public interface LostFindService {
    Result lostFoundBoard();

    Result lostFoundMyboard(String userid);

    Result lostFoundDelete(LostAFoundDelete lostAFoundDelete);

    Result lostFoundPublish(LostAFoundPublish lostAFoundPublish);
}
