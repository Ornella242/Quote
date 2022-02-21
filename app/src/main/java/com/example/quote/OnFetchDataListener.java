package com.example.quote;

import com.example.quote.Models.CategoryModel;

import java.util.Collection;
import java.util.List;

public interface OnFetchDataListener<T>{
    void onFetchData(List<T> list, String message);
    void onError(String message);
}
