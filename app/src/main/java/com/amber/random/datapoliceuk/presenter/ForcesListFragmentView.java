package com.amber.random.datapoliceuk.presenter;

import com.amber.random.datapoliceuk.model.force.ForceItem;

import java.util.List;

public interface ForcesListFragmentView extends BaseView {
    void load(List<ForceItem> forces);
    void onClick(ForceItem forceItem);
}
