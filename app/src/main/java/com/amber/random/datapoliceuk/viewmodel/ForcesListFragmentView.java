package com.amber.random.datapoliceuk.viewmodel;

import com.amber.random.datapoliceuk.model.force.ForceItem;

import java.util.List;

public interface ForcesListFragmentView extends IView {
    void load(List<ForceItem> forces);
    void onClick(ForceItem forceItem);
}
